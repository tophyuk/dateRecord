package com.tophyuk.dateRecord.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String author; // 작성자

    @Column(length=50, nullable = false)
    private String title; // 이메일

    @Column(length=400, nullable = false)
    private String contents; // 패스워드

    @Column(length=10, nullable = false)
    private LocalDateTime dateTime; // 데이트 날짜

    @Column(nullable = false)
    private Long fileId; // 파일 ID

    @CreatedDate
    private LocalDateTime createdAt; // 생성된 시간

    @LastModifiedDate
    private LocalDateTime updatedAt; // 업데이트된 시간



}
