package rest.models.response;

import com.google.gson.annotations.Expose;
import rest.models.IndiegogoUser;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoUserGetResponse {

    @Expose
    private IndiegogoUser response;

    @Expose
    private String error;

    @Expose
    private String error_description;

    public IndiegogoUser getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }

    public String getError_description() {
        return error_description;
    }

    /*
    {
        "response":
            {
                "id":16016398,
                "firstname":"Bill",
                "lastname":"Hill",
                "avatar_url":"https://c1.iggcdn.com/indiegogo-media-prod-cld/image/upload/c_fill,f_auto,h_90,w_90/v1487647470/egl14oir8jycz52tjjc6.jpg",
                "name":"Bill Hill"
            }
     }
     */
}
