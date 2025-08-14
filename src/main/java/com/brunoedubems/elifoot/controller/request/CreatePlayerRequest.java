package com.brunoedubems.elifoot.controller.request;

import com.brunoedubems.elifoot.entity.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlayerRequest {

    @NotBlank
    private String name;

    @NotNull
    private Position position;

    @NotNull
    private int shirtNumber;

    @NotNull
    private Long clubId;

}
