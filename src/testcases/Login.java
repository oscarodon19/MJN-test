package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Login {
	
	public WebDriver driver;

	@Test
	public void testLoginUserValidoAdmin() throws InterruptedException{
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mtusuarios-username")).sendKeys("admin");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("admin");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");

	      
	}
	
	@Test
	public void testLoginUserInvalidoAdmin2() throws InterruptedException{
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mtusuarios-username")).sendKeys("admin2");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("admin3232");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(), "Login");
		
	}

	@Test
	public void testLoginUserInvalidoAdm2() throws InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("mtusuarios-username")).sendKeys("adm2");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("ain3232");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(), "Login");
		
	}

	@Test
	public void testLoginUserInvalidoEspacioVacio() throws InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mtusuarios-username")).sendKeys("");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(), "Login");
		
	}
	

	@Test
	public void testLoginUserInvalidoCaracteresRaros() throws InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mtusuarios-username")).sendKeys("#$%&\"%&-/-&-/(\")=(-/&%\"$/(/&%$#$%");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("!\"#$%-&$#$#\"%$%\"-$%-$\"%4");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(), "Login");
		
	}
	
	@BeforeMethod
	
	public void beforeMethod() {
	
		// Create a new instance of the Firefox driver
	
		driver = new FirefoxDriver();
	
		//Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  	//Launch the Online Store Website
	
	  	driver.get("http://192.168.1.21:8082/mdj_test/web/");
	
	}

	@AfterMethod
	
	public void afterMethod() {
	
	    driver.quit();
	
	}

	
	
}
