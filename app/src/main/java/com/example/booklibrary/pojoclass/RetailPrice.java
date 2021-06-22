
package com.example.booklibrary.pojoclass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RetailPrice {

    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
