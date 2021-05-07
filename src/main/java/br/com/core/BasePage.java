package br.com.core;

import static br.com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	/********** Text Area / Field **********/
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);;
	}
	
	public void escrever(String id, String texto) {
		escrever(By.id(id), texto);
	}
	
	/********** Botao **********/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	/********** LINK **********/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
}
