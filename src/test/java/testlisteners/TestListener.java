package testlisteners;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Driver.BrowserDriver;

/**
 * The listener interface for receiving test events.
 * The class that is interested in processing a test
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addTestListener<code> method. When
 * the test event occurs, that object's appropriate
 * method is invoked.
 *
 * @see TestEvent
 */
public class TestListener implements ITestListener {
	
	private static final String[] emailList = { "saritha.modiam@pratian.com" };
	private static final String emailMsgTxt = "Please find the report after execution of test cases.";
	private static final String emailFromAddress = "Saritha.modiam@pratian.com";
	static List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	static List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	static List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();

	/**
	 * On test failure taking screenshot
	 *
	 * @param result the result
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		/*try {
			failedtests.add(result.getMethod());
			Screenshot screenshot = new Screenshot(getDriverFromBaseTest(result));
			String screenshotName = screenshot.capture(result.getName());
			File file = new File(screenshotName);
			String absolutepath = file.getAbsolutePath();
			ExtentTestManager.getTest().fail("Screenshot1",
				MediaEntityBuilder.createScreenCaptureFromPath(absolutepath).build());
		} catch (Exception ex) {
			throw new HttpException(ex.getMessage());
		}*/
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
	}

	/**
	 * On test success adding count to the list and logging result
	 *
	 * @param result the result
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		passedtests.add(result.getMethod());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	/**
	 * On test skipped adding count to the list and logging result.
	 *
	 * @param result the result
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		skippedtests.add(result.getMethod());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	/**
	 * On finish adding the count to the list and logging result.
	 *
	 * @param context the context
	 */
	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();

		/*try {
			SendMail.send(emailFromAddress, emailList, "Report", emailMsgTxt);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * On test start logging method name in report.
	 *
	 * @param result the result
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	/**
	 * Report log.
	 *
	 * @param message the message
	 */
	public static void reportLog(String message) {
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	/**
	 * Gets the passcount.
	 *
	 * @return the passcount
	 */
	public static int getPasscount() {
		return passedtests.size();

	}

	/**
	 * Gets the failcount.
	 *
	 * @return the failcount
	 */
	public static int getFailcount() {
		return failedtests.size();

	}

	/**
	 * Gets the skipcount.
	 *
	 * @return the skipcount
	 */
	public static int getSkipcount() {
		return skippedtests.size();

	}

	/**
	 * Gets the driver from base test.
	 *
	 * @param result the result
	 * @return the driver from base test
	 * @throws IllegalAccessException the illegal access exception
	 * @throws HttpException 
	 */
	@SuppressWarnings("unchecked")
	private WebDriver getDriverFromBaseTest(ITestResult result) throws IllegalAccessException, HttpException {
		WebDriver driver = null;

		try {
			Class<? extends ITestResult> testClass = (Class<? extends ITestResult>) result.getInstance().getClass();

			Class<? extends ITestResult> baseTestClass = (Class<? extends ITestResult>) testClass.getSuperclass();

			Field driverField = baseTestClass.getDeclaredField("driver");
			driver = (BrowserDriver) driverField.get(result.getInstance());
			return driver;
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException ex) {
			throw new HttpException("error getting the driver from base test");
		}

	}
	
	/**
	 * On test failed but within success percentage.
	 *
	 * @param result the result
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}


	@Override
	public void onStart(ITestContext context) 
	{
		
	}

}
