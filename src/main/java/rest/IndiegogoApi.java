package rest;


import io.reactivex.Observable;
import rest.models.response.IndiegogoCommentsGetResponse;
import rest.models.response.IndiegogoContributorsGetResponse;
import rest.models.response.IndiegogoProjectSearchResponse;
import rest.models.response.IndiegogoUserGetResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by volk on 28.02.2017.
 */
public interface IndiegogoApi {

    // Получить список компаний
    //https://api.indiegogo.com/1.1/campaigns.json?api_token=//token

    // Комментарии компании
    //https://api.indiegogo.com/1.1/campaigns/1950156/comments.json?api_token=//token
    @GET("campaigns/{projectId}/comments.json")
    Observable<IndiegogoCommentsGetResponse> getComments(@Path("projectId") Integer projectId);

    @GET("campaigns/{projectId}/comments.json")
    Observable<IndiegogoCommentsGetResponse> getCommentsNextPage(@Path("projectId") Integer projectId, @Query("page") int page);

    // Список бэйкеров
    //https://api.indiegogo.com/1.1/campaigns/1950156/contributions.json?api_token=//token

    @GET("campaigns/{projectId}/contributions.json")
    Observable<IndiegogoContributorsGetResponse> getContributors(@Path("projectId") Integer projectId);

    @GET("campaigns/{projectId}/contributions.json")
    Observable<IndiegogoContributorsGetResponse> getContributorsNextPage(@Path("projectId") Integer projectId, @Query("page") int page);

    //@GET("campaigns/{projectId}/comments.json")
    //Call<IndiegogoContributorsGetResponse> getComments(@Path("projectId") Integer projectId);

    // Доступ к аккаунту
    //https://api.indiegogo.com/1.1/accounts/16016398.json?api_token=//token
    /*{"response":{"id":16016398,"firstname":"Bill","lastname":"Hill","avatar_url":"https://c1.iggcdn.com/indiegogo-media-prod-cld/image/upload/c_fill,f_auto,h_90,w_90/v1487647470/egl14oir8jycz52tjjc6.jpg","name":"Bill Hill"}}*/
    @GET("accounts/{userId}.json")
    Call<IndiegogoUserGetResponse> getUserInfo(@Path("userId") Integer userId);

    @GET("search/campaigns.json")
    Observable<IndiegogoProjectSearchResponse> searchProject(@Query("title") String title);

    @GET("search/campaigns.json")
    Observable<IndiegogoProjectSearchResponse> searchProjectNextPage(@Query("title") String title, @Query("page") int page);
}
