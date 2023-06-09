package com.mjcl.dslist.services;

import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.entities.Game;
import com.mjcl.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public List<GameMinDTO> findAll() {
        List<Game> _lst = repository.findAll();
        List<GameMinDTO> _retLst = _lst.stream()
                                       .map(GameMinDTO::new)
                                       .toList();
        return _retLst;
    }

    public GameMinDTO getGame(Long gameId) {
        Game _game = repository.findById(gameId).get();
        return new GameMinDTO(_game);
    }
}
