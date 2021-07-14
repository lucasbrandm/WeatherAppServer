package com.example.Final;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

// used to retrieve data from openweathermap
public class WeatherCondition {
    @JsonProperty("id")
    private int id;

    @JsonProperty("main")
    private Map<String, Float> measurements;

    @JsonProperty("weather")
    private List<WeatherDescription> weather;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public float getTemp() {
        return measurements.get("temp");
    }

    public float getTempMax() {
        return measurements.get("temp_max");
    }

    public float getTempMin() {
        return measurements.get("temp_min");
    }

    public String getWeatherMain() {
        return weather.get(0).getMain();
    }

    public String getWeatherDesc() {
        return weather.get(0).getDescription();
    }

    @Override
    public String toString() {
        return "WeatherCondition{" +
                "id=" + id +
                ", measurements=" + measurements +
                ", weather=" + weather +
                '}';
    }
}
