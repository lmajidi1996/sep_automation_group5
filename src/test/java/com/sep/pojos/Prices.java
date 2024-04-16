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
            "price_id",
            "type",
            "allow_coupons",
            "receipt"
    })
    @lombok.Data
    public static class Data {

        @JsonProperty("price_id")
        private String priceId;

        @JsonProperty("type")
        private String type;

        @JsonProperty("allow_coupons")
        private Boolean allowCoupons;

        @JsonProperty("receipt")
        private Receipt receipt;


        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "payment_type",
                "payment_summary",
                "installment_summary"
        })
        public static class Receipt {

            @JsonProperty("payment_type")
            private String paymentType;

            @JsonProperty("payment_summary")
            private PaymentSummary paymentSummary;
            @JsonProperty("installment_summary")
            private InstallmentSummary installmentSummary;

            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "base_price",
                    "currency",
                    "one_time_discount",
                    "sub_total",
                    "fee",
                    "total"
            })
            public static class PaymentSummary {

                @JsonProperty("base_price")
                private int basePrice;

                @JsonProperty("currency")
                private String currency;

                @JsonProperty("one_time_discount")
                private int oneTimeDiscount;

                @JsonProperty("sub_total")
                private int subTotal;

                @JsonProperty("fee")
                private int fee;

                @JsonProperty("total")
                private int total;

            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "base_price",
                    "number_of_installments",
                    "installment_price",
                    "sub_total",
                    "fee",
                    "total"
            })
            public static class InstallmentSummary {
                @JsonProperty("base_price")
                private int basePrice;

                @JsonProperty("number_of_installments")
                private int numberOfInstallments;

                @JsonProperty("installment_price")
                private int installmentPrice;

                @JsonProperty("sub_total")
                private int subTotal;

                @JsonProperty("fee")
                private int fee;

                @JsonProperty("total")
                private int total;

            }

        }

    }

}