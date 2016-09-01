package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class Rpg extends Jogo{
	public final static int TAXA_XP2 = 10;
	/**
	 * Construtor da subclasse RPG
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Rpg(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	/**
	 * Construtor da subclasse RPG
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Rpg (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
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
		return TAXA_XP2;
	}
	/**
	 * toString da classe RPG
	 */
	public String toString() {
		String resultado = getNome() + " - RPG:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
