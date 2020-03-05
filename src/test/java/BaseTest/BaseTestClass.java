package BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Driver.BrowserDriver;

public class BaseTestClass {
	
	public WebDriver driver;
	
	 @Parameters({"env"})
      @BeforeMethod(alwaysRun = true)
      public void beforeTest(final String env) {
        String baseUrl = env;
      }

	@BeforeClass(alwaysRun = true)
	public void setUp() {	
		driver = new BrowserDriver("CHROME"); 	
		driver.manage().window().maximize(); 
	}   
	      
	@AfterClass
	public void tearDown() { 
		driver.quit(); 
	}

}
