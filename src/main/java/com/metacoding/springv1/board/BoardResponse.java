package com.metacoding.springv1.board;

import lombok.Data;

public class BoardResponse {

    @Data
    public static class DTO {

        private Integer id;
        private String title;
        private String content;

        public DTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
        }
    }   
    @Data
    public static class DetailDTO {

        private Integer id;
        private String title;
        private String content;
        private Integer userId;
        private String username;

        public DetailDTO (Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.userId = board.getUser().getId();
            this.username = board.getUser().getUsername();
        }
    }
}