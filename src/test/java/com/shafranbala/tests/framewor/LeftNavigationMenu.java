package com.shafranbala.tests.framewor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigationMenu extends HelperBase {
    public LeftNavigationMenu(WebDriver wd) {
        super(wd);
    }


    public void returnToBoardsPage() {
        //click(By.cssSelector(".home-left-sidebar-container .icon-board"));
        waitForElementAndClick(By.cssSelector(".home-left-sidebar-container .icon-board"), 20);
    }
}
