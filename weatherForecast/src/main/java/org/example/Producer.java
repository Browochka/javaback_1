package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, weatherList> kafkaTemplate;

    private weatherGenerator generator = new weatherGenerator();

    @Scheduled(fixedRate = 2000)
    public void send() {
        weatherList weather = generator.generateWeather();
        kafkaTemplate.send("weather", weather);
    }
}
