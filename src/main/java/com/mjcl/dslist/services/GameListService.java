package com.mjcl.dslist.services;

import com.mjcl.dslist.dto.GameDTO;
import com.mjcl.dslist.dto.GameListDTO;
import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.entities.Game;
import com.mjcl.dslist.entities.GameList;
import com.mjcl.dslist.repositories.GameListRepository;
import com.mjcl.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> _lst = repository.findAll();
        List<GameListDTO> _retLst = _lst.stream()
                                       .map(GameListDTO::new)
                                       .toList();
        return _retLst;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long listId) {
        GameList _list = repository.findById(listId).get();
        return new GameListDTO(_list);
    }

}
