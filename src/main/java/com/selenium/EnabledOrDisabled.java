package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnabledOrDisabled {

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
		driver.findElement(By.xpath("(//a[@id='itemNumEdit'])[1]")).click();
		driver.findElement(By.id("item.isInventoried1")).click();
		System.out.println(driver.findElement(By.id("item.minQuantity")).getDomAttribute("style"));
		if(driver.findElement(By.id("item.minQuantity")).getDomAttribute("style").contains("lightgray")) {
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
//		driver.findElement(By.id("item.isInventoried1")).isSelected();
//		driver.findElement(By.id("item.isInventoried1")).click();
//		driver.findElement(By.id("item.isInventoried1")).isSelected();
//		System.out.println(driver.findElement(By.id("item.minQuantity")).isEnabled());
		System.out.println();
		

	}

}
