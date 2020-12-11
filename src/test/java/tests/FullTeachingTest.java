package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FullTeachingTest {
	
	private WebDriver driver;
	

	@Before
	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions(); 
		options .addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors"); 
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);

	}

	@After 
	public void tearDown() throws Exception	{
				
				driver.quit();
	}
	
	@Test
	public void testaTituloPagina() throws InterruptedException {
		driver.get("https://localhost:5000");
		assertTrue("Titulo da pagina difere do esperado", driver.getTitle().contentEquals("FullTeaching"));
		Thread.sleep(3000);
	} 
	
	@Test
	public void testaCadastro() throws InterruptedException {
		driver.get("https://localhost:5000");
		driver.manage().window().maximize();
		driver.findElement(By.id("signUpButton")).click();
		driver.findElement(By.id("email")).sendKeys("matheus@matheus.com");
		driver.findElement(By.id("nickName")).sendKeys("matheus");
		driver.findElement(By.id("password")).sendKeys("Jw123456");
		driver.findElement(By.id("confirmPassword")).sendKeys("Jw123456");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click(); //Essa foi a unica solução que eu encontrei para selecionar o captcha e funciona apenas 50% das vezes. Foi a unica solução que eu encontrei então preferi deixar assim.
		Thread.sleep(3000);
		driver.findElement(By.id("sign-up-button")).click();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void testaLogin() throws InterruptedException {
		driver.get("https://localhost:5000");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("matheus@matheus.com");
		driver.findElement(By.id("password")).sendKeys("Jw123456");
		driver.findElement(By.id("log-in-btn")).click();
		Thread.sleep(3000);
		
		
	} 
	
	@Test
	public void testaDataDeRegistro() throws InterruptedException {
		driver.get("https://localhost:5000");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("matheus@matheus.com");
		driver.findElement(By.id("password")).sendKeys("Jw123456");
		driver.findElement(By.id("log-in-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("settings-button")).click();
		String at = driver.findElement(By.xpath("//*[@id=\"sticky-footer-div\"]/main/app-settings/div/div[3]/div[2]/ul/li[3]/div[2]")).getText();
		String et = "Dec 10, 2020";
		
		if(at.equalsIgnoreCase(et))
			System.out.println("Data de registro iguais.");
		else
			System.out.println("Data de registro diferentes.");
		Thread.sleep(3000);
		
		
	} 
	
	@Test
	public void testaTrocaDeSenha() throws InterruptedException {
		driver.get("https://localhost:5000");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("matheus@matheus.com");
		driver.findElement(By.id("password")).sendKeys("Jw123456");
		driver.findElement(By.id("log-in-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("settings-button")).click();
		driver.findElement(By.xpath("//*[@id=\"sticky-footer-div\"]/main/app-settings/div/div[3]/div[2]/ul/li[4]/div[2]/a")).click();
		driver.findElement(By.id("inputCurrentPassword")).sendKeys("Jw123456");
		driver.findElement(By.id("inputNewPassword")).sendKeys("Gw123456");
		driver.findElement(By.id("inputNewPassword2")).sendKeys("Gw123456");
		driver.findElement(By.xpath("//*[@id=\"password-modal\"]/div/div/form/div[2]/button")).click();
		Thread.sleep(3000);
		
		String senhaMsg = driver.findElement(By.xpath("//*[@id=\"password-modal\"]/div/div/form/app-error-message/div/h5")).getText();
		
		assertEquals("Password changed succesfully!", senhaMsg);
		
		Thread.sleep(3000);
		
		
	} 
	
	@Test
	public void testaLogout() throws InterruptedException {
		driver.get("https://localhost:5000");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navigation-bar\"]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("matheus@matheus.com");
		driver.findElement(By.id("password")).sendKeys("Gw123456");
		driver.findElement(By.id("log-in-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("arrow-drop-down")).click();
		driver.findElement(By.id("logout-button")).click();
		Thread.sleep(3000);
		
		
	} 
	
	
 
}
