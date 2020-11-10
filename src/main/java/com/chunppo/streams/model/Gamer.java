package com.chunppo.streams.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Gamer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gamer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    Integer roomId;

    @Column
    String userIp;

    @Column
    String nickName;

}
