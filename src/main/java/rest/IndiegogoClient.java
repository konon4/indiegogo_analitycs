package rest;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import rest.models.IndiegogoComment;
import rest.models.IndiegogoContributor;
import rest.models.IndiegogoPagination;
import rest.models.IndiegogoProject;
import rest.models.response.IndiegogoCommentsGetResponse;
import rest.models.response.IndiegogoContributorsGetResponse;
import rest.models.response.IndiegogoProjectSearchResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by volk on 28.02.2017.
 */
public class IndiegogoClient {
    private static final String URL = "https://api.indiegogo.com/1.1/";
    private static final int retryCount = 3;
    private static final int retryDelay = 2000;
    private static Retrofit retrofit = null;
    private static IndiegogoApi api = null;
    private static IndiegogoClient instance = null;
    private static OkHttpClient okHttpClient = null;

    private IndiegogoClient(String token) {
        if (retrofit == null) {

            okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(
                            chain -> {
                                Request original = chain.request();
                                HttpUrl originalHttpUrl = original.url();

                                HttpUrl url = originalHttpUrl.newBuilder()
                                        .addQueryParameter("api_token", token)
                                        .build();

                                Request.Builder requestBuilder = original.newBuilder()
                                        .url(url);

                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                    )
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //.addConverterFactory()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            api = retrofit.create(IndiegogoApi.class);
        }
    }

    public static IndiegogoClient getInstance(String token){
        if (instance == null){
            instance = new IndiegogoClient(token);
        }
        return instance;
    }

    private Observable<IndiegogoProject> getNextSearchPage(String title, int page, int pages){
        return api.searchProjectNextPage(title, page).delay(retryDelay, TimeUnit.MILLISECONDS)
                .retry(retryCount).flatMap(response -> {
            if (response.getError() != null) {
                return Observable.error(new IOException(response.getError()));
            }
            IndiegogoPagination paging = response.getPagination();
            if (paging.getCurrent() < paging.getPages() && paging.getCurrent() < pages){
                return Observable
                        .fromIterable(response.getResponse())
                        .concatWith(getNextSearchPage(title, paging.getNext(), pages));
            }
            return Observable.fromIterable(response.getResponse());
        });
    }

    public Observable<IndiegogoProjectSearchResponse> search(String title){
        return api.searchProject(title).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    return Observable.just(response);
                });
    }

    public Observable<IndiegogoProjectSearchResponse> search(String title, int page){
        return api.searchProjectNextPage(title, page).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    return Observable.just(response);
                });
    }

    public Observable<IndiegogoProject> searchAll(String title){
        return api.searchProject(title).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
            .flatMap(response -> {
                if (response.getError() != null) {
                    return Observable.error(new IOException(response.getError()));
                }
                IndiegogoPagination paging = response.getPagination();
                if (paging.getCurrent() < paging.getPages()){
                    return Observable.fromIterable(response.getResponse())
                            .concatWith(getNextSearchPage(title,paging.getNext(),paging.getPages()));
                }
                return Observable.fromIterable(response.getResponse());
            });
    }

    public Observable<IndiegogoProject> searchAll(String title, int pages){
        return api.searchProject(title).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    IndiegogoPagination paging = response.getPagination();
                    if (paging.getCurrent() < paging.getPages() && paging.getCurrent() < pages){
                        return Observable.fromIterable(response.getResponse())
                                .concatWith(getNextSearchPage(title,paging.getNext(),pages));
                    }
                    return Observable.fromIterable(response.getResponse());
                });
    }

    private Observable<IndiegogoContributor> getNextContributors(int projectId, int page){
        return api.getContributorsNextPage(projectId, page).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
            .flatMap(
                (Function<IndiegogoContributorsGetResponse, ObservableSource<IndiegogoContributor>>) response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    IndiegogoPagination paging = response.getPagination();
                    if (paging.getCurrent() < paging.getPages() ){
                        return Observable
                                .fromIterable(response.getResponse())
                                .concatWith(getNextContributors(projectId, paging.getNext()));
                    }
                    return Observable.fromIterable(response.getResponse());
                });
    }

    public Observable<IndiegogoContributor> getContributors(Integer projectId){
        return api.getContributors(projectId).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    IndiegogoPagination paging = response.getPagination();
                    if (paging.getCurrent() < paging.getPages() ){
                        return Observable.fromIterable(response.getResponse())
                                .concatWith(getNextContributors(projectId,paging.getNext()));
                    }
                    return Observable.fromIterable(response.getResponse());
                });
    }

    private Observable<IndiegogoComment> getNextComments(int projectId, int page){
        return api.getCommentsNextPage(projectId, page).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(
                        (Function<IndiegogoCommentsGetResponse, ObservableSource<IndiegogoComment>>) response -> {
                            if (response.getError() != null) {
                                return Observable.error(new IOException(response.getError()));
                            }
                            IndiegogoPagination paging = response.getPagination();
                            if (paging.getCurrent() < paging.getPages() ){
                                return Observable
                                        .fromIterable(response.getResponse())
                                        .concatWith(getNextComments(projectId, paging.getNext()));
                            }
                            return Observable.fromIterable(response.getResponse());
                        });
    }

    public Observable<IndiegogoComment> getComments(Integer projectId){
        return api.getComments(projectId).delay(retryDelay, TimeUnit.MILLISECONDS).retry(retryCount)
                .flatMap(response -> {
                    if (response.getError() != null) {
                        return Observable.error(new IOException(response.getError()));
                    }
                    IndiegogoPagination paging = response.getPagination();
                    if (paging.getCurrent() < paging.getPages() ){
                        return Observable.fromIterable(response.getResponse())
                                .concatWith(getNextComments(projectId,paging.getNext()));
                    }
                    return Observable.fromIterable(response.getResponse());
                });
    }
}
