package firefoxPruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class PruebaDeUrls {
	
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
	public void testVentas() throws InterruptedException{
		
		// Dentro de la sección de /*********Ventas***********/ pruebo todos sus enlaces:		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado?fdv=SANCOR_DW");//Sancor
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Ventas Sancor");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado?fdv=ROFINA");//Rofina
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Ventas Rofina");
//		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-ventas-consolidado");//Bonificaciones
//			Thread.sleep(5000);
//			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Ventas Bonificaciones");
		
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testInventarios() throws InterruptedException{
		
		// Dentro de la sección de /*********Inventarios***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-actual");//Actual
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Inventarios"); 
			//Esta prueba puede fallar si se arregla la del label que está abajo
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-budget");//Budget
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Inventarios - Budget");
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testInventariosActualLabels() throws InterruptedException{
		
		// Dentro de la sección de /*********Inventarios***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-actual");//Actual
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Inventarios - Actual");

	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMaestros() throws InterruptedException{
		
		// Dentro de la sección de /*********Maestros***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-productos-sku");//Productos
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de productos");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-materiales-bom");//Materiales
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de materiales");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-alicuotas-iibb");//Alicuotas IIBB
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de Alicuotas IIBB");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-canales");//Canales
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de Canales");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-clientes");//Clientes
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de Clientes");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-codigo-postal");//Cod postales
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Maestro de Códigos Postales");
	}
		
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCostos() throws InterruptedException{
		
		// Dentro de la sección de /*********Costos***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-actual");//Actual
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Costos - Actual");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-sancor");//STD Sancor
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Escenarios - STD Sancor");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");//Budget
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Costos - Budget");	
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q1");//PRJ Q1
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Costos - Prj Q1");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q2");//PRJ Q2
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Costos - PRJ Q2");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-prj-q3");//PRJ Q3
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Costos - PRJ Q3");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testDrivers() throws InterruptedException{
		
		// Dentro de la sección de /*********Drivers***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-drivers");//Drivers
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Drivers");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testPresentaciones() throws InterruptedException{
		
		// Dentro de la sección de /*********Presentaciones***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-presentaciones");//Presentaciones
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Presentaciones");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testBrandCodes() throws InterruptedException{
		
		// Dentro de la sección de /*********Brand Codes***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-brand-codes");//Brand Codes
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Brand Codes");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCategoriasLabel() throws InterruptedException{
		
		// Dentro de la sección de /*********Categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-categorias");//Categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Categorías");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCategorias() throws InterruptedException{
		
		// Dentro de la sección de /*********Categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-categorias");//Categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Categorias");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMgnClass() throws InterruptedException{
		
		// Dentro de la sección de /*********Mgn Class***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mgn-class-i");//Mgn Class I
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Mgn class I");
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mgn-class-i-i");//Mgn Class II
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Mgn class II");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testFamiliaDeProductos() throws InterruptedException{
		
		// Dentro de la sección de /*********Familia de productos***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-familia-productos");//Familia de productos
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Familia de productos");
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testConceptoDeItems() throws InterruptedException{
		
		// Dentro de la sección de /*********Concepto de items***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-concepto-items");//Concepto de items
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Concepto de items");
	}	
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMexicoCategorias() throws InterruptedException{
		
		// Dentro de la sección de /*********Mexico categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mexico-categorias");//Mexico categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Mexico categorias");

	}	

	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMexicoCategoriasLabel() throws InterruptedException{
		
		// Dentro de la sección de /*********Mexico categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mexico-categorias");//Mexico categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "México categorías");

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
