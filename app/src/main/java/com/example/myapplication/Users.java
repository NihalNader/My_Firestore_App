package com.example.myapplication;

public class Users {
    String name,address,phone;
    
public Users(){}
    public Users(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public Users(String productname) {
//        this.productname = productname;
//    }
//
//    public String getProductname() {
//        return productname;
//    }
//
//    public void setProductname(String productname) {
//        this.productname = productname;
//    }
}