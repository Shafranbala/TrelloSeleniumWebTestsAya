package com.shafranbala.tests.tests;

import com.shafranbala.tests.framewor.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
        app.session().logIn("aia82@yandex.ru", "BaalReginon123");
    }

    @BeforeMethod
    public void LogTestStart(Method m, Object[] p){
        logger.info("start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void LogTestStop(Method m){
        logger.info("stop test");
    }

}
