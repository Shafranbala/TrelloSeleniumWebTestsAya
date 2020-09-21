package com.shafranbala.tests.tests;

import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest(){
        app.board().clickOnTheFirstBoard();
        app.board().renameBoard("");
    }

}
