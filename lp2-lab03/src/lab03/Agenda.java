package lab03;

import java.util.Arrays;
/**
 * Representacao de uma agenda no sistema, responsavel por armazenar uma lista de 100 posicoes
 * com os contatos e todos os metodos necessarios.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Agenda {
	/**
	 * Array de contatos.
	 */
	Contato[] contatos;
	
	/**
	 * Constroi uma agenda sem paramentros e com um array de 100 posicoes.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}
	
	/**
	 * Metodo que cadastra um contato na agenda a partir a sua posicao, nome, sobrenome e telefone
	 * passados pelo usuario.
	 * @param posicao a posicao que o contato ira ocupar na agenda.
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o telefone do contato.
	 * @return um boolean caso o numero seja adicionado com sucesso ou false caso contrario.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100)	{
			return false;
		} else {
			Contato contato = new Contato(nome, sobrenome, telefone);
			contatos[posicao - 1] = contato;
			return true;
		}
	}
	
	/**
	 * Metodo que pesquisa um contato a partir de sua posicao, desde que ela seja valida.
	 * @param posicao a posicao do contato que se deseja exibir .
	 * 
	 * @return a String "POSICAO INVALIDA!" caso a posicao seja menor que 1 ou maior que 100
	 * ou nao exista contato cadastrado nessa posicao, caso contrario exibe o contato cadastrado na posicao passada.  
	 */
	public String exibeContato(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA!";
		}
		else if (contatos[posicao-1] == null) {
			return "POSIÇÃO INVÁLIDA!";
		}else {
			return contatos[posicao-1].toString();
		}
	}
	
	/**
	 * Metodo que lista todos os contatos de uma agenda;
	 * 
	 * @return uma String em formato de lista com todos os contatos da agenda.
	 */
	public String listaContatos() {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				lista += String.format("%d", i + 1) + " - " + contatos[i].representacaoAgenda() + "\n";
			}
		}
		return lista;
	}
	
	/**
	 * Override do metodo hashcode que cria um numero identificador unico para uma agenda
	 * a partir do seu atributo contatos.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}
	
	/**
	 * Override do metodo equals que verifica se duas agendas sao iguais a partir de seus contatos.
	 * Duas agendas sao iguais se tiverem os mesmos contatos ocupando as mesmas posicoes nas listas.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	
	
}
