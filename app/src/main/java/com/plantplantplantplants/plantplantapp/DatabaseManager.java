package com.plantplantplantplants.plantplantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper
{
    //DB name, version
    private static final String DATABASE_NAME = "Store.db";
    private static final int DATABASE_VERSION = 1;

    String[] tables;
    String[] sqlStatements;

    //class constructor
    public DatabaseManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Drop existing tables
        for (int i=0;i<tables.length;i++)
            db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
        //create them
        for (int i=0;i<tables.length;i++)
            db.execSQL(sqlStatements[i]);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing tables
        for (int i=0;i<tables.length;i++)
            db.execSQL("DROP TABLE IF EXISTS " + tables[i]);

        // Create tables again
        onCreate(db);
    }

    //Create, delete database
    public void createDatabase(Context context)
    {
        SQLiteDatabase mDatabase;
        mDatabase = context.openOrCreateDatabase(
                DATABASE_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
    }
    public void deleteDatabase(Context context)
    {
        context.deleteDatabase(DATABASE_NAME);
    }

    public void createTables(String[] tables, String[] statements)
    {
        this.tables=tables;
        this.sqlStatements=statements;
    }

    void addRecord(ContentValues values, String tableName, String fields[], String record[])
    {
        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<record.length;i++)
            values.put(fields[i], record[i]);
        // Insert the row
        db.insert(tableName, null, values);
        db.close(); //close database connection
    }

    //Validate userName and password
    public boolean logInValidation(String tableName, String id, String password)
    {
        //id
        String selectUserName = "SELECT userName FROM " + tableName +
                " where userName = \""+id+"\"";
        String selectPassword = "SELECT password FROM " + tableName +
                " where password = \""+password+"\"" +
                " and userName = \""+id+"\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor userNameCursor = db.rawQuery(selectUserName, null);
        Cursor passwordCursor = db.rawQuery(selectPassword, null);
        String userIDfound;
        String passwordFound;

        if (userNameCursor.moveToFirst())
        {
            userIDfound = userNameCursor.getString(0);

            if (userIDfound != null)
            {
                if (passwordCursor.moveToFirst())
                {
                    passwordFound = passwordCursor.getString(0);
                    return true;
                }
                return false;
            }
            else
                return false;
        }
        return false;
    }

    //Retrieves a row of audience data specified by userName
    public String[] retrieveAudience(String userName)
    {
        String[] row = new String[8];

        String query = "SELECT * from tbl_audience" +
                " where userName = \"" + userName + "\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = cursor.getString(i);
            }
        }

        return row;
    }
    public String[] retrieveAdmin(String userName)
    {
        String[] row = new String[5];

        String query = "SELECT * from tbl_admin" +
                " where userName = \"" + userName + "\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = cursor.getString(i);
            }
        }

        return row;
    }

    //Retrieves a row of audience data specified by email
    public String[] retrieveAudiencebyEmail(String email)
    {
        String[] row = new String[8];

        String query = "SELECT * from tbl_audience" +
                " where email_id = \"" + email + "\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = cursor.getString(i);
            }
        }

        return row;
    }

    public void updateInfo(ContentValues values, String tableName, String fields[],String record[])
    {
        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=1;i<record.length;i++)
            values.put(fields[i], record[i]);
        db.update(tableName, values, fields[0] + " = ?", new String[] { record[0] });
    }
    public void updateBookingInfo(ContentValues values, String tableName, String fields[],String record[])
    {
        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=1;i<record.length;i++)
            values.put(fields[i], record[i]);
        db.update(tableName, values, fields[1] + " = ?", new String[] { record[1] });
    }

    public String[] retrieveMovie(String movieName)
    {
        String[] row = new String[4];
        String query = "SELECT * from tbl_movies" +
                " where movieName = \"" + movieName + "\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            for (int i = 0; i < row.length; i++)
            {
                row[i] = cursor.getString(i);
            }
        }

        return row;
    }

    //bookings purchased by a specified user
    public List getBooking(String email)
    {
        List table = new ArrayList(); //to store all rows
        String selectQuery = "SELECT booking_id, movieName, paymentDate, amountPaid, showDate, showTime" +
                ", booking_status FROM tbl_booking " +
                "join tbl_movies using (movie_id) " +
                "where email_id = \"" + email +"\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList row=new ArrayList(); //to store one row
        //scroll over rows and store each row in an array list object
        if (cursor.moveToFirst())
        {
            do
            { // for each row
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row.add(cursor.getString(i));
                }

                table.add(row); //add row to the list
                row = new ArrayList();
            } while (cursor.moveToNext());
        }

        // return table as a list
        return table;
    }

    // Read all records
    public List getTable(String tableName)
    {
        List table = new ArrayList(); //to store all rows
        // Select all records
        String selectQuery = "SELECT  * FROM " + tableName;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList row=new ArrayList(); //to store one row
        //scroll over rows and store each row in an array list object
        if (cursor.moveToFirst())
        {
            do
            { // for each row
                for (int i = 0; i < cursor.getColumnCount(); i++)
                {
                    row.add(cursor.getString(i));
                }

                table.add(row); //add row to the list
                row = new ArrayList();
            } while (cursor.moveToNext());
        }

        // return table as a list
        return table;
    }

    public ArrayList<String> findBookingbyID(int id)
    {
        String selectQuery = "SELECT * FROM tbl_booking " +
                "WHERE booking_id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList row = new ArrayList();
        if (cursor.moveToFirst())
        {
            do
            {
                for (int i = 0; i < cursor.getColumnCount(); i++)
                {
                    row.add(cursor.getString(i));
                }
            } while (cursor.moveToNext());
        }

        //return a booking data
        //specified by the primary key "booking_id"
        return row;
    }

    //Populates seed data if tables are empty
    public void populateSeedData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        Seeddata seedData = new Seeddata();

        String selectAccount = "SELECT count(*) FROM tbl_account";
        String selectProduct = "SELECT count(*) FROM tbl_product";

        ArrayList row=new ArrayList();

        Cursor cursor = db.rawQuery(selectAccount, null);
        cursor.moveToFirst();

        if (cursor.getInt(0) == 0)
        {
            for(int i = 0; i < seedData.accounts.size(); i++)
            {
                addRecord(contentValues, tables[0], Account.field, seedData.accounts.get(i).records);
            }
        }
        cursor.close();

        cursor = db.rawQuery(selectProduct, null);
        cursor.moveToFirst();
        if (cursor.getInt(0) == 0)
        {
            for(int i = 0; i < seedData.products.size(); i++)
            {
                addRecord(contentValues, tables[1], Product.field, seedData.products.get(i).records);
            }
        }

    }
}