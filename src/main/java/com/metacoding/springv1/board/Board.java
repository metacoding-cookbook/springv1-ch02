package com.metacoding.springv1.board;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.ManyToOne; // 추가
import com.metacoding.springv1.user.User; // 추가
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

@NoArgsConstructor
@Data
@Entity  
@Table(name="board_tb") 
public class Board {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  // 자동 증가
    private Integer id;
    private  String title;
    private  String content;

    @CreationTimestamp // 자동으로 현재 시간 저장
    private  Timestamp createdAt;

    @ManyToOne(fetch = FetchType.EAGER)  // 다대일 관계 설정
    @JoinColumn(name = "user_id") // 외래 키지정
    private User user; // 객체를 직접 참조

    @Builder
    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}