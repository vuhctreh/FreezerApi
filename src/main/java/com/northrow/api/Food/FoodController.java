package com.northrow.api.Food;

import com.northrow.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
        Food resp = foodService.saveFood(food);

        if(resp == null) throw new ResourceNotFoundException("Food with ID " + food.getId() + "was not found no updated.");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Food> searchFood(@RequestBody Food food) {
        Food resp = foodService.getFoodByName(food.getName());

        if(resp == null) throw new ResourceNotFoundException("Food with name " + food.getName() + " was not found.");

        return new ResponseEntity<>(foodService.getFoodByName(food.getName()), HttpStatus.OK);
    }

    @GetMapping("/all")
    public Optional<List<Food>> getAllFood() {
        return foodService.getAllFoods();
    }
}

//TODO - comments, tests.