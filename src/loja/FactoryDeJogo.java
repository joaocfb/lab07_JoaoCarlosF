package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

public class FactoryDeJogo {

	public Jogo criaJogo(String jogoNome, double preco, Set<Jogabilidade> tiposJogabilidades, String estiloJogo) 
			throws StringInvalidaException, PrecoInvalidoException{
		String estilo = estiloJogo.toLowerCase();
		
		if (estilo.equals("rpg")) {
			return criarJogoRPG(jogoNome, preco, tiposJogabilidades);
		} else if (estilo.equals("plataforma")) {
			return criarJogoPlataforma(jogoNome, preco, tiposJogabilidades);
		} else if (estilo.equals("luta")) {
			return criarJogoLuta(jogoNome, preco, tiposJogabilidades);
		} else {
			return null;
		}
	}

	private Jogo criarJogoRPG(String jogoNome, double preco, Set<Jogabilidade> tiposJogabilidades) 
			throws StringInvalidaException, PrecoInvalidoException {
		 
		return new Rpg(jogoNome, preco, tiposJogabilidades);
	}
	
	private Jogo criarJogoLuta(String jogoNome, double preco, Set<Jogabilidade> tiposJogabilidades) 
			throws StringInvalidaException, PrecoInvalidoException {
		
		return new Luta(jogoNome, preco, tiposJogabilidades);
	}
	
	private Jogo criarJogoPlataforma(String jogoNome, double preco, Set<Jogabilidade> tiposJogabilidades) 
			throws StringInvalidaException, PrecoInvalidoException {
		
		return new Plataforma(jogoNome, preco, tiposJogabilidades);
	}
}
