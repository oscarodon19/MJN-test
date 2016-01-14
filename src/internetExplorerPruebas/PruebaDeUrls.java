package internetExplorerPruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class PruebaDeUrls {
	
	public WebDriver driver;
	public RemoteWebDriver webDriver;
	
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
		 
		//WebElement error;
		//error=webDriver.findElementByClassName("site-error");
		//Dentro de la secci�n de /*********Ventas***********/ pruebo todos sus enlaces:		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado");//Sancor
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testInventarios(){
		
		// Dentro de la secci�n de /*********Inventarios***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-actual");//Actual
		Assert.assertNotNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-budget");//Budget
		Assert.assertNotNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMaestros(){
		
		// Dentro de la secci�n de /*********Maestros***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-productos-sku");//Productos
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-materiales-bom");//Materiales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-alicuotas-iibb");//Alicuotas IIBB
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-canales");//Canales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-clientes");//Clientes
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-codigo-postal");//Cod postales
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
		
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCostos(){
		
		// Dentro de la secci�n de /*********Costos***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-actual");//Actual
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-sancor");//STD Sancor
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");//Budget
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q1");//PRJ Q1
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q2");//PRJ Q2
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q3");//PRJ Q3
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testDrivers(){
		
		// Dentro de la secci�n de /*********Drivers***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-drivers");//Drivers
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testPresentaciones(){
		
		// Dentro de la secci�n de /*********Presentaciones***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-presentaciones");//Presentaciones
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testBrandCodes(){
		
		// Dentro de la secci�n de /*********Brand Codes***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-brand-codes");//Brand Codes
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCategorias(){
		
		// Dentro de la secci�n de /*********Categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-categorias");//Categorias
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMgnClass(){
		
		// Dentro de la secci�n de /*********Mgn Class***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mgn-class-i");//Mgn Class I
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mgn-class-i-i");//Mgn Class II
		Assert.assertNull(driver.findElement(By.className("site-error"))); /*Buscamos que al entrar 
		en el link no haya ning�n error por eso buscamos la clase padre site-error*/ 
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testFamiliaDeProductos(){
		
		// Dentro de la secci�n de /*********Familia de productos***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-familia-productos");//Familia de productos
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testConceptoDeItems(){
		
		// Dentro de la secci�n de /*********Concepto de items***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-concepto-items");//Concepto de items
		
	}	
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMexicoCategorias(){
		
		// Dentro de la secci�n de /*********Mexico categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mexico-categorias");//Mexico categorias
		
	}	
	
		
	
	///******************************/  
	//   BEFORE SUITE Y AFTER SUITE
	///******************************/
	
	
	
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
