package com.cognizant.qbe.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshot {

	public static void takeScreenshot(ITestResult result) {
        Object currentClass = result.getInstance();
        String methodName = result.getMethod().getMethodName();
        String browser = ((BaseTest) currentClass).getBrowser();

		WebDriver webDriver = ((BaseTest) currentClass).getDriver();

		if (webDriver != null) {
			File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\" + methodName + "_" + browser + ".jpg";
			try {
				FileUtils.copyFile(scrFile, new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
