package com.shafranbala.tests.framewor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;

    public SessionHelper session() {
        return session;
    }

    public BoardHelper board() {
        return board;
    }

    public HeaderHelper header() {
        return header;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.navigate().to("https://trello.com/");
        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);

    }

    public void stop() {
        wd.quit();
    }
}