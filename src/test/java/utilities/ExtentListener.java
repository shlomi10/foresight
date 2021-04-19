package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
/**
 * @author Shlomi
 * @category Main methods
 * @apiNote These listeners are of TestNG
 */

public class ExtentListener extends ExtentManager implements ITestListener {

	String str;

	@Override
	public void onTestStart(ITestResult result) {
		create_test(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The success test name is: " + result.getName());
		test.info("The test name: " + result.getMethod().getDescription());
		test.log(Status.PASS, result.getMethod().getDescription() + " succeded");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " test failed");
		try {
			test.fail(result.getTestName(),
					MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.info("The test : " + result.getMethod().getDescription());
		test.fail(result.getThrowable());
		test.fail(result.getMethod().getDescription() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		init();

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}