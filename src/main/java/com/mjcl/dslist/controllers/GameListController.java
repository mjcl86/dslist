package com.mjcl.dslist.controllers;

import com.mjcl.dslist.dto.GameDTO;
import com.mjcl.dslist.dto.GameListDTO;
import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.services.GameListService;
import com.mjcl.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService listService;
    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return listService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByLists(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

}
