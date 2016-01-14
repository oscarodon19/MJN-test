package chromePruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

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
