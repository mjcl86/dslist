package com.mjcl.dslist.services;

import com.mjcl.dslist.dto.GameListDTO;
import com.mjcl.dslist.entities.GameList;
import com.mjcl.dslist.projections.GameMinProjection;
import com.mjcl.dslist.repositories.GameListRepository;
import com.mjcl.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;
    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> _lst = gameListRepository.findAll();
        List<GameListDTO> _retLst = _lst.stream()
                                       .map(GameListDTO::new)
                                       .toList();
        return _retLst;
    }

    @Transactional(readOnly = false)
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++)
        {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
