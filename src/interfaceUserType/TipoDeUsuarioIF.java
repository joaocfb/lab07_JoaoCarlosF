package interfaceUserType;

public interface TipoDeUsuarioIF {

	public void compraJogo(String nomeJogo);

	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws Exception;
	
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws Exception;
	
}
