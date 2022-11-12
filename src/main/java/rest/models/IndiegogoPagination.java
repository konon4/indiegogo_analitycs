package rest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by volk on 01.03.2017.
 */
public class IndiegogoPagination {
    @Expose
    private int previous;

    @Expose
    private int next;

    @Expose
    private int current;

    @Expose
    private int per_page;

    @Expose
    private int count;

    @Expose
    private int pages;

    public int getPrevious() {
        return previous;
    }

    public int getNext() {
        return next;
    }

    public int getCurrent() {
        return current;
    }

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public int getPer_page() {
        return per_page;
    }

    /*
    "pagination":{
        "previous":null,
        "next":2,
        "current":1,
        "per_page":30,
        "count":401,
        "pages":14
    }
     */
}
