package com.shafranbala.tests.framewor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    LeftNavigationMenu leftNav;
    private String browser;

    public ApplicationManager (String browser){
        this.browser = browser;
    }

    public SessionHelper session() {
        return session;
    }

    public BoardHelper board() {
        return board;
    }

    public HeaderHelper header() {
        return header;
    }

    public TeamHelper team() { return team; }

    public LeftNavigationMenu leftNav() {return leftNav; }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.navigate().to("https://trello.com/");
        session = new SessionHelper(wd);
        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        leftNav = new LeftNavigationMenu(wd);
    }

    public void stop() {
        wd.quit();
    }
}
