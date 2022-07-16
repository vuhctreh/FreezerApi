package com.northrow.api.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getFood() {
        return foodService.getFood();
    }

    @PostMapping
    public void registerFood(@RequestBody Food food) {
        foodService.saveFood(food);
    }

    @PutMapping
    public void updateFood(@RequestBody Food food) {
        foodService.saveFood(food);
    }

}

//TODO - Set proper return for getFood, registerFood, updateFood
//TODO - Add search by name and ID