package com.brunoedubems.elifoot.controller;

import com.brunoedubems.elifoot.controller.request.CreateStadiumRequest;
import com.brunoedubems.elifoot.controller.response.StadiumResponse;
import com.brunoedubems.elifoot.entity.Stadium;
import com.brunoedubems.elifoot.service.CreateStadiumService;
import com.brunoedubems.elifoot.service.FindStadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> findAll(Pageable pageable){
        return findStadiumService.findAll(pageable);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse create(@RequestBody CreateStadiumRequest request){
        return createStadiumService.execute(request);
    }
}
