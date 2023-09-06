import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João", "joao@example.com");
    }

    @Test
    public void testGetNome() {
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testGetContato() {
        assertEquals("joao@example.com", cliente.getContato());
    }
}

