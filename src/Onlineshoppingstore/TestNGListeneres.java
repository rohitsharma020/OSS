package Onlineshoppingstore;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeneres implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
System.out.println("TC finish results are"+"   "+result.getName());		
	}

	@Override
	public void onStart(ITestContext result) {
 System.out.println("TC onstart results are"+"   "+result.getName());		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TC onTest Failed But Within SuccessPercentage results are"+"   "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
System.out.println("TC onTest Failure results are"+"   "+result.getName());		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
System.out.println("TC onTest Skipped results are"+"   "+result.getName());		
	}

	@Override
	public void onTestStart(ITestResult result) {
System.out.println("TC onTest Start results are"+"   "+result.getName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
System.out.println("TC onTest Success results are"+"  "+result.getName());		
	}

}
