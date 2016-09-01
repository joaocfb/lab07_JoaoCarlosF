package loja;

import usuario.Noob;
import usuario.Usuario;

public class FactoryDeUsuario {

	public Usuario criaUsuario(String nome, String login) {
		try {
			return new Noob(nome, login);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
