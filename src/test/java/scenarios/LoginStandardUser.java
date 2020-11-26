package scenarios;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginPage;
import utils.ConfiguraçãoChromeDriver;
import utils.LeitorJsonWithGson;

public class LoginStandardUser {

	WebDriver driver = new ChromeDriver();
	LoginPage login = new LoginPage(driver);
	HomePage home = new HomePage(driver);
	ConfiguraçãoChromeDriver configuracao = new ConfiguraçãoChromeDriver(driver);
	LeitorJsonWithGson leitorMassa = new LeitorJsonWithGson();
	long inicioTeste;
	long fimTeste;
	public static final Logger logger = Logger.getLogger(LoginStandardUser.class);

	@Before
	public void before() throws IOException, SQLException, ParseException {
		configuracao.configuraChromeDriver();
		inicioTeste = System.currentTimeMillis();
		leitorMassa = new LeitorJsonWithGson();
		leitorMassa.leitorJson("LoginStandardUser");
	}

	@Test
	public void loginStandardUser() {

		try {
			login.diretorio = "LoginStandardUser";
			login.acessaUrl(leitorMassa.getMassa("url"));
			login.preencheUsername(leitorMassa.getMassa("username"));
			login.preenchePassword(leitorMassa.getMassa("password"));
			login.efetuaLogin();
			Assert.assertEquals(true, home.acessarCarrinho());
			

		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
			fail();
		}
	}

	@After
	public void after() {
		driver.quit();
		fimTeste = System.currentTimeMillis();
		logger.info("Tempo total de execução: " + calculaTempoExecucao(inicioTeste, fimTeste) + " segundos");
	}


	public long calculaTempoExecucao(long inicio, long fim) {
		return (fim - inicio) / 1000;
	}
}
