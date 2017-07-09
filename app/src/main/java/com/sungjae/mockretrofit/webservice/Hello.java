package com.sungjae.mockretrofit.webservice;

/**
 * Created by iseongjae on 2017. 7. 8..
 */

public class Hello {
    String greeting;
    String value;
    String justTest;

    public String getGreeting() {
        return greeting;
    }

    public Hello setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Hello setValue(String value) {
        this.value = value;
        return this;
    }

    public String getJustTest() {
        return justTest;
    }

    public Hello setJustTest(String justTest) {
        this.justTest = justTest;
        return this;
    }
}
