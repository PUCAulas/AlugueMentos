package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EquipamentoTest {
	@Test
    public void testEquipamento() {
        Equipamento equipamento = new Equipamento("003", "Máquina de Lavar", 100.0);

        //Mostra valor do equipamento
        assertEquals("003", equipamento.getCodigo());
        assertEquals("Máquina de Lavar", equipamento.getDescricao());
        assertEquals(100.0, equipamento.getValorEquipamento());

        //Altera os valores do equipamento
        equipamento.setCodigo("004");
        equipamento.setDescricao("Secadora");
        equipamento.setValorEquipamento(150.0);

        //Confere se atualizou
        assertEquals("004", equipamento.getCodigo());
        assertEquals("Secadora", equipamento.getDescricao());
        assertEquals(150.0, equipamento.getValorEquipamento());
    }
}
