package br.com.rsi.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Steps {

	private WebDriver driver;

	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Dado("que eu esteja na página do Google")
	public void queEuEstejaNaPaginaDoGoogle() {
		driver.get("http://google.com");
	}

	@Quando("eu buscar pela palavra {string}")
	public void euBuscarPelaPalavra(String palavra) {
		driver.findElement(By.name("q")).sendKeys(palavra);
		driver.findElement(By.name("q")).submit();
	}

	@Então("eu valido que a busca foi realizada")
	public void euValidoQueABuscaFoiRealizada() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean elementoExisteNaPagina = (wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")))) != null;
		assertTrue("Resultado não foi o esperado", elementoExisteNaPagina);
	}

	@After()
	public void quitBrowser() {
		driver.quit();
	}

}
