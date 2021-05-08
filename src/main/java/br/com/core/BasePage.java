package br.com.core;

import static br.com.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	
	/********** Obter texto **********/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

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
	
	public void moverMouse(By by, String botao) {
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(by);
		action.moveToElement(we).moveToElement(getDriver().findElement(By.xpath(botao))).click().build().perform();
	}
	
	/********** Link **********/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********** Alert **********/
	
	public void confirmarAlerta() {
		Alert alerta = getDriver().switchTo().alert();
		alerta.accept();
	}
	
	/********** Tabelas  **********/
	
	public WebElement obterCelula(String idTabela, String colunaBusca, String valorColunaBusca, String colunaInteracao) {
		
		//Identificando a tabela
		WebElement tabela = getDriver().findElement(By.id(idTabela));
		
		//obter a coluna (TD)
		int idColuna = obterColunaTabela(tabela, colunaBusca);
		
		//obter a linha (TR)
		int idLinha = obterLinhaTabela(valorColunaBusca, idColuna, tabela);
		
		//obter coluna de interacao
		int idColunaInteracao = obterColunaTabela(tabela, colunaInteracao);
		
		//obtendo a celula
		WebElement celula = tabela.findElement(By.xpath("//tbody/tr["+idLinha+"]/td["+idColunaInteracao+"]"));
		return celula;
	}

	private int obterColunaTabela(WebElement tabela, String coluna) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i=0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}

	private int obterLinhaTabela(String valorColunaBusca, int idColuna, WebElement tabela) {
		List<WebElement> linhas = tabela.findElements(By.xpath("//*[@id='cart_summary']/tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i=0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().contains(valorColunaBusca)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
