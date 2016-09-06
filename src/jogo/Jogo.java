package jogo;

import java.util.HashSet;
import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public abstract class Jogo {
	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String nome;
	private double preco;
	private int vezesJogadas;
	private int vezesConcluidas;
	private int maiorScore;
	Set<Jogabilidade> jogabilidades;
	/**
	 * Construtor da classe abstrata Jogo
	 * @param String
	 * @param double
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */

	public Jogo(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		jogabilidades = new HashSet<Jogabilidade>();
	}
	/**
	 * Construtor da classe abstrata Jogo
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo(String nome, double preco, Set<Jogabilidade> jogabilidades)
			throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		this.jogabilidades = jogabilidades;
	}
	/**
	 * Classe que registra a jogada e retorna o valor que será usado em X2P de Usuario
	 * @param score
	 * @param venceu
	 * @return int
	 */
	public abstract int registraJogada(int score, boolean venceu);
	// Getters e Setters
	public double getPreco() {
		return this.preco;
	}

	public String getNome() {
		return this.nome;
	}

	public int getMaiorScore() {
		return this.maiorScore;
	}

	public void setMaiorScore(int novoScore) {
		this.maiorScore = novoScore;
	}

	public int getvezesConcluidas() {
		return this.vezesConcluidas;
	}

	public void setVezesConcluidas(int novaQuantidade) {
		this.vezesConcluidas = novaQuantidade;
	}

	public int getVezesJogadas() {
		return this.vezesJogadas;
	}

	public void setVezesJogadas(int novaQuantidade) {
		this.vezesJogadas = novaQuantidade;
	}
	
	public Set<Jogabilidade> getJogabilidade() {
		return this.jogabilidades;
	}
	
	/**
	 * Override do toString de Java
	 */
	@Override
	public String toString() {
		String resultado = "==> Jogou " + getVezesJogadas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Zerou " + getvezesConcluidas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Maior Score: " + getMaiorScore() + FIM_DE_LINHA;
		return resultado;
	}
	/**
	 * Override do equals de Java
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo temp = (Jogo) obj;

			return this.getNome().equals(temp.getNome()) && this.getPreco() == temp.getPreco();

		} else {
			return false;
		}

	}
}
