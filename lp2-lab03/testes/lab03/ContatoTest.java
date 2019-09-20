package lab03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Classe que testa a classe contato do sistema.
 * @author Lucas Oliveira Belmiro.
 *
 */
class ContatoTest {
	
	private Contato contato;

	@BeforeEach
	void setUp() {
		this.contato = new Contato("Lucas","Oliveira","(83) 98799-4481");
	}

	@Test
	void testExibeContato() {
		assertEquals("Lucas Oliveira - (83) 98799-4481", this.contato.toString());
	}

	@Test
	void testToString() {
		assertEquals("Lucas Oliveira", this.contato.representacaoAgenda());
	}
	
	@Test
	void testValoresNulosNoConstrutor() {
		try {
			this.contato = new Contato(null,"Batista","(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro nome nulo");
		}catch (NullPointerException npe){
			
		}
		
		try {
			this.contato = new Contato("Flávia",null,"(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro sobrenome nulo");
		}catch (NullPointerException npe){
			
		}
		
		try {
			this.contato = new Contato("Flávia","Batista",null);
			fail("Era esperado exceção ao receber parâmetro telefone nulo");
		}catch (NullPointerException npe){
			
		}
	}
	
	@Test
	void testValoresInvalidosNoConstrutor() {
		try {
			this.contato = new Contato("      ","Batista","(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro nome com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
		
		try {
			this.contato = new Contato("","Batista","(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro nome com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
		
		try {
			this.contato = new Contato("Flávia","           ","(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro sobrenome com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
		
		try {
			this.contato = new Contato("Flávia","","(27) 2147-4846");
			fail("Era esperado exceção ao receber parâmetro sobrenome com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
		
		try {
			this.contato = new Contato("Flávia","Batista","     ");
			fail("Era esperado exceção ao receber parâmetro telefone com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
		
		try {
			this.contato = new Contato("Flávia","Batista","");
			fail("Era esperado exceção ao receber parâmetro telefone com valor inválido");
		}catch (IllegalArgumentException iae){
			
		}
	}
	
	@Test
	void testEqualsContato() {
		//Testando ao enviar o próprio contato que invoca
		assertTrue(contato.equals(contato));
		//Testando ao enviar null
		assertFalse(contato.equals(null));
		//Testando com objeto contendo nome e sobrenome iguais
		Contato outroContato = new Contato("Lucas", "Oliveira", "(83) 99388-8772");
		assertTrue(contato.equals(outroContato));
		//Testando com objeto contendo somente nome e sobrenome iguais
		outroContato = new Contato("Lucas", "Oliveira", "(27) 99468-2839");
		assertTrue(contato.equals(outroContato));
		//Testando com objeto de campo nome diferente
		outroContato = new Contato("Joao", "Oliveira", "(27) 99468-2839");
		assertFalse(contato.equals(outroContato));
		//Testando com objeto de campo sobrenome diferente
		outroContato = new Contato("Lucas", "Belmiro", "(27) 99468-2839");
		assertFalse(contato.equals(outroContato));
		//Testando ao comparar dois objetos de classes diferentes
		Object obj = new Object();
		assertFalse(contato.equals(obj));
	}
}
