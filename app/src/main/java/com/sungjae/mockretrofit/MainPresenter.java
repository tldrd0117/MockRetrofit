package com.sungjae.mockretrofit;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public class MainPresenter implements MainMVP.Presenter {
    MainMVP.View view;
    MainMVP.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void setView(MainMVP.View view) {
        this.view = view;
    }
}