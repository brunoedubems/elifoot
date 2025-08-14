package com.brunoedubems.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDetailsResponse {
    private Long id;
    private String name;
    private String position;
    private int shirtNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;
    private ClubReponse club;
}
