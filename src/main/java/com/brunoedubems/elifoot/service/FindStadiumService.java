package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.response.StadiumResponse;
import com.brunoedubems.elifoot.entity.Stadium;
import com.brunoedubems.elifoot.exception.ResourceNotFoundException;
import com.brunoedubems.elifoot.mapper.StadiumMapper;
import com.brunoedubems.elifoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindStadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public Page<StadiumResponse> findAll(Pageable pageable) {
        return stadiumRepository.findAll(pageable)
                .map(stadiumMapper::toStadiumResponse);
    }

    public Stadium findById(Long id) {
        return stadiumRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Stadium not found for id: " + id));
    }
}
