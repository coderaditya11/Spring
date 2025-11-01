package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Random;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class HouseOwner {

    @Id
    private Integer id;

    private String Address;
    private Integer price;

    @Builder.Default
    private static final Random random = new Random();

    @jakarta.persistence.PrePersist
    public void prePersist() {
        if (id == null) {
            id = 1000 + random.nextInt(9000); // random 4-digit ID
        }
        if (price == null) {
            price = 100000 + random.nextInt(900000); // random price
        }
    }
}
