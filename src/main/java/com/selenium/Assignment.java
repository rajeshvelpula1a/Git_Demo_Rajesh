package com.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String credentials = driver.findElement(By.cssSelector(".text-center.text-white")).getText();
		//(username is rahulshettyacademy and Password is Learning@830$3mK2)
		String userName = credentials.split("is")[1].split("and")[0].trim(); //rahulshettyacademy
		String passWord = credentials.split("is")[2].replace(")", "").trim();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		
//		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
	    
	    List<WebElement> products = driver.findElements(By.cssSelector(".btn.btn-info"));
	    for(int i=0; i<products.size(); i++) {
	    	products.get(i).click();
	    }
	    driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
	    
	    
		
	}

}
