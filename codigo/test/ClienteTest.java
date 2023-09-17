package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.java.Cliente;

public class ClienteTest {
	
	@Test
	public void testGetNome() {
		Cliente cliente = new Cliente("Joao", "joao@gmail.com");
		assertEquals("Maria", cliente.getNome());
	}
}