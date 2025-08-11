package com.brunoedubems.elifoot.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStadiumRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String city;
    private Integer capicity;
    private  String urlImg;

}
