package com.example.demo.Entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Dalal extends HouseOwner{

    private String Review;

    private String Agreement;

}
