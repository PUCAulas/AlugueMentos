import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testGetNome() {
        Cliente cliente = new Cliente("João", "123456789");
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testGetTelefone() {
        Cliente cliente = new Cliente("Maria", "987654321");
        assertEquals("987654321", cliente.getTelefone());
    }
}
