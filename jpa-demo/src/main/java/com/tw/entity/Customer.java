package com.tw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust")
public class Customer {
    @Id
    @Column(name = "cust_id")
    private int custId;
    @Column(name = "cname", length = 30)
    private String custName;
    @Column(length = 12)
    private String mobile;
    @Column(name = "cr_lmt")
    private double crLimit;

    public Customer(){}
    public Customer(int custId, String custName, String mobile, double crLimit) {
        this.custId = custId;
        this.custName = custName;
        this.mobile = mobile;
        this.crLimit = crLimit;
    }

    @Override
    public String toString() {
        return "Id: " + custId + ", Name: " + custName + ", Mobile: " + mobile + ", Limit: " + crLimit;
    }

    // Getters and Setters

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getCrLimit() {
        return crLimit;
    }

    public void setCrLimit(double crLimit) {
        this.crLimit = crLimit;
    }
}
