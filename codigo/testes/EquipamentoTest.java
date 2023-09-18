import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipamentoTest {

    @Test
    public void testGetCodigo() {
        Equipamento equipamento = new Equipamento("123", "Escavadeira", 50.0);
        assertEquals("123", equipamento.getCodigo());
    }

    @Test
    public void testGetDescricao() {
        Equipamento equipamento = new Equipamento("456", "Betoneira", 50.0);
        assertEquals("Betoneira", equipamento.getDescricao());
    }
}
