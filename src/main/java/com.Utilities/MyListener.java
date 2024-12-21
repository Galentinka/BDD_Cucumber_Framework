package com.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    public String testName;

    public void onStart(ITestContext context) {
        System.out.println("Execution started!");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test start executing!");
    }

    public void onTestSuccess(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test passed!");
            System.out.println();
        }
    }

    public void onTestFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed!");
            System.out.println();
        }
    }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("Test skipped!");
            System.out.println();
        }
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Execution finished!");
    }
}
