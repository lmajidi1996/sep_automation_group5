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
public class Program {

    @JsonProperty("data")
    private ProgramData data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    @JsonPropertyOrder({
            "productId",
            "productType",
            "productLink",
            "lmsProgramId",
            "lmsProgramName",
            "lmsProgramCode",
            "startDate",
            "refundDate",
            "fullPrice",
            "discountAmount",
            "discountedPrice",
            "isForTeens"
    })
    @Data
    public static class ProgramData {

        @JsonProperty("productId")
        private int productId;

        @JsonProperty("productType")
        private String productType;

        @JsonProperty("productLink")
        private String productLink;

        @JsonProperty("lmsProgramId")
        private int lmsProgramId;

        @JsonProperty("lmsProgramName")
        private String lmsProgramName;

        @JsonProperty("lmsProgramCode")
        private String lmsProgramCode;

        @JsonProperty("startDate")
        private String startDate;

        @JsonProperty("refundDate")
        private String refundDate;

        @JsonProperty("fullPrice")
        private int fullPrice;

        @JsonProperty("discountAmount")
        private int discountAmount;

        @JsonProperty("discountedPrice")
        private int discountedPrice;

        @JsonProperty("isForTeens")
        private boolean isForTeens;

    }

}