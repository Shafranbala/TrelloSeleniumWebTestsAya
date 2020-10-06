package com.shafranbala.tests.framewor;

import com.shafranbala.tests.model.Board;
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
        if(!isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"))){
            waitForElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 30);
            return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        }
        int res = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void selectCreateBoard() throws InterruptedException {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
        Thread.sleep(10000);
    }

    public void fillBoardForm(Board board) throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-title-input']"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), board.getBoardName());
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))){
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getStatus() + "']/../.."));
        if (board.getStatus().equals("public")){
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(Board board) {
        click(By.cssSelector(".js-rename-board"));
      //  wd.findElement(By.cssSelector(".inline-rename-board")).clear();
        wd.findElement(By.cssSelector(".inline-rename-board")).sendKeys(board.getBoardName() + Keys.ENTER);
    }

    public void closeBoard() {
        click(By.cssSelector(".board-menu-header-back-button"));
        if (!isElementPresent(By.cssSelector(".board-menu-navigation-item-link"))){
            click(By.cssSelector(".board-header-btn-icon"));
        }
        click(By.cssSelector(".board-menu-navigation-item-link"));
        click(By.cssSelector(".board-menu-navigation-item-link"));
    }

    public void clickOnClosedBoards() {
        click(By.xpath("//button[@data-test-id='header-boards-menu-open-closed']"));
    }

    public void clickOnDeleteButton() {
        click(By.xpath("//button[@class='_3UeOvlU6B5KUnS _45Q4U80_RMtnIc eWiN9N1KYPUQBV']"));
    }

    public void clickOnFinallyDeleteButton() {
        click(By.xpath("//button[@class='_2RQid-VB6ynuQA']"));
    }
}
