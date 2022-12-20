package com.javatechie.k8s.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Admin 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;  //primary key
    
    @Column
    private String email;


    @Column
    private String fullName;

    @Column
    private String password;


    public Long getUserid() {
        return adminId;
    }

    public void setadminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
