package com.chunppo.streams.repository;

import com.chunppo.streams.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamerRepository extends JpaRepository<Gamer, Integer> {
    List<Gamer> findAllByRoomId(Integer roomId);
}
