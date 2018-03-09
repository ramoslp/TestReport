package br.unipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unipe.common.Parametro;
import br.unipe.pages.BasePage;
import br.unipe.pages.DesafioSeleniumPage;

public class DesafioSeleniumTest extends BaseTestCase{
	
	BasePage basePage = new BasePage();
	DesafioSeleniumPage desafioSeleniumPage = new DesafioSeleniumPage();
	
	@Before
	public void before() {
		System.out.println("=================================================================");
		Parametro.CONTADOR_SCREENSHOT= "000";
	}
	
	@After
	public void after() {
		System.out.println("=================================================================");
	}
	
	@Test
	public void primeiroDesafio() {
		Parametro.METHOD_NAME_TEST = "Primeiro Desafio";
		desafioSeleniumPage.primeiroDesafio();
	}
	
	@Test
	public void segundoDesafio() {
		desafioSeleniumPage.segundoDesafio();
	}

}