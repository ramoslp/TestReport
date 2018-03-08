package br.unipe.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static final int LOAD_TIMEOUT = 30;

	private WebElement MENU_PRIMEIRO_DESAFIO = Selenium.getDriver().findElement(By.cssSelector("a[href*='1desafio']"));

	public void acessarPrimeiroDesafio() {
		click(MENU_PRIMEIRO_DESAFIO);
	}
	
	public void click(WebElement element){
		try {
			aguardarElementoVisivel(element);
			element.click();
		} catch (Exception e) {
			//Utils.takeScreenshot(true);
			Assert.fail("Nao foi possivel encontrar o elemento para clicar: "+element +". Pagina: " +Selenium.getDriver().getTitle()+"\n "+e.getMessage());
		}
	}

	public void aguardarElementoVisivel(WebElement element){
		try {
			WebDriverWait driverWait = new WebDriverWait(Selenium.getDriver(), LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			//Utils.takeScreenshot(true);
			Assert.fail("Tempo excedido para aguardar elemento: "+element);
		}
	}

}