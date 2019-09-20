package lab03;

import java.util.Scanner;

/**
 * Representacao do menu do sistema. Responsavel por conter toda a logica e metodos do Menu.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Menu {
	/**
	 * Objeto para leitura de dados passadas pelo usuario.
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * Cria um objeto do tipo Agenda para que seus metodos sejam acessados.
	 */
	Agenda agenda = new Agenda();
	
	/**
	 * Metodo que imprime as opcoes do menu.
	 */
	public void opcoes() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air \n");
		System.out.print("Opção> ");
	}
	/**
	 * Metodo que realiza o cadastro de um novo contato na agenda, de acordo com os dados passados.
	 */
	public void cadastraContato() {
		System.out.print("\nPosição: ");
		int posicao = sc.nextInt();
		sc.nextLine();
		if (posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA! \n");
		} else {
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = sc.nextLine();
			System.out.print("Telefone: ");
			String telefone = sc.nextLine();
			if (agenda.cadastraContato(posicao, nome, sobrenome, telefone) == true) {
				System.out.println("CADASTRO REALIZADO! \n");
			} else {
				System.out.println("POSIÇÃO INVÁLIDA! \n");
			}
		}
	}
	/**
	 * Metodo que lista todos os contatos cadastrados na agenda.
	 */
	public void listaContatos() {
		System.out.println("\n" + agenda.listaContatos());
	}
	
	/**
	 * Metodo que exibe um contato especifico em determinada possicao da agenda de acordo com entrada
	 * passada pelo usuario.
	 */
	public void exibeContato() {
		System.out.print("Contato> ");
		int contato = sc.nextInt();
		sc.nextLine();
		System.out.println("\n" + agenda.exibeContato(contato) + "\n");
	}
}
