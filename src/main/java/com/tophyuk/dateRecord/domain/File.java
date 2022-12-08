package com.tophyuk.dateRecord.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String originFileName;

    @Column(nullable = false)
    private String serverFileName;

    @Column(nullable = false)
    private String fullPath;

    @Builder
    public File(Long id, String originFileName, String serverFileName, String fullPath) {
        this.id = id;
        this.originFileName = originFileName;
        this.serverFileName = serverFileName;
        this.fullPath = fullPath;
    }
}