package com.sungjae.mockretrofit;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public interface MainMVP {
    interface View {

    }

    interface Presenter {
        void setView(View view);
    }

    interface Model {

    }
}