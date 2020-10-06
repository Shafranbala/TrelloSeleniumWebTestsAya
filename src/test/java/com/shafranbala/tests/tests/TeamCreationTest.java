package com.shafranbala.tests.tests;

import com.shafranbala.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
   public void createTeamTest(){
        int before = app.team().getTeamCount();
        app.header().clickOnPlusButton();
        app.team().clickOnCreateTeamButton();
        app.team().fillTeamForm(new Team().withTeamName("Aya_team").withTeamType("education"));
        app.team().submitTeamCreationForm();
        app.team().clickOnLaterButton();
        app.header().returnOnHomepageFromTeam();
        int after = app.team().getTeamCount();

        Assert.assertEquals(after, before);
    }

    @AfterClass
    public void postActions (){
        app.leftNav().returnToBoardsPage();
    }

}
