package com.sep.step_definition.getting_started;

import com.sep.pojos.prices.Prices;
import com.sep.pojos.prices.data.Receipt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class APITest {

    private Response response;


    @Given("Accept header is {string}")
    public void accept_header_is(String string) {
        given().accept(ContentType.JSON);
    }

    @When("I send a get request to the product endpoint {string}")
    public void i_send_a_get_request_to_the_product_endpoint(String string) {
        response = when().get(string);

    }

    @Then("the status code should be {string}")
    public void the_status_code_should_be(String string) {
        response.then().statusCode(200);
        response.prettyPeek();
    }



    @Then("the response body should contain priceId, type and receipt")
    public void the_response_body_should_contain_price_id_type_and_receipt() {
        Prices pricesRespond = response.as(Prices.class);

        assert pricesRespond.getData().getPrices().get(0).getType() != null;
        assert pricesRespond.getData().getPrices().get(0).getPriceId() != null;
        assert pricesRespond.getData().getPrices().get(0).getReceipt()!= null;

    }

    @Then("the receipt should contain paymentType and PaymentSummary")
    public void the_receipt_should_contain_payment_type_and_payment_summary() {

        Prices pricesRespond = response.as(Prices.class);

        Receipt receipt = pricesRespond.getData().getPrices().get(0).getReceipt();

        assert receipt.getPaymentType() != null;
        assert receipt.getPaymentSummary()!= null;

    }

}
