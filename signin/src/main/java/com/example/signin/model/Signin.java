package com.example.signin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Signin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String emailaddress;
    private String password;
    
    public Signin() {
    }

    

    public Signin(int no, String emailaddress, String password) {
        this.no = no;
        this.emailaddress = emailaddress;
        this.password = password;
    }



    public int getNo() {
        return no;
    }



    public void setNo(int no) {
        this.no = no;
    }



    public String getEmailaddress() {
        return emailaddress;
    }



    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }


    

    
}
