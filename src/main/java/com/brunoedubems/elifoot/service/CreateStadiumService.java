package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.request.CreateStadiumRequest;
import com.brunoedubems.elifoot.controller.response.StadiumResponse;
import com.brunoedubems.elifoot.entity.Stadium;
import com.brunoedubems.elifoot.mapper.StadiumMapper;
import com.brunoedubems.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumResponse execute(CreateStadiumRequest request){
        Stadium saveStadium = stadiumRepository.save(StadiumMapper.toStadium(request));
        return StadiumMapper.toStadiumResponse(saveStadium);
    }
}
