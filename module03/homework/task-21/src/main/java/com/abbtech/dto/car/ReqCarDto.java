package com.abbtech.dto.car;

import com.abbtech.dto.groups.OnCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReqCarDto {
    
    @NotBlank(message = "Name is required", groups = OnCreate.class)
    private String name;

    @NotBlank(message = "Color is required", groups = OnCreate.class)
    private String color;
}