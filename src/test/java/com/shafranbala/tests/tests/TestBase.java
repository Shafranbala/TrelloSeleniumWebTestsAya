package com.shafranbala.tests.tests;

import com.shafranbala.tests.framewor.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.init();
        app.session().logIn("aia82@yandex.ru", "BaalReginon123");
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
