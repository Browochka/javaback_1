package org.example;

import java.time.LocalDate;

public class weatherList {
    private String city;
    private String weathertype;
    private int temp;
    private LocalDate day;

    public weatherList() {}

    public weatherList(String city, String weathertype, int temp, LocalDate day) {
        this.city = city;
        this.weathertype = weathertype;
        this.temp = temp;
        this.day = day;
    }

    public String getCity() { return city; }
    public String getWeathertype() { return weathertype; }
    public int getTemp() { return temp; }
    public LocalDate getDay() { return day; }

    public void setCity(String city) { this.city = city; }
    public void setWeathertype(String weathertype) { this.weathertype = weathertype; }
    public void setTemp(int temp) { this.temp = temp; }
    public void setDay(LocalDate day) { this.day = day; }
}
