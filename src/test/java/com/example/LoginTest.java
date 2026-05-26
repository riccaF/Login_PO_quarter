package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Unit test for simple App.
 */
public class LoginTest 
{
    @Test
    public void testLoginOk()
    {
        // declaration and instantiation of objects/variables
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
    
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.getCurrentUrl());
        // we go to the login-success page
        assertEquals(driver.findElement(By.id("success")).getText(), "Login successful");
        // close Chrome
        driver.quit();
    }

    @Test
    public void testLoginNotOk()
    {
        // declaration and instantiation of objects/variables
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("error");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.getCurrentUrl());
        // we are in the same page
        assertTrue(driver.getCurrentUrl().contains("login-form"));
        assertTrue(driver.findElement(By.id("invalid")).isDisplayed());
        driver.quit();
    }

}
