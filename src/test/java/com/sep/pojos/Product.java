package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown =true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "available",
        "product_name",
        "product_id",
        "teen",
        "type",
        "program_id",
        "program_code",
        "program_name",
        "start_date",
        "refund_date",
        "external_url",
        "terms",
        "prices"
})
@Data
public class Product {

    @JsonProperty("available")
    private String available;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_id")
    private String productId;

    private String teen;

    private String type;

    @JsonProperty("program_id")
    private int programId;

    @JsonProperty("program_code")
    private String programCode;

    @JsonProperty("program_name")
    private String programName;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("refund_date")
    private String refundDate;

    @JsonProperty("external_url")
    private String externalUrl;

    private String terms;

    private List<Price> prices;


    @JsonIgnoreProperties(ignoreUnknown =true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "active",
            "base_amount",
            "type",
            "upfront_discount",
            "upfront_discount_amount",
            "allow_coupons",
            "coupon_discount",
    })
    @Data
    public static class Price {

        private boolean active;

        @JsonProperty("product_name")
        private int baseAmount;

        private String type;

        @JsonProperty("upfront_discount")
        private boolean upfrontDiscount;

        @JsonProperty("upfront_discount_amount")
        private int upfrontDiscountAmount;

        @JsonProperty("allow_coupons")
        private Boolean allowCoupons;

        @JsonProperty("coupon_discount")
        private Integer couponDiscount;


    }



}
