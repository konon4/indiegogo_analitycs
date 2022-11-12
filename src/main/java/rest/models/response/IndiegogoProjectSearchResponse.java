package rest.models.response;

import com.google.gson.annotations.Expose;
import rest.models.IndiegogoPagination;
import rest.models.IndiegogoProject;

import java.util.List;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoProjectSearchResponse {

    @Expose
    private List<IndiegogoProject> response;

    @Expose
    private int count;

    @Expose
    private IndiegogoPagination pagination;

    @Expose
    private String error;

    @Expose
    private String error_description;

    public List<IndiegogoProject> getResponse() {
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
      {
           "response":[
              {
                 "id":1017024,
                 "slug":"the-one-last-party-there-and-back-again",
                 "created_at":"2014-11-14T13:07:48-08:00",
                 "updated_at":"2015-01-09T11:46:55-08:00",
                 "title":"The One Last Party - There and Back Again! ",
                 "image_types":{
                    "baseball_card":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/t_iPhone_standard/v1417433521/mzaw6qapbden4mbyvlmf.jpg",
                    "small":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/t_iPhone_standard/v1417433521/mzaw6qapbden4mbyvlmf.jpg",
                    "medium":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/t_iPhone_retina/v1417433521/mzaw6qapbden4mbyvlmf.jpg",
                    "large":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/t_iPhone_retina_hd_v1/v1417433521/mzaw6qapbden4mbyvlmf.jpg",
                    "original":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/v1417433521/mzaw6qapbden4mbyvlmf.jpg"
                 },
                 "currency":{
                    "iso_num":840,
                    "iso_code":"USD",
                    "symbol":"$"
                 },
                 "collected_funds":135191,
                 "goal":180000,
                 "funding_ends_at":"2015-01-18T23:59:59-08:00",
                 "funding_started_at":"2014-12-01T06:02:52-08:00",
                 "tagline":"Join TheOneRing.net at The One Last Party to celebrate all six of Peter Jackson's Middle-earth films",
                 "funding_days":30,
                 "funding_type":"fixed",
                 "baseball_card_image_url":"http://res.cloudinary.com/indiegogo-media-prod-cld/image/upload/c_fill,h_220,w_220/v1417433521/mzaw6qapbden4mbyvlmf.jpg",
                 "region_code":"STTE_USCA",
                 "region":"California",
                 "country_code_alpha_2":"US",
                 "country":"United States",
                 "city":"Los Angeles",
                 "contributions_count":751,
                 "comments_count":53,
                 "updates_count":48,
                 "category":{
                    "id":9,
                    "name":"Film",
                    "text":"Film"
                 },
                 "forever_funding_active":false,
                 "perks_available":true,
                 "team_members":[
                    {
                       "id":1499885,
                       "name":"Kirsten  Cairns",
                       "status":"owner",
                       "owner":true,
                       "avatar_url":"https://images.indiegogo.com/individuals/9138929/pictures/thumbnail/20141201042423-bronze_member_.JPG?1417436667",
                       "facebook":{
                          "verified":false,
                          "friends_count":0
                       },
                       "account_id":9138929,
                       "user_type":"RLTN_OWNR"
                    },
                    {
                       "id":1523585,
                       "name":"Stephen Goodwin",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"http://graph.facebook.com/840545320/picture?width=200",
                       "facebook":{
                          "verified":true,
                          "friends_count":284
                       },
                       "account_id":326973,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1523586,
                       "name":"Pat Dawson",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"https://g0.iggcdn.com/assets/individuals/missing/thumbnail-1e60e0977054c7219782b694da9d2677.png",
                       "facebook":{
                          "verified":false,
                          "friends_count":0
                       },
                       "account_id":9270932,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1523589,
                       "name":"Rebecca Perry",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"https://images.indiegogo.com/individuals/9265176/pictures/thumbnail/20141201072605-giphy.gif?1417447568",
                       "facebook":{
                          "verified":false,
                          "friends_count":0
                       },
                       "account_id":9265176,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1523590,
                       "name":"Chris Pirrotta",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"http://graph.facebook.com/9372747/picture?width=200",
                       "facebook":{
                          "verified":true,
                          "friends_count":468
                       },
                       "account_id":9267630,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1524795,
                       "name":"Gina Alessi",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"https://images.indiegogo.com/individuals/397084/pictures/thumbnail/20141006115441-photo_4_copysq.jpg?1412621684",
                       "facebook":{
                          "verified":true,
                          "friends_count":379
                       },
                       "account_id":397084,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1525265,
                       "name":"Cathy Udovch",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"https://images.indiegogo.com/individuals/9272828/pictures/thumbnail/20141130012924-cruiseicon.jpg?1417339765",
                       "facebook":{
                          "verified":true,
                          "friends_count":686
                       },
                       "account_id":9272828,
                       "user_type":"RLTN_EDTR"
                    },
                    {
                       "id":1526888,
                       "name":"John Tedeschi",
                       "status":"accepted",
                       "owner":false,
                       "avatar_url":"http://graph.facebook.com/853385331/picture?width=200",
                       "facebook":{
                          "verified":true,
                          "friends_count":515
                       },
                       "account_id":9281325,
                       "user_type":"RLTN_TEAM"
                    }
                 ],
                 "latest_updates":[
                    {
                       "id":614835,
                       "created_at":"2015-01-08T21:51:09-08:00",
                       "text":"Oops, thought it might be helpful to show you what the poster looks like now, after all the signatures got on it. The &quot;Gimli, Son of Gloin&quot; perk also includes a full VIP ticket. ",
                       "html":"<p><p>Oops, thought it might be helpful to show you what the poster looks like now, after all the signatures got on it. The "Gimli, Son of Gloin" perk also includes a full VIP ticket.&nbsp;</p><p><br></p><p><img src="https://images.indiegogo.com/file_attachments/1139256/files/20150108214912-Poster_A_smaller_.JPG?1420782552" style=""></p><br></p>",
                       "preview_text":"Oops, thought it might be helpful to show you what the poster looks like now, after all the signatures got on it. The &quot;Gimli, Son of...",
                       "image_urls":[
                          "https://images.indiegogo.com/file_attachments/1139256/files/20150108214912-Poster_A_smaller_.JPG?1420782552"
                       ],
                       "account":{
                          "id":9272828,
                          "firstname":"Cathy",
                          "lastname":"Udovch",
                          "avatar_url":"https://images.indiegogo.com/individuals/9272828/pictures/thumbnail/20141130012924-cruiseicon.jpg?1417339765",
                          "name":"Cathy Udovch"
                       }
                    }
                 ]
              },
              ...
          ]
          "count":30,
           "pagination":{
              "previous":null,
              "next":2,
              "current":1,
              "per_page":30,
              "count":500,
              "pages":17
           }
     */
}
