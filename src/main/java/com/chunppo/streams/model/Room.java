package com.chunppo.streams.model;

import com.chunppo.streams.common.RoomStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Room")
@Data
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String roomName;

    @Column
    @Enumerated(EnumType.STRING)
    RoomStatus status;
}
