package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basePackage.BaseClass;
import com.extentManager.ExtentManager;

public class OrangeHRMTest extends BaseClass {
	
	@Test
	public void loginPageTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement imgElement=driver.findElement(By.xpath("//div[@id = 'divLogo']/img"));
		Assert.assertTrue(imgElement.isDisplayed());
	}
	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id = 'txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id = 'txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
		Thread.sleep(3000);
        String actualTitle=driver.getTitle();
        String expectedTitle="OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void sampleCase() {
		ExtentManager.test.createNode("Validation1");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation2");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation3");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation4--changes--");
		Assert.assertTrue(true);
	}
}
