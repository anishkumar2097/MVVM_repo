
package com.example.booklibrary.pojoclass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RetailPrice__1 {

    @SerializedName("amountInMicros")
    @Expose
    private long amountInMicros;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;

    public long getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(long amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
