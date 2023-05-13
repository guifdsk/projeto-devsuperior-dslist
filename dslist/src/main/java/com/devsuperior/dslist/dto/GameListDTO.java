package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameListDTO {

    @JsonProperty("codigo_lista")
    private Long id;
    @JsonProperty("nome_lista")
    private String name;

    public GameListDTO(){

    }

    public GameListDTO(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
