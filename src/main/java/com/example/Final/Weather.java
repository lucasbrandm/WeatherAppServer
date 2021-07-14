package com.example.Final;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Weather {
    private int idWeather;
    private String main;
    private String mainDesc;
    private float temp;
    private float tempMin;
    private float tempMax;

    public Weather(int idWeather, String main, String mainDesc, float temp, float tempMin, float tempMax) {
        this.idWeather = idWeather;
        this.main = main;
        this.mainDesc = mainDesc;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    @Id
    @Column(name = "idWeather")
    public int getIdWeather() {
        return idWeather;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    @Basic
    @Column(name = "main")
    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Basic
    @Column(name = "main_desc")
    public String getMainDesc() {
        return mainDesc;
    }

    public void setMainDesc(String mainDesc) {
        this.mainDesc = mainDesc;
    }

    @Basic
    @Column(name = "temp")
    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Basic
    @Column(name = "temp_min")
    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    @Basic
    @Column(name = "temp_max")
    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return idWeather == weather.idWeather && Double.compare(weather.temp, temp) == 0 && Double.compare(weather.tempMin, tempMin) == 0 && Double.compare(weather.tempMax, tempMax) == 0 && Objects.equals(main, weather.main) && Objects.equals(mainDesc, weather.mainDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWeather, main, mainDesc, temp, tempMin, tempMax);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "idWeather=" + idWeather +
                ", main='" + main + '\'' +
                ", mainDesc='" + mainDesc + '\'' +
                ", temp=" + temp +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}
