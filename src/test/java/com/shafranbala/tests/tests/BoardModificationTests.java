package com.shafranbala.tests.tests;

import com.shafranbala.tests.model.Board;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyBoardTest(){
        app.board().clickOnTheFirstBoard();
        app.board().renameBoard(new Board().withBoardName("Aia_100"));
    }

    @Test
    public void closeTheBoard (){
        app.board().clickOnTheFirstBoard();
        app.board().closeBoard();
    }

}
