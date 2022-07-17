package com.northrow.api.Food;

import com.northrow.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Food> getFood(@RequestBody Food food) {
        Food resp = foodService.getFoodById(food.getId());

        if(resp == null) throw new ResourceNotFoundException("Food with ID " + food.getId() + "was not found.");

        return new ResponseEntity<>(foodService.getFoodById(food.getId()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> registerFood(@RequestBody Food food) {
        return new ResponseEntity<>(foodService.saveFood(food), HttpStatus.OK);
    }

    @PutMapping
    public void updateFood(@RequestBody Food food) {
        foodService.saveFood(food);
    }

    @GetMapping("/search")
    public ResponseEntity<Food> searchFood(@RequestBody Food food) {
        Food resp = foodService.getFoodByName(food.getName());

        if(resp == null) throw new ResourceNotFoundException("Food with name " + food.getName() + " was not found.");

        return new ResponseEntity<>(foodService.getFoodByName(food.getName()), HttpStatus.OK);
    }
}

//TODO - Set proper return for updateFood, error handling, comments.