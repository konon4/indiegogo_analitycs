package rest.models.response;

import com.google.gson.annotations.Expose;
import rest.models.IndiegogoComment;
import rest.models.IndiegogoPagination;

import java.util.List;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoCommentsGetResponse {

    @Expose
    private List<IndiegogoComment> response;

    @Expose
    private int count;

    @Expose
    private IndiegogoPagination pagination;

    @Expose
    private String error;

    @Expose
    private String error_description;

    public List<IndiegogoComment> getResponse() {
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
                },
                {
                    "id":6984355,
                    "created_at":"2017-02-28T16:30:23-08:00",
                    "text":"Do USB-C connectors support USB-C PD(power delivery) and Alt-mode graphics output with DisplayPort or HDMI ?\nIt is not so, simply USB signaling supports only ?",
                    "from_the_team":false,
                    "owner_type":"",
                    "private":false,
                    "account":{
                        "id":15244609,
                        "firstname":"anonymous",
                        "lastname":"anonymous",
                        "avatar_url":"/assets/individuals/missing/thumbnail-c2d15a9c26ca9d1139634647e099dddd512acb816141a436dbcb84cf09a807cb.png",
                        "name":"anonymous anonymous"
                    }
                }]
     */
}
