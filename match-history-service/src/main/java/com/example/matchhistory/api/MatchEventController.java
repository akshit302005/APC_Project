package com.example.matchhistory.api;

import com.example.matchhistory.model.MatchEvent;
import com.example.matchhistory.service.MatchEventService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchEventController {

    private final MatchEventService service;

    public MatchEventController(MatchEventService service) {
        this.service = service;
    }

    // Accept JSON in request body
    @PostMapping("/add")
    public MatchEvent addMatch(@RequestBody MatchEvent match) {
        // Set matchTime server-side
        match.setMatchTime(LocalDateTime.now());
        return service.saveMatch(match);
    }

    @GetMapping("/all")
    public List<MatchEvent> getMatches() {
        return service.getAllMatches();
    }
}
