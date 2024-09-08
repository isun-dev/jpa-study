/*
 * 기록
 * 2024년 9월 8일
 * 자바 ORM 표준 JPA 프로그래밍 - 기본편
 * 섹션 5. 엔티티 매핑
 * 필드와 컬럼 매핑
 */
package com.example.jpastudy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }
}
