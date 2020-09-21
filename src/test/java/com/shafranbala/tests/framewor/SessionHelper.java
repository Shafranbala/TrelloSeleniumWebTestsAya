package com.shafranbala.tests.framewor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void logIn (String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email);
        Thread.sleep(10000);
        click(By.id("login"));
        Thread.sleep(10000);
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isLoginErrorPresent(){
        return isElementPresent(By.cssSelector("#login-error"));
    }

}
