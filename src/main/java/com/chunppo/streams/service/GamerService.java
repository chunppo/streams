package com.chunppo.streams.service;

import com.chunppo.streams.model.Gamer;
import com.chunppo.streams.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamerService {
    @Autowired
    private GamerRepository gamerRepository;

    public Gamer save(Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    public List<Gamer> findByRoomId(int roomId) {
        return gamerRepository.findAllByRoomId(roomId);
    }

}
