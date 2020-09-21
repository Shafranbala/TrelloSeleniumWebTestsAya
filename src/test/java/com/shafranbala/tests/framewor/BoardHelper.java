package com.shafranbala.tests.framewor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmBoardCreation(){
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public int getBoardCount(){
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void selectCreateBoard() throws InterruptedException {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
        Thread.sleep(10000);
    }

    public void fillBoardForm(String boardName, String status) throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-title-input']"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
        click(By.cssSelector(".nch-icon _2_Q6rrYCFblD3M z53beXNiDPJAy2 _14iemfYJtyfgUQ"));
        Thread.sleep(10000);
        wd.findElement(By.name(status)).click();
        if (isElementPresent(By.className("_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA"))){
            click(By.cssSelector("._3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA"));
        }
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(String newName) {
        click(By.cssSelector(".js-rename-board"));
        wd.findElement(By.cssSelector("js-board-name-input")).clear();
        wd.findElement(By.cssSelector("js-board-name-input")).sendKeys(newName + Keys.ENTER);
    }
}
