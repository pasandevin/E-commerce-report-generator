package com.kelaniya.uni.export;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface Exporter {

    public JsonNode export() throws UnirestException;

}
