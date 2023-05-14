package com.devsuperior.dslist.controlers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id_list}/games")
    public List<GameMinDTO> findByList(@PathVariable(value = "id_list")Long idList){
        var teste =  gameService.findByList(idList);
        return teste;
    }

    @PostMapping(value = "/{id_list}/replacement")
    public void move(@PathVariable(value = "id_list") Long idList, @RequestBody ReplacementDTO body) {
        gameListService.move(idList, body.getSourceIndex(), body.getDestinationIndex());
    }

}
