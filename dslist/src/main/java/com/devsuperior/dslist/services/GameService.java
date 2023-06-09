package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        var result = repository.findAll();
        return result.stream()
                .map(GameMinDTO::new)
                .filter(x -> x.getGameYear() == 2012)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long idList){
        var result = repository.searchByList(idList);
        return result.stream()
                .map(x -> new GameMinDTO(x))
                .toList();
    }
}
