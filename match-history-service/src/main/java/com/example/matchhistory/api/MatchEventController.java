package com.example.matchhistory.api;

import com.example.matchhistory.model.MatchEvent;
import com.example.matchhistory.repo.MatchEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchEventController {

    @Autowired
    private MatchEventRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public MatchEvent addMatch(@RequestBody MatchEvent match) {
        MatchEvent saved = repository.save(match);

        // Send match result to ranking-service
        String rankingServiceUrl = "http://localhost:8082/rankings/update";
        restTemplate.postForObject(rankingServiceUrl, saved, String.class);

        return saved;
    }

    @GetMapping("/all")
    public List<MatchEvent> getAllMatches() {
        return repository.findAll();
    }
}
