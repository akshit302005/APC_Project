package com.example.matchhistory.service;

import com.example.matchhistory.model.MatchEvent;
import com.example.matchhistory.repo.MatchEventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchEventService {

    private final MatchEventRepository repository;

    public MatchEventService(MatchEventRepository repository) {
        this.repository = repository;
    }

    public MatchEvent saveMatch(MatchEvent match) {
        return repository.save(match);
    }

    public List<MatchEvent> getAllMatches() {
        return repository.findAll();
    }
}
