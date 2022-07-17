package com.northrow.api.Food;

import com.northrow.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Optional<List<Food>> getAllFoods() {
        return Optional.of(foodRepository.findAll());
    }

    public Food getFoodById(Long id)  {
        Optional<Food> food = foodRepository.findById(id);
        return food.orElse(null);

    }

    public Food getFoodByName(String name) {
        Optional<Food> food = foodRepository.findByName(name);

        return food.orElse(null);

    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
}
