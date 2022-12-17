package com.tophyuk.dateRecord.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name; // 이름

    @Column(length = 30, nullable = false, unique = true)
    private String email; // 이메일

    @Column(length = 10, nullable = false)
    private String region; // 지역

    @Column(length = 400, nullable = false)
    private String password; // 패스워드


    @Builder
    public User(Long id, String name, String email, String region, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.region = region;
        this.password = password;
    }
}
