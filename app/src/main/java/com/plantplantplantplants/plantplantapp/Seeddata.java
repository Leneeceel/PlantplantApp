package com.plantplantplantplants.plantplantapp;

import java.util.ArrayList;

public class Seeddata
{
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Cart> carts = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    public Seeddata()
    {
        //Accounts
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        Account a4 = new Account();

        a1.records[1] = "mick12";
        a1.records[2] = "mick12";
        a1.records[3] = "Michael";
        a1.records[4] = "Jackson";
        a1.records[5] = "7 Pape Ave.";
        a1.records[6] = "Toronto";
        a1.records[7] = "ON";
        a1.records[8] = "U";

        a2.records[1] = "jane11";
        a2.records[2] = "jane11";
        a2.records[3] = "Jane";
        a2.records[4] = "Jones";
        a2.records[5] = "22 Broadview Rd.";
        a2.records[6] = "Toronto";
        a2.records[7] = "ON";
        a2.records[8] = "U";

        a3.records[1] = "homer99";
        a3.records[2] = "homer99";
        a3.records[3] = "Homer";
        a3.records[4] = "Simpson";
        a3.records[5] = "77 Somewhere Ave.";
        a3.records[6] = "Scarborough";
        a3.records[7] = "ON";
        a3.records[8] = "U";

        a4.records[1] = "someone";
        a4.records[2] = "someone";
        a4.records[3] = "Someone";
        a4.records[4] = "Dead";
        a4.records[5] = "829 Nowhere Rd.";
        a4.records[6] = "Nowhere";
        a4.records[7] = "??";
        a4.records[8] = "U";

        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);

        //Products
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();
        Product p6 = new Product();
        Product p7 = new Product();
        Product p8 = new Product();
        Product p9 = new Product();
        Product p10 = new Product();
        Product p11 = new Product();
        Product p12 = new Product();
        Product p13 = new Product();
        Product p14 = new Product();
        Product p15 = new Product();
        Product p16 = new Product();
        Product p17 = new Product();
        Product p18 = new Product();
        Product p19 = new Product();
        Product p20 = new Product();
        Product p21 = new Product();
        Product p22 = new Product();
        Product p23 = new Product();
        Product p24 = new Product();
        Product p25 = new Product();
        Product p26 = new Product();
        Product p27 = new Product();
        Product p28 = new Product();
        Product p29 = new Product();
        Product p30 = new Product();

        p1.records[1] = "Harry Potter";
        p1.records[2] = "74.22";
        p1.records[3] = "Book";
        p1.records[4] = "Harry Potter series";
        p1.records[5] = "73";

        p2.records[1] = "Basic C# and OOP";
        p2.records[2] = "83.27";
        p2.records[3] = "Book";
        p2.records[4] = "C# and Object Oriented Programming";
        p2.records[5] = "16";

        p3.records[1] = "A-Z of ASP.NET Core 2";
        p3.records[2] = "129.42";
        p3.records[3] = "Book";
        p3.records[4] = "Web Application with ASP.NET Core 2";
        p3.records[5] = "39";

        p4.records[1] = "How to Web Design";
        p4.records[2] = "86.31";
        p4.records[3] = "Book";
        p4.records[4] = "Web design with HTML and CSS";
        p4.records[5] = "65";

        p5.records[1] = "Debugging Principles";
        p5.records[2] = "51.87";
        p5.records[3] = "Book";
        p5.records[4] = "Debugging with C#";
        p5.records[5] = "96";

        p6.records[1] = "Quality Assurance";
        p6.records[2] = "84.64";
        p6.records[3] = "Book";
        p6.records[4] = "QA for beginners";
        p6.records[5] = "53";

        p7.records[1] = "Amazing Humidifier";
        p7.records[2] = "499.23";
        p7.records[3] = "Appliances";
        p7.records[4] = "A humidifier that humidifies an area";
        p7.records[5] = "77";

        p8.records[1] = "The-dehumidifier";
        p8.records[2] = "95.24";
        p8.records[3] = "Appliances";
        p8.records[4] = "A dehumidifier that dehumidifies an area";
        p8.records[5] = "84";

        p9.records[1] = "Faster Robot Vacuum";
        p9.records[2] = "852.31";
        p9.records[3] = "Appliances";
        p9.records[4] = "The robot vacuum! Awesome!";
        p9.records[5] = "72";

        p10.records[1] = "Food Processor";
        p10.records[2] = "512.31";
        p10.records[3] = "Appliances";
        p10.records[4] = "It will make your cooking easier!";
        p10.records[5] = "42";

        p11.records[1] = "Toasty Toaster";
        p11.records[2] = "93.16";
        p11.records[3] = "Appliances";
        p11.records[4] = "Buy a new toaster and get one for free!";
        p11.records[5] = "82";

        p12.records[1] = "The Fridge";
        p12.records[2] = "993.16";
        p12.records[3] = "Appliances";
        p12.records[4] = "A 80cm x 80cm x 80cm square fridge";
        p12.records[5] = "13";

        p13.records[1] = "Comfy Couch";
        p13.records[2] = "825.11";
        p13.records[3] = "Furniture";
        p13.records[4] = "As comfy as lying down in bed";
        p13.records[5] = "26";

        p14.records[1] = "Your KING BED";
        p14.records[2] = "1882.16";
        p14.records[3] = "Furniture";
        p14.records[4] = "A 999cm x 999cm x 999cm bed. THE BED.";
        p14.records[5] = "5";

        p15.records[1] = "Greek Antique Table";
        p15.records[2] = "9924.52";
        p15.records[3] = "Furniture";
        p15.records[4] = "The table you've been waiting for";
        p15.records[5] = "24";

