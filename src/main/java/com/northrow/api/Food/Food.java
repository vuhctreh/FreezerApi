package com.northrow.api.Food;

import javax.persistence.*;

/**
 * The type Food.
 */
@Entity
@Table
public class Food {

    @Id
    @SequenceGenerator(name = "food_seq", sequenceName = "food_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_seq")
    private Long Id;
    private String name;
    private String type;
    private int quantity;

    /**
     * Instantiates a new Food.
     */
    public Food() {}

    /**
     * Instantiates a new Food.
     *
     * @param id the id
     */
    public Food(Long id) {
        Id = id;
    }

    /**
     * Instantiates a new Food.
     *
     * @param name     the name
     * @param type     the type
     * @param quantity the quantity
     */
    public Food(String name, String type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.Id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
