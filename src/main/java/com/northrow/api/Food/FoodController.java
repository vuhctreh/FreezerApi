package com.northrow.api.Food;

import com.northrow.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Food controller.
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    /**
     * Instantiates a new Food controller.
     *
     * @param foodService the food service
     */
    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    /**
     * Fetches the food from H2 database by ID.
     * Throws ResourceNotFoundException if query ID is not found
     * in the database.
     *
     * @param food the food (request body, only Id is required)
     * @return the requested food as a ResponseEntity
     */
    @GetMapping
    public ResponseEntity<Food> getFood(@RequestBody Food food) {
        Food resp = foodService.getFoodById(food.getId());

        if(resp == null) throw new ResourceNotFoundException("Food with ID " + food.getId() + " was not found.");

        return new ResponseEntity<>(foodService.getFoodById(food.getId()), HttpStatus.OK);
    }

    /**
     * Save a new food to the database based on the request body.
     * Mapped to POST requests.
     *
     * @param food the food (request body)
     * @return The saved food, including its assigned id.
     */
    @PostMapping
    public ResponseEntity<Food> registerFood(@RequestBody Food food) {
        return new ResponseEntity<>(foodService.saveFood(food), HttpStatus.OK);
    }

    /**
     * Update food in database based on id. Mapped to PUT requests.
     * Creates a new entry in database if id is not found.
     *
     * Throws ResourceNotFoundException if the body of a PUT request is empty.
     *
     * @param food the food (request body)
     * @return the updated food as a ResponseEntity
     */
    @PutMapping
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
        Food resp = foodService.saveFood(food);

        if(resp == null) throw new ResourceNotFoundException("Food with ID " + food.getId() + "was not found nor updated.");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    /**
     * Search for food in database based on name. Mapped to GET requests
     * on /search endpoint.
     *
     * Throws ResourceNotFoundException if food by that name is not found in database.
     *
     * @param food the food (request body)
     * @return the queried food as a ResponseEntity.
     */
    @GetMapping("/search")
    public ResponseEntity<Food> searchFood(@RequestBody Food food) {
        Food resp = foodService.getFoodByName(food.getName());

        if(resp == null) throw new ResourceNotFoundException("Food with name " + food.getName() + " was not found.");

        return new ResponseEntity<>(foodService.getFoodByName(food.getName()), HttpStatus.OK);
    }

    /**
     * Gets all food.
     *
     * @return the all food
     */
    @GetMapping("/all")
    public Optional<List<Food>> getAllFood() {
        return foodService.getAllFoods();
    }
}