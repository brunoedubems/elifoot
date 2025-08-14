package com.brunoedubems.elifoot.controller;

import com.brunoedubems.elifoot.controller.request.CreatePlayerRequest;
import com.brunoedubems.elifoot.controller.response.PlayerDetailsResponse;
import com.brunoedubems.elifoot.controller.response.PlayerResponse;
import com.brunoedubems.elifoot.service.CreatePlayerService;
import com.brunoedubems.elifoot.service.FindPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final FindPlayerService findPlayerService;
    private final CreatePlayerService createPlayerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<PlayerResponse> findAll(Pageable pageable) {
        return findPlayerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDetailsResponse findById(@PathVariable Long id) {
        return findPlayerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse create(@Valid @RequestBody CreatePlayerRequest request) {
        return createPlayerService.execute(request);
    }

}
