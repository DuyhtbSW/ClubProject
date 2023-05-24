/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Admin {
    private String iD, passWord;

    public Admin() {
    }

    public Admin(String iD, String passWord) {
        this.iD = iD;
        this.passWord = passWord;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    

    @Override
    public String toString() {
        return "Admin{" + "iD=" + iD + ", passWord=" + passWord + '}';
    }
    
    
}
