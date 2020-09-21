package com.shafranbala.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTrelloTests extends TestBase {

    @Test
    public void createBoardPositiveTest() throws InterruptedException {
        int before = app.board().getBoardCount();
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardForm("Aya_1", "public");
        app.board().confirmBoardCreation();
        app.header().returnOnHomepage();
        int after = app.board().getBoardCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void createBoardPositiveTest2() throws InterruptedException {
        app.header().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardForm("Aya_2", "private");
        app.board().confirmBoardCreation();
        app.header().returnOnHomepage();
    }

}
