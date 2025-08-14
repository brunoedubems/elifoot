package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.request.CreatePlayerRequest;
import com.brunoedubems.elifoot.controller.response.PlayerResponse;
import com.brunoedubems.elifoot.entity.Player;
import com.brunoedubems.elifoot.mapper.PlayerMapper;
import com.brunoedubems.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreatePlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final FindClubService findClubService;

    public PlayerResponse execute(CreatePlayerRequest request){
       Player newPlayer = playerMapper.toEntity(request);
       newPlayer.setClub(findClubService.findById(request.getClubId()));
       Player savedPlayer = playerRepository.save(newPlayer);
        return playerMapper.toPlayerReponse(savedPlayer);
    }

}
