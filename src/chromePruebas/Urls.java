package chromePruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Urls {
	
	public WebDriver driver;

	@Test
	public void testLoginUserValidoAdmin() throws InterruptedException{
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("mtusuarios-username")).sendKeys("admin");
	    driver.findElement(By.id("mtusuarios-contrasenia")).sendKeys("admin");
	    driver.findElement(By.name("login-button")).click();
	    Thread.sleep(3000);
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
	      
	}
	
	@Test
	public void testLoginUserValidoAdmind() throws InterruptedException{
		

	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
	      
	}
	
	@BeforeSuite
	
	public void beforeMethod() {
	
		System.setProperty("webdriver.chrome.driver", "C:/Testng/chromedriver.exe");
		//Recordar copiar el archivo .exe mencionado anteriormente en la carpeta mencionada
		  
		driver = new ChromeDriver();
	  	driver.get("http://192.168.1.21:8082/mdj_test/web/");
	
	}

	@AfterSuite
	
	public void afterMethod() {
	
	    driver.quit();
	
	}

	
	
}
