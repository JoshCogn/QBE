package com.cognizant.qbe.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.qbe.CustomExpectedConditions.CustomExpectedConditions;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementVisibleInPortView(WebElement element) {
		Boolean visible = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"var elem = arguments[0],                 " + "  box = elem.getBoundingClientRect(),    "
						+ "  cx = box.left + box.width / 2,         " + "  cy = box.top + box.height / 2,         "
						+ "  e = document.elementFromPoint(cx, cy); " + "for (; e; e = e.parentElement) {         "
						+ "  if (e === elem)                        " + "    return true;                         "
						+ "}                                        " + "return false;                            ",
				element);
		return visible;
	}

	public void waitUntilElementVisibleInPortView(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(CustomExpectedConditions.elementIsVisibleInPortView(element));
		} catch (TimeoutException e) {
			System.err.println(element.toString());
			System.err.println("Element not visible in portview");
			throw new TimeoutException(e);
		}
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
