package com.example.demo;

import java.util.List;

public class JsonReponse {

private Data info;

public Data getData() {
    return info;
}

public void setData(Data info) {
    this.info = info;
}

public class Data {

    private String response;
    private List<String> nightclub;
    private List<String> restaurants;
    private List<String>parks;
    private List<String>telecom;
    private List<String>internet;
    
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<String> getNightclub() {
        return nightclub;
    }

    public void setNightclub(List<String> nightclub) {
        this.nightclub = nightclub;
    }

    public List<String> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<String> restaurants) {
        this.restaurants = restaurants;
    }
    
    public List<String> getparks() {
        return parks;
    }

    public void setparks(List<String> parks) {
        this.parks = parks;
    }
    
    public List<String> gettelecom() {
        return telecom;
    }

    public void settelecom(List<String> telecom) {
        this.telecom = telecom;
    }
    
    
    public List<String> getinternet() {
        return internet;
    }

    public void setinternet(List<String> internet) {
        this.internet = internet;
    }
    
}
}