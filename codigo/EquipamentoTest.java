package aluguelDeEquipamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipamentoTest {

   private Equipamento equipamento;

   @BeforeEach
   public void setUp() {
      equipamento = new Equipamento("123", "Equipamento de Teste");
   }

   @Test
   public void testGetCodigo() {
      assertEquals("123", equipamento.getCodigo());
   }

   @Test
   public void testSetCodigo() {
      equipamento.setCodigo("456");
      assertEquals("456", equipamento.getCodigo());
   }
}
