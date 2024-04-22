package com.sep.pojos;
import com.sep.pojos.Prices.PricesData.Price.Receipt;

public class Coupon {

    private String promoCode;
    private boolean isValid;

    private String message;

    private int couponDiscount;

    private Receipt receipt;

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(int couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "promoCode='" + promoCode + '\'' +
                ", isValid=" + isValid +
                ", message='" + message + '\'' +
                ", couponDiscount=" + couponDiscount +
                ", receipt=" + receipt +
                '}';
    }
}
