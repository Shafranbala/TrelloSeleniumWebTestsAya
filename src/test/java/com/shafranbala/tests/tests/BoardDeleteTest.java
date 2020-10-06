package com.shafranbala.tests.tests;

import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @Test
    public void deleteBoardPositive (){
        app.header().clickOnBoardsButton();
        app.board().clickOnClosedBoards();
        app.board().clickOnDeleteButton();
        app.board().clickOnFinallyDeleteButton();
    }

}
