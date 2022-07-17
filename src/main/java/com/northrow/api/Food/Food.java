package com.northrow.api.Food;

import org.springframework.stereotype.Service;

import javax.persistence.*;

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

    public Food() {}

    public Food(String name, String type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

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
