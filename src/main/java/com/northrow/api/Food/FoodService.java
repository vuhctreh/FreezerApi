package com.northrow.api.Food;

import com.northrow.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    public Food getFoodById(Long id) throws NoSuchFieldException {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            return food.get();
        }
        throw new NoSuchFieldException("Food ID '" + id + "' not found");
    }

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
}
