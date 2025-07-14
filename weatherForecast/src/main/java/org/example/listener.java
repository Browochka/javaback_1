package org.example;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class listener {

    private final Queue<weatherList> buffer = new ConcurrentLinkedQueue<>();
    private final String targetCity = "Москва";

    @KafkaListener(topics = "weather", groupId = "app.1", containerFactory = "kafkaListenerContainerFactory")
    public void listen(weatherList weather) {
        buffer.add(weather);
        System.out.println(" Получено: " + weather.getCity() + ", " + weather.getTemp() + " С, " + weather.getWeathertype() + ", " + weather.getDay());
    }

    @Scheduled(fixedRate = 10_000)
    public void reportMax() {
        Optional<weatherList> max = buffer.stream()
                .filter(w -> w.getCity().equalsIgnoreCase(targetCity))
                .max(Comparator.comparingInt(weatherList::getTemp));

        if (max.isPresent()) {
            weatherList w = max.get();
            System.out.println(" MAX в " + targetCity + ": " + w.getTemp() + "C, " + w.getDay());
        } else {
            System.out.println(" Нет данных по " + targetCity);
        }
    }
}
