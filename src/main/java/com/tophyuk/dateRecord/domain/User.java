package com.tophyuk.dateRecord.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name; // 이름

    @Column(length = 20, nullable = false)
    private String email; // 이메일

    @Column(length = 10, nullable = false)
    private String regions; // 지역

    @Column(length = 400, nullable = false)
    private String password; // 패스워드

    @Column(length = 400, nullable = false)
    private String salt; // 암호화

    @CreatedDate
    private LocalDateTime createdAt; // 생성된 시간
    @LastModifiedDate
    private LocalDateTime updatedAt; // 업데이트된 시간

    @Builder
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }
}
