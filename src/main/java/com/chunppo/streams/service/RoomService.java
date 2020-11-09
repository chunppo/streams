package com.chunppo.streams.service;

import com.chunppo.streams.common.RoomStatus;
import com.chunppo.streams.model.Room;
import com.chunppo.streams.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomList() {
        return roomRepository.findRoomByStatusEquals(RoomStatus.STAND);
    }
}
