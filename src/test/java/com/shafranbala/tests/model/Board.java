package com.shafranbala.tests.model;

public class Board {
    private String boardName;
    private String status;

    public String getBoardName() {
        return boardName;
    }

    public String getStatus() {
        return status;
    }

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withStatus(String status) {
        this.status = status;
        return this;
    }
    @Override
    public String toString(){
        return "Board{" + ;
    }
}
