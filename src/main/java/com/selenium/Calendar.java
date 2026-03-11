package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://prosuat.kent-automotive.com/pros/login");
		driver.findElement(By.id("username")).sendKeys("oktakent11.3.3@gmail.com");
		driver.findElement(By.id("password")).sendKeys("webtest1");
		driver.findElement(By.cssSelector(".btn.float-right.login_btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("reportsmenu")).click();
		driver.findElement(By.xpath("//a[@id='wosummaryrpt']")).click();
		driver.findElement(By.xpath("(//a[@title='Choose date'])[1]")).click();
		driver.findElement(By.cssSelector(".current-month.weekday.today")).click();

	}

}
