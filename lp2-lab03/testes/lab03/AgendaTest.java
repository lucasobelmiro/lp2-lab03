package lab03;
/**
 * Classe que testa a classe agenda do sistema
 * @author Lucas Oliveira Belmiro - 118210068
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	private Agenda agenda;

	@BeforeEach
	void setUp() {
		agenda = new Agenda();
	}

	@Test
	void testCadastraContato() {
		// Tentando inserir contatos válidos em posições válidas
		assertTrue(agenda.cadastraContato(1, "Luiz", "José", "(27) 99468-2839"));
		assertTrue(agenda.cadastraContato(60, "Joana", "Patricia", "(66) 98854-9153"));
		assertTrue(agenda.cadastraContato(100, "Joao", "Pedro", "(63) 99297-3120"));
		// Tentando inserir contatos válidos em posições INVÁLIDAS
		assertFalse(agenda.cadastraContato(-1, "Joana", "Júlia", "(66) 3690-9302"));
		assertFalse(agenda.cadastraContato(0, "Josefa", "José", "(91) 99176-8349"));
		assertFalse(agenda.cadastraContato(101, "Patrícia", "Joana", "1234"));
	}

	@Test
	void testPesquisaContato() {
		// Inserindo contatos
		agenda.cadastraContato(100, "Joana", "José", "(92) 98142-1683");
		agenda.cadastraContato(1, "Luiz", "José", "(37) 99265-1394");
		agenda.cadastraContato(54, "Juliana", "Maria", "(92) 99222-1950");
		// Procurando contatos em posições que foram cadastradas
		assertEquals("Luiz José - (37) 99265-1394", agenda.exibeContato(1));
		assertEquals("Joana José - (92) 98142-1683", agenda.exibeContato(100));
		assertEquals("Juliana Maria - (92) 99222-1950", agenda.exibeContato(54));
		// Procurando contatos em posições que não foram cadastradas
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(0));
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(101));
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(52));
	}

	@Test
	void testToString() {
		// Inserindo contatos na agenda e verificando o método toString().
		agenda.cadastraContato(1, "Luiz", "Almeida", "(91) 98213-9829");
		agenda.cadastraContato(100, "Maria", "Joana", "(81) 98135-7356");
		agenda.cadastraContato(25, "Julio", "Neves", "(86) 99456-0924");
		agenda.cadastraContato(12, "Juliano", "Cabral", "(27) 98968-9451");
		assertEquals("1 - Luiz Almeida\n12 - Juliano Cabral\n25 - Julio Neves\n100 - Maria Joana\n",
				agenda.listaContatos());
	}
	
	@Test
	void testEqualsAgenda() {
		//Inserindo contatos na agenda
		agenda.cadastraContato(100, "Joana", "José", "(27) 98968-9451");
		agenda.cadastraContato(1, "Luiz", "José", "(83) 99857-5251");
		agenda.cadastraContato(54, "Juliana", "Maria", "(84) 99948-7920");
		agenda.cadastraContato(5, "Joana", "Bonifácio", "(43) 98379-1037");
		agenda.cadastraContato(98, "Luiz", "Sousa", "(83) 99592-7651");
		agenda.cadastraContato(24, "Juliana", "Carneiro", "(98) 98916-1450");
		//Criando outro objeto Agenda com o mesmo conteúdo
		Agenda outraAgenda = new Agenda();
		outraAgenda.cadastraContato(100, "Joana", "José", "(27) 98968-9451");
		outraAgenda.cadastraContato(1, "Luiz", "José", "(83) 99857-5251");
		outraAgenda.cadastraContato(54, "Juliana", "Maria", "(84) 99948-7920");
		outraAgenda.cadastraContato(5, "Joana", "Bonifácio", "(43) 98379-1037");
		outraAgenda.cadastraContato(98, "Luiz", "Sousa", "(83) 99592-7651");
		outraAgenda.cadastraContato(24, "Juliana", "Carneiro", "(98) 98916-1450");
		assertTrue(agenda.equals(outraAgenda));
		//Testando ao enviar o próprio contato que invoca
		assertTrue(agenda.equals(agenda));
		//Testando ao enviar null
		assertFalse(agenda.equals(null));
		//Testando ao comparar dois objetos de classes diferentes
		Object obj = new Object();
		assertFalse(agenda.equals(obj));
	}
}
