package com.northrow.api.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<Food> getFood(@RequestBody Food food) throws NoSuchFieldException {
        return new ResponseEntity<>(foodService.getFoodById(food.getId()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> registerFood(@RequestBody Food food) {
        return new ResponseEntity<>(foodService.saveFood(food).getId(), HttpStatus.OK);
    }

    @PutMapping
    public void updateFood(@RequestBody Food food) {
        foodService.saveFood(food);
    }

    @GetMapping("/search")
    public ResponseEntity<Food> searchFood(@RequestBody Food food) throws NoSuchFieldException {
        return new ResponseEntity<>(foodService.getFoodByName(food.getName()), HttpStatus.OK);
    }

}

//TODO - Set proper return for updateFood, make registerFood JSON.