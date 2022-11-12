package rest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by volk on 01.03.2017.
 */

//{"response":{"id":16016398,"firstname":"Bill","lastname":"Hill","avatar_url":"https://c1.iggcdn.com/indiegogo-media-prod-cld/image/upload/c_fill,f_auto,h_90,w_90/v1487647470/egl14oir8jycz52tjjc6.jpg","name":"Bill Hill"}}
public class IndiegogoUser {

    @Expose
    private int id;

    @Expose
    private String firstname;

    @Expose
    private String lastname;

    @Expose
    private String name;

    @Expose
    private String avatar_url;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getAvatar_url() {return avatar_url;}

    @Override
    public String toString() {
        if (name != null){
            return name;
        } else if (firstname != null && lastname != null) {
            return firstname+" "+lastname;
        } else return "Unknown user";
    }
}
