package com.example.Final;

import com.fasterxml.jackson.annotation.JsonProperty;
// used to retrieve data from openweathermap
public class WeatherDescription {
    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;


    public WeatherDescription() {
    }

    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }

    @Override
    public String toString() {
        return "WeatherDescription{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
