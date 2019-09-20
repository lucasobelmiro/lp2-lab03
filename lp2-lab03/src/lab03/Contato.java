package lab03;
/**
 * Representacao de um contato no sistema com todos os atributos e metodos especificos.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Contato {
	/**
	 * O nome do contato.
	 */
	private String nome;
	/**
	 * O sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * O numero telefonico do contato.
	 */
	private String telefone;
	
	/**
	 * Constroi um contato no sistema a partir do seu nome, sobrenome e telefone,
	 * verifica se os parametros passados sao validos, caso contrario lanca excecao de acordo
	 * com o erro constatado.
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o numero telefonico do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo.");
		}
		if (sobrenome == null) {
			throw new NullPointerException("Sobrenome nulo.");
		}
		if (telefone == null) {
			throw new NullPointerException("Telefone nulo.");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido.");
		}
		if (sobrenome.trim().isEmpty()) {
			throw new IllegalArgumentException("Sobrenome inválido.");
		}
		if (telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Telefone inválido.");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Metodo que retorna a representacao em String de um contato quando se deseja
	 * listar todos os contatos de uma agenda. 
	 * 
	 * @return uma String com a formatacao "Nome Sobrenome".
	 */
	public String representacaoAgenda() {
		return this.nome + " " + this.sobrenome;
	}
	
	/**
	 * Metodo que retorna a representacao em String de um contato quando se deseja
	 * exibir especificamente um contato.
	 * 
	 * @return uma String com a formatacao "Nome Sobrenome - Telefone".
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}
	
	/**
	 * Override do metodo hashCode, que gera um codigo identificador para cada contato,
	 * a partir do nome e sobrenome do contato.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}
	
	/**
	 * Override do metodo equals que verifica se dois contatos sao iguais a partir do nome e sobrenome.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
}