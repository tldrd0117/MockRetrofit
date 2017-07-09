package com.sungjae.mockretrofit;

import com.sungjae.mockretrofit.webservice.Hello;
import com.sungjae.mockretrofit.webservice.RetrofitService;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iseongjae on 2017. 7. 9..
 */

public class WebService {
    RetrofitService retrofitService;

    @Before
    public void setup(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://hello.com").build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    @Test
    public void call(){
        TestObserver testObserver = retrofitService.getHello().test();
//        List<Hello> helloList = (List<Hello>) testObserver.getEvents().get(0);
        testObserver.assertError(HttpException.class);
    }
}
