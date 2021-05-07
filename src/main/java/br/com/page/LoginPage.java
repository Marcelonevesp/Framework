package br.com.page;

import static br.com.core.DriverFactory.getDriver;

import br.com.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarSite() {
		getDriver().get("http://automationpractice.com/index.php?controller=authentication");
	}

	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha (String senha) {
		escrever("passwd", senha);
	}
	
	public void clicarBotaoSignIn() {
		clicarBotao("SubmitLogin");
	}
}
