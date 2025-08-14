package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.response.PlayerDetailsResponse;
import com.brunoedubems.elifoot.controller.response.PlayerResponse;
import com.brunoedubems.elifoot.exception.ResourceNotFoundException;
import com.brunoedubems.elifoot.mapper.PlayerMapper;
import com.brunoedubems.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public Page<PlayerResponse> findAll(Pageable pageable){
        return playerRepository.findAll(pageable)
                .map(playerMapper::toPlayerReponse);
    }

    public PlayerDetailsResponse findById(Long id){
        return playerRepository.findById(id)
                .map(playerMapper::toPlayerDetailsResponse)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Player not found for id"));
    }


}
