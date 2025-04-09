package com.company.msa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 이 클래스가 JPA 엔티티임을 나타냄 (DB 테이블과 연결됨)
@Getter // Lombok을 사용하여 getter 메서드 자동 생성
@Setter // Lombok을 사용하여 setter 메서드 자동 생성
@NoArgsConstructor // 기본 생성자를 자동으로 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID를 자동 증가(AUTO_INCREMENT)하도록 설정
    private Long id;

    @Column(nullable = false, length = 100)
    // 'name' 컬럼을 지정. null이 될 수 없으며 최대 길이 100자로 설정
    private String name;
}
