package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE game_list_id = :idList AND game_id = :gameId")
    void updateBelongingPosition(Long idList, Long gameId, Integer newPosition);

}