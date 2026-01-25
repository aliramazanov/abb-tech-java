package com.abbtech.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespCarDto {
    private String id;
    private String name;
    private String color;
}
