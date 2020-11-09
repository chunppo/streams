package com.chunppo.streams.repository;

import com.chunppo.streams.common.RoomStatus;
import com.chunppo.streams.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findRoomByStatusEquals(RoomStatus status);
}
