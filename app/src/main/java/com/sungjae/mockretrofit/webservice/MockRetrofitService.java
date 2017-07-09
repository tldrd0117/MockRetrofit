package com.sungjae.mockretrofit.webservice;

import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.InputStream;

import io.reactivex.Observable;
import retrofit2.http.PUT;
import retrofit2.mock.BehaviorDelegate;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public class MockRetrofitService implements RetrofitService {
    BehaviorDelegate<RetrofitService> behaviorDelegate;
    Object result;
    Gson gson = new Gson();

    public MockRetrofitService(BehaviorDelegate<RetrofitService> behaviorDelegate){
        this.behaviorDelegate = behaviorDelegate;
    }

    public MockRetrofitService setResponse( String response, Class resultClass ) {
        result = gson.fromJson(response, resultClass);
        return this;
    }

    @Override
    public Observable<Hello> getHello() {
        return behaviorDelegate.returningResponse(result).getHello();
    }


}
