package com.shafranbala.tests.tests;

import com.shafranbala.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTrelloTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"1DPboard", "public"});
        list.add(new Object[]{"2D-Pboard", "public"});
        list.add(new Object[]{"3", "public"});
        list.add(new Object[]{"(%)*&^(", "public"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validBoardsFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
        String line = br.readLine();
        while (line!=null){
            String[]ar = line.split(",");
            list.add(new Object[]{new Board().withBoardName(ar[0]).withStatus(ar[1])});
            line = br.readLine();
        }
        return list.iterator();
    }

    @Test
    public void createBoardPositiveTest() throws InterruptedException {
        int before = app.board().getBoardCount();
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardForm(new Board().withBoardName("Aya_2").withStatus("public"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomepageFromBoard();
        int after = app.board().getBoardCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "validBoards")
    public void createBoardPositiveTestFromDataProvider(String boardName, String status) throws InterruptedException {
        int before = app.board().getBoardCount();
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        Board board = new Board().withBoardName(boardName).withStatus(status);
        app.board().confirmBoardCreation();
        app.header().returnOnHomepageFromBoard();
        int after = app.board().getBoardCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test(dataProvider = "validBoardsFromCXV")
    public void createBoardPositiveTestFromCSV(Board board) throws InterruptedException {
        int before = app.board().getBoardCount();
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        //Board board = new Board().withBoardName(boardName).withStatus(status);
        app.board().fillBoardForm(board);
        app.board().confirmBoardCreation();
        app.header().returnOnHomepageFromBoard();
        int after = app.board().getBoardCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void createBoardPositiveTest2() throws InterruptedException {
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardForm(new Board().withBoardName("Aya_2").withStatus("private"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomepageFromBoard();
    }

}
