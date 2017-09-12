package com.my.mecury.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryLoginTest {

	private WebDriver htmlUnit = null;

	@BeforeTest
	public void setup() {
		// setup webdriver
		// add options/config
		System.out.println("Starting the test");
		this.htmlUnit = new HtmlUnitDriver();

	}

	@Test
	public void testLogin() {
		// go to mercury site
		// login with credentials
		this.htmlUnit.get("http://newtours.demoaut.com/");
		String title = this.htmlUnit.getTitle();
		System.out.println("Title : " + title);
		assertEquals(title, "Welcome: Mercury Tours");
		this.htmlUnit.findElement(By.name("userName")).sendKeys("mercury");
		this.htmlUnit.findElement(By.name("password")).sendKeys("mercury");
		this.htmlUnit.findElement(By.name("login")).click();

		String homeTitle = this.htmlUnit.getTitle();
		assertEquals(homeTitle, "Find a Flight: Mercury Tours:");

		this.htmlUnit
				.findElement(
						By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"))
				.click();

	}

	@AfterTest
	public void cleanUp() {
		// close the window
		// close the driver
		// clean up resource
		this.htmlUnit.close();
		this.htmlUnit.quit();

		System.out.println("Cleaned up all the resources");
	}

}
