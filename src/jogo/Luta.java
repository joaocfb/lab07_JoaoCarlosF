package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class Luta extends Jogo{
	/**
	 * Construtor da subclasse 
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Luta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	/**
	 * Construtor da subclasse 
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Luta (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}
	/**
	 * Override do metodo registraJogada
	 */
	@Override
	public int registraJogada(int score, boolean venceu) {
		setVezesJogadas(getVezesJogadas()+ 1);
		if(score > this.getMaiorScore()){
			setMaiorScore(score);
		}
		if(venceu){
			setVezesConcluidas(getvezesConcluidas() + 1);
			
		}
		return score/1000;
	}
	/**
	 * toString da classe Luta
	 */
	public String toString() {
		String resultado = getNome() + " - Luta:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}
}
