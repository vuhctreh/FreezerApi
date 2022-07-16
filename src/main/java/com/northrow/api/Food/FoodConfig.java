package com.northrow.api.Food;

import com.northrow.api.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FoodConfig {
    @Bean
    CommandLineRunner studentDataLoader(FoodRepository repository) {
        return args -> {
            Food pizza = new Food("Pizza", "Pizza", 5);
            Food chicken = new Food("Chicken", "Chicken", 2);
            repository.saveAll(List.of(pizza, chicken));
        };
    }
}
