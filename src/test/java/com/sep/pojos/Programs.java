package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown =true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "success",
        "status"
})
@Data
public class Programs {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    @JsonIgnoreProperties(ignoreUnknown =true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "product_id",
            "product_type",
            "product_link",
            "lms_program_id",
            "lms_program_name",
            "lms_program_code",
            "lms_program_start_date",
            "lms_program_refund_date",
            "full_price",
            "discount_amount",
            "discount_price",
            "is_for_teens"
    })

    @lombok.Data
    public static class Data {

        @JsonProperty("product_id")
        private String productId;

        @JsonProperty("product_type")
        private String productType;

        @JsonProperty("product_link")
        private String productLink;

        @JsonProperty("lms_program_id")
        private String lmsProgramId;

        @JsonProperty("lms_program_name")
        private String lmsProgramName;

        @JsonProperty("lms_program_code")
        private String lmsProgramCode;

        @JsonProperty("lms_program_start_date")
        private String lmsProgramStartDate;

        @JsonProperty("lms_program_refund_date")
        private String lmsProgramRefundDate;

        @JsonProperty("full_price")
        private int fullPrice;

        @JsonProperty("discount_amount")
        private int discountAmount;

        @JsonProperty("discount_price")
        private int discountPrice;

        @JsonProperty("is_for_teens")
        private boolean isForTeens;

    }



}
