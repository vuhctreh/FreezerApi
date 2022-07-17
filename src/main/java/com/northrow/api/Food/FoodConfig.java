package com.northrow.api.Food;

import com.northrow.api.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * The type Food config.
 */
@Configuration
public class FoodConfig {
    /**
     * Food data loader command line runner.
     * Adds {@code pizza} and {@code chicken} objects to the repository.
     *
     * @param repository the repository
     * @return the command line runner
     */
    @Bean
    CommandLineRunner foodDataLoader(FoodRepository repository) {
        return args -> {
            Food pizza = new Food("Pizza", "Pizza", 5);
            Food chicken = new Food("Chicken", "Chicken", 2);
            repository.saveAll(List.of(pizza, chicken));
        };
    }
}
