package com.chunppo.streams.common;

import lombok.Getter;

public enum RoomStatus {
    STAND("STAND")
    , START("START")
    , FINISH("FINISH");

    @Getter
    private String status;

    RoomStatus(String status) {
        this.status = status;
    }
}
