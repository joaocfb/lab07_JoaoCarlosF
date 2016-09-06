package loja;

import usuario.Usuario;

public class LojaFacade {
	private LojaController controller;
	
	public LojaFacade() {
		this.controller = new LojaController();
	}
	
	public void criaUsuario(String nome, String login, String tipoUsuario) {
		this.controller.criaUsuario(nome, login, tipoUsuario);
	}
	
	public void vendeJogo(String jogoNome, double preco, 
			String jogabilidades, String estiloJogo, String loginUser) {
		
		this.controller.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}
	
	public void recompensar(String login, String nomeJogo, 
			int score, boolean venceu) {
		
		this.controller.recompensar(login, nomeJogo, score, venceu);
	}
	
	public void punir(String login, String nomeJogo,
			int score, boolean venceu) {
		
		this.controller.punir(login, nomeJogo, score, venceu);
	}
	
	public void adicionaCredito(String login, double credito) {
		this.controller.adicionaCredito(login, credito);
	}
	
	public Usuario buscaUsuario(String login) {
		return this.controller.buscaUsuario(login);
	}
	
	public void upgrade(String login) throws Exception {
		this.controller.upgrade(login);
	}
	
	public double confereCredito(String login) {
		return this.controller.confereCredito(login);
	}
	
	public String informacaoUsuarios() {
		return this.controller.informacaoUsuarios();
	}
	
	public int getX2p(String login) {
		return this.controller.getX2p(login);
	}
	
}