        p16.records[1] = "Simple Chairs";
        p16.records[2] = "49.99";
        p16.records[3] = "Furniture";
        p16.records[4] = "A set of 4 chairs";
        p16.records[5] = "58";

        p17.records[1] = "Lepidium Sofa";
        p17.records[2] = "1962.13";
        p17.records[3] = "Furniture";
        p17.records[4] = "A decent sofa!";
        p17.records[5] = "19";

        p18.records[1] = "King Living Sofa";
        p18.records[2] = "992.15";
        p18.records[3] = "Furniture";
        p18.records[4] = "The sofa that a king used to live on";
        p18.records[5] = "62";

        p19.records[1] = "Samsung Explosive Phone";
        p19.records[2] = "952.14";
        p19.records[3] = "Electronics";
        p19.records[4] = "Dangerous!";
        p19.records[5] = "94";

        p20.records[1] = "Pixel 3";
        p20.records[2] = "1299.96";
        p20.records[3] = "Electronics";
        p20.records[4] = "Google Phone v3!";
        p20.records[5] = "42";

        p21.records[1] = "Apple Explosive Phone";
        p21.records[2] = "1853.24";
        p21.records[3] = "Electronics";
        p21.records[4] = "As dangerous as Samsung Phones!";
        p21.records[5] = "84";

        p22.records[1] = "Pixel 2";
        p22.records[2] = "899.52";
        p22.records[3] = "Electronics";
        p22.records[4] = "Google Phone v2";
        p22.records[5] = "51";

        p23.records[1] = "Pixel 1";
        p23.records[2] = "599.15";
        p23.records[3] = "Electronics";
        p23.records[4] = "Google Phone v1";
        p23.records[5] = "32";

        p24.records[1] = "Pixel 0";
        p24.records[2] = "499.11";
        p24.records[3] = "Electronics";
        p24.records[4] = "Google Phone Prototype?!";
        p24.records[5] = "81";

        p25.records[1] = "Vitamins";
        p25.records[2] = "58.23";
        p25.records[3] = "Health";
        p25.records[4] = "Delicious and healthy!";
        p25.records[5] = "81";

        p26.records[1] = "Vitality";
        p26.records[2] = "491.41";
        p26.records[3] = "Health";
        p26.records[4] = "Super Power!!!!!!!!";
        p26.records[5] = "24";

        p27.records[1] = "Digestives";
        p27.records[2] = "83.21";
        p27.records[3] = "Health";
        p27.records[4] = "These will help you digest!";
        p27.records[5] = "61";

        p28.records[1] = "Cannabis";
        p28.records[2] = "85.12";
        p28.records[3] = "Health";
        p28.records[4] = "Marijuana use for medical purpose";
        p28.records[5] = "28";

        p29.records[1] = "Digest-T";
        p29.records[2] = "81.53";
        p29.records[3] = "Health";
        p29.records[4] = "Good for stomach aches";
        p29.records[5] = "67";

        p30.records[1] = "Vitamin D3";
        p30.records[2] = "73.14";
        p30.records[3] = "Health";
        p30.records[4] = "Vitamin D3, a must have item";
        p30.records[5] = "44";

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);
        products.add(p10);
        products.add(p11);
        products.add(p12);
        products.add(p13);
        products.add(p14);
        products.add(p15);
        products.add(p16);
        products.add(p17);
        products.add(p18);
        products.add(p19);
        products.add(p20);
        products.add(p21);
        products.add(p22);
        products.add(p23);
        products.add(p24);
        products.add(p25);
        products.add(p26);
        products.add(p27);
        products.add(p28);
        products.add(p29);
        products.add(p30);

//        //Orders
//        Order o1 = new Order();
//        Order o2 = new Order();
//        Order o3 = new Order();
//        Order o4 = new Order();
//        Order o5 = new Order();
//        Order o6 = new Order();
//
//        o1.records[1] = "1";
//        o1.records[2] = "1";
//        o1.records[3] = "2019-01-12";
//
//        o2.records[1] = "1";
//        o2.records[2] = "2";
//        o2.records[3] = "2019-01-14";
//
//        o3.records[1] = "2";
//        o3.records[2] = "3";
//        o3.records[3] = "2019-01-18";
//
//        o4.records[1] = "3";
//        o4.records[2] = "4";
//        o4.records[3] = "2019-01-21";
//
//        o5.records[1] = "4";
//        o5.records[2] = "5";
//        o5.records[3] = "2019-02-16";
//
//        o6.records[1] = "4";
//        o6.records[2] = "6";
//        o6.records[3] = "2019-03-03";
//
//        orders.add(o1);
//        orders.add(o2);
//        orders.add(o3);
//        orders.add(o4);
//        orders.add(o5);
//        orders.add(o6);
//
//        //Carts
//        Cart c1 = new Cart();
//        Cart c2 = new Cart();
//        Cart c3 = new Cart();
//        Cart c4 = new Cart();
//        Cart c5 = new Cart();
//        Cart c6 = new Cart();
//
//        c1.records[1] = "3";
//        c1.records[2] = "1";
//        c1.records[3] = "";
//        c1.records[4] = "";
//
//        c2.records[1] = "2";
//        c2.records[2] = "1";
//        c2.records[3] = "";
//        c2.records[4] = "";
//
//        c3.records[1] = "4";
//        c3.records[2] = "2";
//        c3.records[3] = "";
//        c3.records[4] = "";
//
//        c4.records[1] = "1";
//        c4.records[2] = "3";
//        c4.records[3] = "";
//        c4.records[4] = "";
//
//        c5.records[1] = "2";
//        c5.records[2] = "4";
//        c5.records[3] = "";
//        c5.records[4] = "";
//
//        c6.records[1] = "6";
//        c6.records[2] = "4";
//        c6.records[3] = "";
//        c6.records[4] = "";


    }
}
