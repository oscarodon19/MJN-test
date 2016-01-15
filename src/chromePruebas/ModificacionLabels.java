package chromePruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class ModificacionLabels {
	
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
	public void testInventariosActualLabels() throws InterruptedException{
		
		// Dentro de la sección de /*********Inventarios***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-proyeccion-actual");//Actual
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Inventarios - Actual");

	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCategoriasLabel() throws InterruptedException{
		
		// Dentro de la sección de /*********Categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-categorias");//Categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Categorías");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testMexicoCategoriasLabel() throws InterruptedException{
		
		// Dentro de la sección de /*********Mexico categorias***********/ pruebo todos sus enlaces:
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-mexico-categorias");//Mexico categorias
			Thread.sleep(5000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "México categorías");

	}	
	
	/*****
	 * 
	 * Modificacion de labels a las secciones de crear Maestros
	 * 
	 * *****/
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCrearMaestroDeProductos() throws InterruptedException{
		
		// Crear Maestro De Productos
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-productos-sku/create");
			Thread.sleep(3000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Crear Maestro de Productos");

	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCrearMaestroDeMateriales() throws InterruptedException{
		
		// Crear Maestro de Materiales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-materiales-bom/create");
			Thread.sleep(3000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Crear Maestro de Materiales");

	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCrearMaestrodeAlicuotasIIBB() throws InterruptedException{
		
		// Crear Maestro de Alicuotas IIBB
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/ve-alicuotas-iibb");
			Thread.sleep(3000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Crear Maestro de Alicuotas IIBB");

	}	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void testCrearMaestroDeCanales() throws InterruptedException{
		
		// Crear Maestro de Canales
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/mt-canales/create");
			Thread.sleep(3000);
			Assert.assertEquals((driver.findElement(By.tagName("h1")).getText()), "Crear Maestro de Canales");

	}
	
	
	
		
	
	///******************************/  
	//   BEFORE SUITE Y AFTER SUITE
	///******************************/
	
	
	
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
