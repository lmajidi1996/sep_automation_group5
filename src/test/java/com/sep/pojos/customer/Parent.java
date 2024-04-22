package com.sep.pojos.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "parentFirstName",
        "parentLastName",
        "parentEmail",
        "parentPhoneNumber"
})
@Data
public class Parent {


    @JsonProperty("parentFirstName")
    private String parentFirstName;

    @JsonProperty("parentLastName")
    private String parentLastName;

    @JsonProperty("parentEmail")
    private String parentEmail;

    @JsonProperty("parentPhoneNumber")
    private String parentPhoneNumber;

}
