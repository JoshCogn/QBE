package com.cognizant.qbe.CustomExpectedConditions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions implements ExpectedCondition {

	public static ExpectedCondition<Boolean> elementIsVisibleInPortView(final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				Boolean visible = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"var elem = arguments[0],                 " 
						+ "  box = elem.getBoundingClientRect(),    "
						+ "  cx = box.left + box.width / 2,         "
						+ "  cy = box.top + box.height / 2,         "
						+ "  e = document.elementFromPoint(cx, cy); "
						+ "for (; e; e = e.parentElement) {         "
						+ "  if (e === elem)                        "
						+ "    return true;                         "
						+ "}                                        "
						+ "return false;                            ",
						element);
				return (visible);
			}
		};
	}

	public Object apply(Object arg0) {
		return null;
	}

}