package rest.models.response;

import com.google.gson.annotations.Expose;
import rest.models.IndiegogoContributor;
import rest.models.IndiegogoPagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoContributorsGetResponse {

    @Expose
    private List<IndiegogoContributor> response;

    @Expose
    private int count;

    @Expose
    private IndiegogoPagination pagination;

    @Expose
    private String error;

    @Expose
    private String error_description;

    public List<IndiegogoContributor> getResponse() {
        return response;
    }

    public int getCount() {
        return count;
    }

    public IndiegogoPagination getPagination() {
        return pagination;
    }

    public String getError() {
        return error;
    }

    public String getError_description() {
        return error_description;
    }

    /*
    {"error":"forbidden","error_description":"The action you requested was forbidden."}
    {
        "response":
            [
                {
                    "id":19679790,
                    "created_at":"2017-02-28T23:39:54-08:00",
                    "avatar_url":"https://g2.iggcdn.com/assets/individuals/missing/cubepeep-92c189461486a7ac102ded895c8bfe02.png",
                    "amount":419,
                    "by":"milkoh",
                    "perk":{
                        "id":3867578,
                        "campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone",
                        "amount":349,
                        "description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.","number_claimed":345,"number_available":600,"estimated_delivery_date":"2017-11-15T00:00:00-08:00","shipping_address_required":true,"label":"The Gemini Early-bird Special","validation_errors":null,"featured":true,"non_tax_deductible_amount":null},"appearance":{"private_amount":false}},{"id":19679739,"created_at":"2017-02-28T23:34:17-08:00","avatar_url":"/assets/individuals/missing/thumbnail-c2d15a9c26ca9d1139634647e099dddd512acb816141a436dbcb84cf09a807cb.png","amount":419,"by":"Tetsuyasu Yamada","perk":{"id":3867578,"campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone","amount":349,"description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.","number_claimed":345,"number_available":600,"estimated_delivery_date":"2017-11-15T00:00:00-08:00","shipping_address_required":true,"label":"The Gemini Early-bird Special","validation_errors":null,"featured":true,"non_tax_deductible_amount":null},"appearance":{"private_amount":false}},{"id":19679718,"created_at":"2017-02-28T23:31:44-08:00","avatar_url":"https://g2.iggcdn.com/assets/individuals/missing/cubepeep-92c189461486a7ac102ded895c8bfe02.png","amount":379,"by":"Anonymous","perk":{"id":3867578,"campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone","amount":349,"description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.","number_claimed":345,"number_available":600,"estimated_delivery_date":"2017-11-15T00:00:00-08:00","shipping_address_required":true,"label":"The Gemini Early-bird Special","validation_errors":null,"featured":true,"non_tax_deductible_amount":null},"appearance":{"private_amount":false}},{"id":19679697,"created_at":"2017-02-28T23:29:41-08:00","avatar_url":"/assets/individuals/missing/thumbnail-c2d15a9c26ca9d1139634647e099dddd512acb816141a436dbcb84cf09a807cb.png","amount":379,"by":"Kari Kossila","perk":{"id":3867578,"campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone","amount":349,"description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.",
                        "number_claimed":345,
                        "number_available":600,
                        "estimated_delivery_date":"2017-11-15T00:00:00-08:00",
                        "shipping_address_required":true,
                        "label":"The Gemini Early-bird Special",
                        "validation_errors":null,
                        "featured":true,
                        "non_tax_deductible_amount":null
                    },
                    "appearance":{"private_amount":false}},
                {
                    "id":19679600,
                    "created_at":"2017-02-28T23:19:07-08:00",
                    "avatar_url":"https://graph.facebook.com/v2.8/900317870077922/picture?width=200",
                    "amount":419,
                    "by":"Shigeneou Nagasaki",
                    "perk":{
                        "id":3867578,
                        "campaign_slug":"gemini-pda-android-linux-keyboard-mobile-device-phone",
                        "amount":349,
                        "description":"The Gemini PDA keyboard mobile device with WiFi and 4G connectivity. $250 off the final retail price exclusively for our Indiegogo backers. You will get your unit from our first production run. No units will be available for general release until you receive your Gemini. Early-bird Special ships in November 2017.",
                        "number_claimed":345,
                        "number_available":600,
                        "estimated_delivery_date":"2017-11-15T00:00:00-08:00",
                        "shipping_address_required":true,"label":"The Gemini Early-bird Special",
                        "validation_errors":null,
                        "featured":true,
                        "non_tax_deductible_amount":null
                    },
                    "appearance":{"private_amount":false}
                },
            ],
            "count":30,
            "pagination":{
                "previous":null,
                "next":2,
                "current":1,
                "per_page":30,
                "count":401,
                "pages":14
            }
     }
     */
}
