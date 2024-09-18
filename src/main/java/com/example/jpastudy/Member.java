/*
 * 기록
 * 2024년 9월 8일
 * 자바 ORM 표준 JPA 프로그래밍 - 기본편
 * 섹션 5. 엔티티 매핑
 * 필드와 컬럼 매핑
 *
 * 도움되는 사이트
 * - @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor: https://invicr.github.io/2020/03/31/Spring-NoArgsConstructor-RequiredArgsConstructor-AllArgsConstructor/
 */
package com.example.jpastudy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임.
    private Long id; // String 으로 할 경우에는 에러가 난다. JPA에서 IDENTITY 전략은 주로 숫자형 데이터 타입에 대해서 자동으로 값을 증가시켜주는데, String 타입으로 선언하게 되면 해당 전략을 사용할 수 없기 때문에 오류가 발생합니다.

    @Column(name = "name", nullable = false)
    private String username;

}
