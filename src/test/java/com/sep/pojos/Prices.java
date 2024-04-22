package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "data",
        "success",
        "status"
})
public class Prices{

    @JsonProperty("data")
    private PricesData data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
            "prices"
    })
    public static class PricesData {
        @JsonProperty("prices")
        private List<Price> prices;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({
                "priceId",
                "type",
                "allowCoupons",
                "receipt"
        })
        public static class Price {
            @JsonProperty("priceId")
            private String priceId;

            @JsonProperty("type")
            private String type;

            @JsonProperty("allowCoupons")
            private boolean allowCoupons;

            @JsonProperty("receipt")
            private Receipt receipt;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonPropertyOrder({
                    "paymentType",
                    "paymentSummary",
                    "installmentSummary"
            })
            public static class Receipt {

                @JsonProperty("paymentType")
                private String paymentType;

                @JsonProperty("paymentSummary")
                private PaymentSummary paymentSummary;

                @JsonProperty("installmentSummary")
                private InstallmentSummary installmentSummary;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                @JsonPropertyOrder({
                        "basePrice",
                        "currency",
                        "oneTimeDiscount",
                        "couponDiscount",
                        "subTotal",
                        "fee",
                        "total"
                })
                public static class PaymentSummary {
                    @JsonProperty("basePrice")
                    private int basePrice;

                    @JsonProperty("currency")
                    private String currency;

                    @JsonProperty("oneTimeDiscount")
                    private int oneTimeDiscount;

                    @JsonProperty("couponDiscount")
                    private int couponDiscount;

                    @JsonProperty("subTotal")
                    private int subTotal;

                    @JsonProperty("fee")
                    private double fee;

                    @JsonProperty("total")
                    private double total;

                }

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                @JsonPropertyOrder({
                        "basePrice",
                        "numberOfInstallments",
                        "installmentPrice",
                        "couponDiscount",
                        "subTotal",
                        "fee",
                        "total"
                })
                public static class InstallmentSummary {
                    @JsonProperty("basePrice")
                    private int basePrice;

                    @JsonProperty("numberOfInstallments")
                    private int numberOfInstallments;

                    @JsonProperty("installmentPrice")
                    private int installmentPrice;

                    @JsonProperty("couponDiscount")
                    private int couponDiscount;

                    @JsonProperty("subTotal")
                    private int subTotal;

                    @JsonProperty("fee")
                    private double fee;

                    @JsonProperty("total")
                    private double total;
                }

            }

        }

    }

}