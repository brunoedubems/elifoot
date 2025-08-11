package com.brunoedubems.elifoot.mapper;

import com.brunoedubems.elifoot.controller.request.CreateStadiumRequest;
import com.brunoedubems.elifoot.controller.response.StadiumResponse;
import com.brunoedubems.elifoot.entity.Stadium;

public class StadiumMapper {

    public static StadiumResponse toStadiumResponse(Stadium stadium) {
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();
    }

    public static Stadium toStadium(CreateStadiumRequest createStadiumRequest){
    return Stadium.builder()
            .name(createStadiumRequest.getName())
            .city(createStadiumRequest.getCity())
            .capacity(createStadiumRequest.getCapicity())
            .urlImg(createStadiumRequest.getUrlImg())
            .build();
    }

}
