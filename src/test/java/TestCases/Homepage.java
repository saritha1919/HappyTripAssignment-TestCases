package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseTest.BaseTestClass;
import junit.framework.Assert;

@Listeners(testlisteners.TestListener.class)
public class Homepage extends BaseTestClass{
	
	@Test
	public void testCase1()
	{
		 driver.get("http://172.30.12.167:8085/HappyTripAssignment/");
		 driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a")).click();
		 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"Wrapper\"]/div[1]/blockquote/h3")).getText(), "SWITCH TO LUMA saritha");
	}
	
	@Test
	public void testcase2()
	{
		 driver.get("http://172.30.12.167:8085/HappyTripAssignment/");
		 driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a")).click();
	}

}
