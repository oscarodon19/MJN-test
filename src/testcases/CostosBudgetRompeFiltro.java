package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class CostosBudgetRompeFiltro {
	/*prueba*/
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
	public void costosBudgetSeteoBloqueadoSi() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		
	    WebElement selectElement = driver.findElement(By
	    		.xpath("//select[@class='form-control' and @name='InBudgetsProyecciones[bloqueado]']"));
	    
	    Select select = new Select(selectElement);
	    List<WebElement> options = select.getOptions();

	    for (WebElement option : options) {
	        System.out.println(option.getText());
	        if (option.getText().equals("Si")) {
	            option.click();
	            break;
	        }
	    }
	    
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoBloqueadoNo() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		
	    WebElement selectElement = driver.findElement(By
	    		.xpath("//select[@class='form-control' and @name='InBudgetsProyecciones[bloqueado]']"));
	    
	    Select select = new Select(selectElement);
	    List<WebElement> options = select.getOptions();

	    for (WebElement option : options) {
	        System.out.println(option.getText());
	        if (option.getText().equals("No")) {
	            option.click();
	            break;
	        }
	    }
	    
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoDescripcion1() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys("fadjlfdafdajñ");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoDescripcion2() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys("232323243434-´+{´+'¿'");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoDescripcion3() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys("---?'\"fdafafd*¨*¨*");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoDescripcion4() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys("");
		driver.findElement(By.name("InBudgetsProyecciones[descripcion]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoAnio1() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys("2015");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoAnio2() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys("");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}	
	
	@Test(dependsOnMethods={"testLoginUserValidoAdmin"})
	public void costosBudgetSeteoCampoAnio3() throws InterruptedException{
		
		driver.navigate().to("http://192.168.1.21:8082/mdj_test/web/in-escenarios-budget");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys("adffdaf");
		driver.findElement(By.name("InBudgetsProyecciones[anio]")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	      
	    Assert.assertEquals(driver.getTitle(), "MeadJohnson");
		
	}
	
	
	@BeforeSuite
	
	public void beforeMethod() {
	
		driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.21:8082/mdj_test/web/");
	
	}

	@AfterSuite
	
	public void afterMethod() {
	
	    driver.quit();
	
	}


	
	
}
