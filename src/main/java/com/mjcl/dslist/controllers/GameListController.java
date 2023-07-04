package com.mjcl.dslist.controllers;

import com.mjcl.dslist.dto.GameDTO;
import com.mjcl.dslist.dto.GameListDTO;
import com.mjcl.dslist.dto.GameMinDTO;
import com.mjcl.dslist.services.GameListService;
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

    @GetMapping
    public List<GameListDTO> findAll() {
        return listService.findAll();
    }

}
