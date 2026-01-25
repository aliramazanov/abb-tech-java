package com.abbtech.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {
    private String id;
    private String name;
    private String color;
    private int speed;
}

