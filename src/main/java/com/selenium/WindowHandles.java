package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentId, childId]
		Iterator<String> it = windows.iterator();
		String parentID = it.next(); //parentID
		String childID = it.next();
		driver.switchTo().window(childID);
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response
		String email = text.split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(email);

	}

}
