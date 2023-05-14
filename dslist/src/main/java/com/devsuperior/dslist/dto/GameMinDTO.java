package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameMinDTO {

    @JsonProperty("codigo_game")
    private Long id;
    @JsonProperty("titulo")
    private String title;
    @JsonProperty("ano")
    private Integer gameYear;
    @JsonProperty("imagem_url")
    private String imgUrl;
    @JsonProperty("descricao_curta")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        gameYear = entity.getGameYear();
        imgUrl = entity.getImgUrl();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        gameYear = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
