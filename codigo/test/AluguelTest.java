package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.java.Aluguel;
import main.java.Equipamento;

public class AluguelTest {
	
	@Test
	void testCalcularValorTotalComEquipamento() {
	    Equipamento equipamento = new Equipamento("002", "Furadeira", 100.0);
	    //data de início = 1/9/2023 e data de término = 10/9/2023
	    Aluguel aluguel = new Aluguel(null, equipamento, 1, 9, 2023, 10, 9, 2023, 0.0);
	    
	    //9 dias * 100.0 (valor do equipamento) = 900.0
	    assertEquals(900.0, aluguel.calcularValorTotal());
	}
}
