package com.mjcl.dslist.controllers;

import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.entities.Game;
import com.mjcl.dslist.services.GameService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

//    @GetMapping(value = "/{id}")
//    public GameMinDTO getGame(@PathParam(value = id) Long id) {
//        return gameService.getGame(id);
//    }
}
