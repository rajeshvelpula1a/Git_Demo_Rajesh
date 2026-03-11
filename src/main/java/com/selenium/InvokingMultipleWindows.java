package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokingMultipleWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Create a new Tab or Window
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParnetWindowId = it.next();
		String ChildWindowId = it.next();
		driver.switchTo().window(ChildWindowId);
		driver.get("https://rahulshettyacademy.com/#/index");
		List<WebElement> courses = driver.findElements(By.cssSelector(".text-lg.group-hover\\:text-primary.transition-colors.leading-tight"));
		String firstCourseName = courses.get(0).getText().trim();
		driver.switchTo().window(ParnetWindowId);
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(firstCourseName);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Velpula.Rajesh\\logo.png"));
		System.out.println(name.getRect().getDimension().getHeight());

	}

}
