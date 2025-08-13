package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.response.ClubReponse;
import com.brunoedubems.elifoot.entity.Club;
import com.brunoedubems.elifoot.exception.ResourceNotFoundException;
import com.brunoedubems.elifoot.mapper.ClubMapper;
import com.brunoedubems.elifoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public Page<ClubReponse> findAll(Pageable pageable) {
        return clubRepository.findAll(pageable)
                .map(clubMapper::toClubReponse);
    }


    public Club findById(Long id) {
        return clubRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Club not found for id: " + id));
    }
}
