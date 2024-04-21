package com.sep.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "first_name",
        "last_name",
        "email",
        "phone_number",
        "referral_source",
        "parent_first_name",
        "parent_last_name",
        "parent_email",
        "parent_phone_number"
})
@Data
public class Customer {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("referral_source")
    private String referralSource;

    @JsonProperty("parent_first_name")
    private String parentFirstName;

    @JsonProperty("parent_last_name")
    private String parentLastName;

    @JsonProperty("parent_email")
    private String parentEmail;

    @JsonProperty("parent_phone_number")
    private String parentPhoneNumber;




}
