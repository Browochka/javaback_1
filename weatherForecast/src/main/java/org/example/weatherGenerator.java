package org.example;

import java.time.LocalDate;
import java.util.Random;



public class weatherGenerator {
    private static String[] weatherTypes = {"Пасмурно", "Солнечно", "Дождь"};
    private static String[] cities = {"Санкт-Петербург","Казань", "Екатеринбург","Москва","Нижний Новгород"};
    Random rand = new Random();
    private LocalDate date() {
        int month= rand.nextInt(3)+6;
        int day = rand.nextInt(29)+1;
        return LocalDate.of(2025,month,day);
    };
    public weatherList generateWeather() {
        String randCity = cities[rand.nextInt(cities.length)];
        String randWeatherType = weatherTypes[rand.nextInt(weatherTypes.length)];
        LocalDate day = date();
        int temp = rand.nextInt(35);
        return new weatherList(randCity,randWeatherType,temp,day);
    }


}
