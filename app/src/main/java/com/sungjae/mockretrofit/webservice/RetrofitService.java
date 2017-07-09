package com.sungjae.mockretrofit.webservice;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public interface RetrofitService {
    @GET("hello/haha")
    Observable<Hello> getHello();
}
