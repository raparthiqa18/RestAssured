package steps;

import io.cucumber.java.Before;
import utilities.RestassuredExtensions;

public class TestInitialize {
    @Before
    public void TestSetup(){
        RestassuredExtensions restassuredExtensions=new RestassuredExtensions();
    }
}
