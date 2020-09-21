package com.shafranbala.tests.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {
        static WebDriver wd;

    @BeforeMethod
    public void ensurePreconditions (){
        if (app.header().isAvatarPresent()){
            app.header().logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        app.session().logIn("aia82@yandex.ru", "BaalReginon123");

        Assert.assertTrue(app.header().isAvatarPresent());
    }

    @Test
    public void negativeLoginAtlassianAccTest() throws InterruptedException {
        app.session().logIn("aia82@yandex.ru", "blablabla");
        Assert.assertTrue(app.session().isLoginErrorPresent());
        Assert.assertFalse(app.header().isAvatarPresent());
    }
}
