package rest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoPerk {

    @Expose
    private int id;

    @Expose
    private int amount;

    @Expose
    private int number_claimed;

    @Expose
    private int number_available;

    @Expose
    private String description;

    @Expose
    private String label;

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getNumber_available() {
        return number_available;
    }

    public int getNumber_claimed() {
        return number_claimed;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    /*
    "id":3867578,
    "campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone",
    "amount":349,
    "description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.",
    "number_claimed":345,
    "number_available":600,
    "estimated_delivery_date":"2017-11-15T00:00:00-08:00",
    "shipping_address_required":true,
    "label":"The Gemini Early-bird Special",
    "validation_errors":null,
    "featured":true,
    "non_tax_deductible_amount":null
    */
}
