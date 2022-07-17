package com.northrow.api.Food;

import com.northrow.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Food service.
 */
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    /**
     * Instantiates a new Food service.
     *
     * @param foodRepository the food repository
     */
    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    /**
     * Gets all foods from the database.
     *
     * @return Optional<List<Food>> with all foods in DB.
     */
    public Optional<List<Food>> getAllFoods() {
        return Optional.of(foodRepository.findAll());
    }

    /**
     * Gets food from the database by id.
     *
     * @param id the id
     * @return Food object for given id, or null if not found
     */
    public Food getFoodById(Long id)  {
        Optional<Food> food = foodRepository.findById(id);
        return food.orElse(null);

    }

    /**
     * Gets food from the database by name.
     *
     * @param name the name
     * @return Food object for given name, or null if not found.
     */
    public Food getFoodByName(String name) {
        Optional<Food> food = foodRepository.findByName(name);

        return food.orElse(null);

    }

    /**
     * Save food in database.
     *
     * @param food the food
     * @return Food object including Id.
     */
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
}
