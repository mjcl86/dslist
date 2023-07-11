package com.mjcl.dslist.controllers;

import com.mjcl.dslist.dto.GameDTO;
import com.mjcl.dslist.dto.GameListDTO;
import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.dto.ReplacementDTO;
import com.mjcl.dslist.services.GameListService;
import com.mjcl.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{listId}/replacement")
    public void findByLists(@PathVariable Long listId, @RequestBody ReplacementDTO body) {

        listService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }

}
