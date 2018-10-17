package com.university.soa.bus;

public class Addata {
    String Ename;
    String Ecode;
    String Ephone;
    String Epass;

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEcode() {
        return Ecode;
    }

    public void setEcode(String ecode) {
        Ecode = ecode;
    }

    public String getEphone() {
        return Ephone;
    }

    public void setEphone(String ephone) {
        Ephone = ephone;
    }

    public String getEpass() {
        return Epass;
    }

    public void setEpass(String epass) {
        Epass = epass;
    }

    public Addata(String name,String code,String number,String pass){
        this.Ecode=code;
        this.Ename=name;
        this.Epass=pass;
        this.Ephone=number;
    }
}
