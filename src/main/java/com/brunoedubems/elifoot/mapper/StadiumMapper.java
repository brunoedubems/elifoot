package com.brunoedubems.elifoot.mapper;

import com.brunoedubems.elifoot.controller.request.CreateStadiumRequest;
import com.brunoedubems.elifoot.controller.response.StadiumResponse;
import com.brunoedubems.elifoot.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

    StadiumResponse toStadiumResponse(Stadium stadium);

    Stadium toStadium(CreateStadiumRequest createStadiumRequest);
}
