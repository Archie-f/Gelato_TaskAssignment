package com.testIT.step_definitions;

import com.testIT.utilities.Driver;
import cucumber.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@ui")
    public void setUp(){

        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

}
