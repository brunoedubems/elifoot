package com.brunoedubems.elifoot.mapper;

import com.brunoedubems.elifoot.controller.request.CreatePlayerRequest;
import com.brunoedubems.elifoot.controller.response.PlayerDetailsResponse;
import com.brunoedubems.elifoot.controller.response.PlayerResponse;
import com.brunoedubems.elifoot.entity.Player;
import com.brunoedubems.elifoot.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper  {

    @Mapping(target = "position",source = "position", qualifiedByName = "enumToString")
    PlayerResponse toPlayerReponse(Player player);

    @Mapping(target = "position",source = "position", qualifiedByName = "enumToString")
    PlayerDetailsResponse toPlayerDetailsResponse(Player player);

    @Mapping(target = "club.id", source = "clubId")
    Player toEntity(CreatePlayerRequest request);

    @Named("enumToString")
    default String mapPositionToString(Position position){
        return position != null ? position.getLabel(): null;
    }


}
