package com.mjcl.dslist.services;

import com.mjcl.dslist.dto.GameDTO;
import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.entities.Game;
import com.mjcl.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> _lst = repository.findAll();
        List<GameMinDTO> _retLst = _lst.stream()
                                       .map(GameMinDTO::new)
                                       .toList();
        return _retLst;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game _game = repository.findById(gameId).get();
        return new GameDTO(_game);
    }
}
