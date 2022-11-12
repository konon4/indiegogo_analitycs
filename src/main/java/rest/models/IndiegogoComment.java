package rest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoComment {

    @Expose
    private int id;

    @Expose
    private String created_at;

    @Expose
    private String text;

    @Expose
    private boolean from_the_team;

    @Expose
    private IndiegogoUser account;


    public int getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public IndiegogoUser getAccount() {
        return account;
    }

    public String getText() {
        return text;
    }

    public boolean isRegistredUser(){
        return (account != null);
    }

    @Override
    public String toString() {
        String result = "";
        if (account != null) {
            result += account.toString();
        }
        if (text != null) {
            result += " | Text: "+text;
        }
        return result;
    }

    /*
    {
        "id":6984379,
        "created_at":"2017-02-28T16:41:16-08:00",
        "text":"This world can always use more Palmtops so I'm in for the ride.\nGood luck with the campaign.\nGot a question though, 8000mah lipo dimensions are around 12x6.5x.75cm.\nGiven the specs list the Gemini as being 1.35cm thick closed is it really possible to fit a 8000mah battery in there? \nIt'd be awesome to have a battery that large I'm just worried about that.\nAlso were supercapacitors really considered like that sketch shows?",
        "from_the_team":false,
        "owner_type":"",
        "private":false,
        "account":{
            "id":4122036,
            "firstname":"MJPIA",
            "lastname":"",
            "avatar_url":"/assets/individuals/missing/thumbnail-c2d15a9c26ca9d1139634647e099dddd512acb816141a436dbcb84cf09a807cb.png",
            "name":"MJPIA"
        }
    }
     */
}
