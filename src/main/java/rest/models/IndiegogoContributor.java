package rest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoContributor {
    @Expose
    private int id; // UserId

    @Expose
    private String created_at;

    @Expose
    private int amount;

    @Expose
    private String by;

    @Expose
    private rest.models.IndiegogoPerk perk;

    public int getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getAmount() {
        return amount;
    }

    public String getBy() {
        return by;
    }

    public IndiegogoPerk getPerk() {
        return perk;
    }

    @Override
    public String toString() {
        String result = "id: " + Integer.toString(id);
        if (by != null)
            result += " | By: " + by;
        result += " | Amount: " + Integer.toString(amount);
        return result;
    }

    /*
    {"id":19679790,
    "created_at":"2017-02-28T23:39:54-08:00",
    "avatar_url":"https://g2.iggcdn.com/assets/individuals/missing/cubepeep-92c189461486a7ac102ded895c8bfe02.png",
    "amount":419,
    "by":"milkoh",
    "perk":{
        "id":3867578,"campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone",
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
    },
        "appearance":{"private_amount":false}
    }*/
}
