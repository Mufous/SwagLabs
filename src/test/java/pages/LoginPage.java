package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	final String USERNAME = "//input[@id='user-name']";
	final String PASSWORD = "//input[@id='password']";
	final String BTN_LOGIN = "//input[@id='login-button']";
	final String ERRO_LOCKED_OUT_USER = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]/button[1]/*[1]";
	final String ERRO_USERNAME_EM_BRANCO = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]";
	final String ERRO_PASSWORD_EM_BRANCO = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]";
	final String ERRO_USUARIO_INVALIDO = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]";
	final String ERRO_PASSWORD_INVALIDA = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]";
	public String diretorio = "";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void acessaUrl(String url) throws IOException { 
		
		driver.get(url);
		screenShot("Acessa a URL", diretorio);
		logger.info("URL acessada com sucesso.");
	}

	public void preencheUsername(String username) throws InterruptedException, IOException {

		driver.findElement(By.xpath(USERNAME)).sendKeys(username);
		screenShot("Preenche o campo o 'Username'", diretorio);
		logger.info("Campo 'Username' preenchido com sucesso.");
	}

	public void preenchePassword(String password) throws InterruptedException, IOException {
		driver.findElement(By.xpath(PASSWORD)).sendKeys(password);
		screenShot("Preenche o campo o 'Password'", diretorio);
		logger.info("Campo 'Password' preenchido com sucesso.");
	}
	
	public void efetuaLogin() throws InterruptedException, IOException {
		driver.findElement(By.xpath(BTN_LOGIN)).click();
		screenShot("Clica no botão 'LOGIN'", diretorio);
		logger.info("Tentativa de login efetuada");
	}
	
	public boolean loginBloqueado() {
		return driver.findElement(By.xpath(ERRO_LOCKED_OUT_USER)).isDisplayed();
	}
	
	public boolean usernameEmBranco() {
		return driver.findElement(By.xpath(ERRO_USERNAME_EM_BRANCO)).isDisplayed();
	}
	
	public boolean passwordEmBranco() {
		return driver.findElement(By.xpath(ERRO_PASSWORD_EM_BRANCO)).isDisplayed();
	}
	
	public boolean usernameInvalido() {
		return driver.findElement(By.xpath(ERRO_USUARIO_INVALIDO)).isDisplayed();
	}
	
	public boolean passwordInvalida() {
		return driver.findElement(By.xpath(ERRO_PASSWORD_INVALIDA)).isDisplayed();
	}
}