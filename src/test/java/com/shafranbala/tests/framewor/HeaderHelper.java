package com.shafranbala.tests.framewor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnPlusButton(){
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void returnOnHomepageFromBoard(){
        waitForElement(By.cssSelector(".mod-list-add-button"), 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void returnOnHomepageFromTeam(){
        waitForElement(By.cssSelector(".tabbed-pane-header-content"), 30);
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public boolean isAvatarPresent(){
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void clickOnAvatar(){
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    private void clickLogOut() {
        click(By.xpath("//button[]@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnBoardsButton() {
        click(By.xpath("//button[@data-test-id='header-boards-menu-button']"));
    }
}
