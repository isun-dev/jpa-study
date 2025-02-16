package com.example.jpastudy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team") // MemberNew에 있는 team과 mappedBy 한다.
    private List<MemberNew> members = new ArrayList<>(); // 빈 리스트로 초기화를 해야 널포인트 익셉션이 발생하지 않는다.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberNew> getMembers() {
        return members;
    }

    public void setMembers(List<MemberNew> members) {
        this.members = members;
    }
}
