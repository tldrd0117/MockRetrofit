package com.sungjae.mockretrofit;

import com.sungjae.mockretrofit.webservice.Hello;
import com.sungjae.mockretrofit.webservice.MockRetrofitService;
import com.sungjae.mockretrofit.webservice.RetrofitService;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public class MockWebService {
    BehaviorDelegate delegate;

    @Before
    public void setup(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://hello.com").build();
        NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setDelay(0, TimeUnit.MILLISECONDS);
        behavior.setVariancePercent(0);
        behavior.setFailurePercent(0);

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior).build();
        delegate = mockRetrofit.create(RetrofitService.class);

    }

    @Test
    public void call(){
        MockRetrofitService retrofitService = new MockRetrofitService(delegate);
        retrofitService.setResponse(getMockJson(), Hello.class);

        TestObserver observer = retrofitService.getHello().test();
        List<Hello> values = (List<Hello>) observer.getEvents().get(0);

        System.out.println(values.get(0).getGreeting());
        System.out.println(values.get(0).getJustTest());
        System.out.println(values.get(0).getValue());

        TestObserver observer2 = retrofitService.getHello().share().test();
        List<Hello> values2 = (List<Hello>) observer2.getEvents().get(0);

        System.out.println(values2.get(0).getGreeting());
        System.out.println(values2.get(0).getJustTest());
        System.out.println(values2.get(0).getValue());

    }

    public String getMockJson(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("hello.json");
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;
        try {
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
            System.out.print( total.toString() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total.toString();
    }
}
