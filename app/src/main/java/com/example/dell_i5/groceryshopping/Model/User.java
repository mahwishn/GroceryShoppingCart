package com.example.dell_i5.groceryshopping.Model;

/**
 * Created by Dell-i5 on 29/04/2018.
 */

public class User {

    private String name;
    private String password;
    private String Phone;

    public User() {
    }

    public User(String Pname, String Ppassword) {


        name = Pname;
        password = Ppassword;

    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone)
    {
        Phone = phone;
    }

    public String setname(String Pname) {
        name = Pname;
        return name;
    }

    public String getName() {
        return name;
    }

    public String getpassword() {
        return password;
    }
}