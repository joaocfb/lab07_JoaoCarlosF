package usuario;

import java.util.Iterator;

import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano extends Usuario {
	public static final double DESCONTO_VETERANO = 0.8;

	public Veterano(String nome, String login) throws StringInvalidaException {
		super(nome, login);
		setXp2(1000);
	}

	@Override
	public void compraJogo(Jogo jogo) throws Exception {
		double custo = jogo.getPreco() * DESCONTO_VETERANO;
		if (custo > this.getCredito()) {
			throw new ValorInvalidoException("Credito insuficiente para realizar a compra.");
		} else {
			int parteInteira =(int)( jogo.getPreco() - (jogo.getPreco() % 1));
			int bonusXp =  parteInteira * 15;
			setXp2(getXp2() + bonusXp);
			setCredito(getCredito() - custo);
			this.cadastraJogo(jogo);

		}
	}

	@Override
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) {
		Jogo jogo = super.buscaJogo(nomeJogo);
		int x2pparcial = jogo.registraJogada(scoreObtido, zerou);
		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)
				&& jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			
			super.setXp2(getXp2() + 30 + x2pparcial);
		} else if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
			
			super.setXp2(getXp2() + 10 + x2pparcial);
		} else if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			
			super.setXp2(getXp2() + 20 + x2pparcial);
		} 
		
	}
	
	@Override
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) {
		Jogo jogo = super.buscaJogo(nomeJogo);
		int x2pparcial = jogo.registraJogada(scoreObtido, zerou);
		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)
				&& jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)) {
			
			super.setXp2(getXp2() - 40 + x2pparcial);
		} else if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
			
			super.setXp2(getXp2() - 20 + x2pparcial);
		} else if (jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)) {
			
			super.setXp2(getXp2() - 20 + x2pparcial);
		}
		
	}
	
	@Override
	public String toString() {
		String myString = "Jogador Veterano: " + this.getLogin() + FIM_DE_LINHA;
		myString += this.getNome() + " - " + this.getXp2() + " x2p" + FIM_DE_LINHA;
		myString += "Lista de Jogos:" + FIM_DE_LINHA;

		Iterator itr = getMeusJogos().iterator();
		while (itr.hasNext()) {
			Jogo j = (Jogo) itr.next();
			myString += j.toString();
		}
		myString += FIM_DE_LINHA;
		myString += "Total de pre�o dos jogos: R$ " + this.calculaPrecoTotal() + FIM_DE_LINHA;
		myString += "--------------------------------------------";
		return myString;
	}

}
