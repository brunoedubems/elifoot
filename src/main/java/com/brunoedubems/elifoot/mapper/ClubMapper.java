package com.brunoedubems.elifoot.mapper;

import com.brunoedubems.elifoot.controller.request.CreateClubRequest;
import com.brunoedubems.elifoot.controller.response.ClubDetailResponse;
import com.brunoedubems.elifoot.controller.response.ClubReponse;
import com.brunoedubems.elifoot.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubReponse toClubReponse(Club club);

    ClubDetailResponse toClubDetailsResponse(Club club);

    @Mapping(target = "stadium.id", source ="stadiumId")
    Club toEntity(CreateClubRequest request);
}
