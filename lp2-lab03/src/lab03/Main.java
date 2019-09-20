package lab03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();	
		char op;
		
		do{
			menu.opcoes();
			op = sc.nextLine().toUpperCase().charAt(0);
			
			if ('C' == op) {
				menu.cadastraContato();
			}else if ('L' == op) {
				menu.listaContatos();
			}else if ('E' == op) {
				menu.exibeContato();
			}
			else if (op!='C' && op!='L' && op!='E' && op !='S') {
				System.out.println("OPÇÃO INVÁLIDA! \n");
			}
		} while (op != 'S');
		
		sc.close();
	}
}
