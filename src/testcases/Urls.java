package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
	      
	}

	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testVentas(){
		
		// Dentro de la sección de /*********Ventas***********/ pruebo todos sus enlaces:		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado");//Sancor
		//driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado");//Bonificaciones
	    //driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado");//Rofina
		
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testInventarios(){
		
		// Dentro de la sección de /*********Inventarios***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-actual");//Actual
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-budget");//Budget
		
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMaestros(){
		
		// Dentro de la sección de /*********Maestros***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-productos-sku");//Productos
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-materiales-bom");//Materiales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-alicuotas-iibb");//Alicuotas IIBB
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-canales");//Canales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-clientes");//Clientes
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-codigo-postal");//Cod postales
		
	}
		
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCostos(){
		
		// Dentro de la sección de /*********Costos***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-actual");//Actual
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-sancor");//STD Sancor
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");//Budget
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q1");//PRJ Q1
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q2");//PRJ Q2
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q3");//PRJ Q3
		
	}
	

	
	@BeforeSuite
	
	public void beforeMethod() {
	
		// Create a new instance of the Firefox driver
	
		driver = new FirefoxDriver();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  	driver.get("http://192.168.1.21:8082/mdj_test/web/");
	
	}

	@AfterSuite
	
	public void afterMethod() {
	
	    driver.quit();
	
	}

	
	
}
