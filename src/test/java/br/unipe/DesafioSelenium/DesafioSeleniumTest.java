package br.unipe.DesafioSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unipe.test.BaseTestCase;

public class DesafioSeleniumTest extends BaseTestCase{
	
	DesafioSeleniumPage desafioSeleniumPage = new DesafioSeleniumPage();
	
	@Before
	public void before() {
		System.out.println("=================================================================");
	}
	
	@After
	public void after() {
		System.out.println("=================================================================");
	}
	
	@Test
	public void desafioSelenium() {
		desafioSeleniumPage.desafioSelenium();
	}

}