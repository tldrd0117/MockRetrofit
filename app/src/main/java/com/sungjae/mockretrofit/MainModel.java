package com.sungjae.mockretrofit;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public class MainModel implements MainMVP.Model {
    MainRepository repository;

    public MainModel() {
        repository = new MainRepositoryImpl();
    }

}