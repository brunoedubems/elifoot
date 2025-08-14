package com.brunoedubems.elifoot.service;

import com.brunoedubems.elifoot.controller.request.CreateClubRequest;
import com.brunoedubems.elifoot.controller.response.ClubDetailResponse;
import com.brunoedubems.elifoot.entity.Club;
import com.brunoedubems.elifoot.entity.Stadium;
import com.brunoedubems.elifoot.mapper.ClubMapper;
import com.brunoedubems.elifoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    private final FindStadiumService findStadiumService;

    public ClubDetailResponse execute(CreateClubRequest request) {
        Club newClub = clubMapper.toEntity(request);

        if (Objects.nonNull(newClub.getStadium())) {
            newClub.setStadium(findStadiumService.findById(newClub.getStadium().getId()));
        } else {
            throw new IllegalArgumentException("stadiumId não pode ser nulo");
        }

        Club clubSaved = clubRepository.save(newClub);
        return clubMapper.toClubDetailsResponse(clubSaved);
    }


}
