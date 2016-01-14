package chromePruebas;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Breadcrumbs {
	
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
