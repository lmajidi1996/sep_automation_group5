package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "success",
        "status"
})
@Data
public class Prices {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "priceId",
            "type",
            "allowCoupons",
            "receipt"
    })
    @lombok.Data
    public static class Data {

        @JsonProperty("priceId")
        private String priceId;

        @JsonProperty("type")
        private String type;

        @JsonProperty("allowCoupons")
        private Boolean allowCoupons;

        @JsonProperty("receipt")
        private Receipt receipt;


        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
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

            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "basePrice",
                    "currency",
                    "oneTimeDiscount",
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

                @JsonProperty("subTotal")
                private int subTotal;

                @JsonProperty("fee")
                private int fee;

                @JsonProperty("total")
                private int total;

            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "basePrice",
                    "numberOfInstallments",
                    "installmentPrice",
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

                @JsonProperty("subTotal")
                private int subTotal;

                @JsonProperty("fee")
                private int fee;

                @JsonProperty("total")
                private int total;

            }

        }

    }

}