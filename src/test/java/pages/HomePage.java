package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	final String CARRINHO = "//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[@id='shopping_cart_container']/a[1]";
	final String IMAGEM = "//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/img[1]";
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean acessarCarrinho(){
		return driver.findElement(By.xpath(CARRINHO)).isDisplayed(); 
		
	}
	
	public boolean imagemNaoCarregada(){
		return driver.findElement(By.xpath(IMAGEM)).isDisplayed(); 
		
	}


}
