package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://prosuat.kent-automotive.com/pros/login");
		driver.findElement(By.id("username")).sendKeys("oktakent11.3.3@gmail.com");
		driver.findElement(By.id("password")).sendKeys("webtest1");
		driver.findElement(By.cssSelector(".btn.float-right.login_btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inventorymenu")).click();
		driver.findElement(By.id("itemsmenu")).click();
		driver.findElement(By.xpath("(//img[@alt='Delete'])[1]")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("(//img[@alt='Delete'])[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
