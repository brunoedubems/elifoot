package com.brunoedubems.elifoot.controller;

import com.brunoedubems.elifoot.controller.request.CreateClubRequest;
import com.brunoedubems.elifoot.controller.response.ClubDetailResponse;
import com.brunoedubems.elifoot.controller.response.ClubReponse;
import com.brunoedubems.elifoot.entity.Club;
import com.brunoedubems.elifoot.mapper.ClubMapper;
import com.brunoedubems.elifoot.service.CreateClubService;
import com.brunoedubems.elifoot.service.FindClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final ClubMapper clubMapper;
    private final CreateClubService createClubService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubReponse> findAll(Pageable pageable) {
        return findClubService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubDetailResponse findByid(@PathVariable Long id) {
        Club club = findClubService.findById(id);
        return clubMapper.toClubDetailsResponse(club);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ClubDetailResponse create (@RequestBody CreateClubRequest request) {
    return createClubService.execute(request);
    }
}
