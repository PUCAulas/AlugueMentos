
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class RegistroAluguelTest {

    @Test
    public void testCalcularCustoTotal() {
        Cliente cliente = new Cliente("João", "123456789");
        Equipamento equipamento = new Equipamento("E001", "Escavadeira", 50.0);
        Date dataInicio = new Date(2023, 9, 15);
        Date dataFim = new Date(2023, 9, 20);
        double valorDiario = equipamento.getValorDiario();
        RegistroAluguel registroAluguel = new RegistroAluguel(cliente, equipamento, dataInicio, dataFim, valorDiario);

        double custoTotal = registroAluguel.calcularCustoTotal();

        assertEquals(300.0, custoTotal, 0.01);
    }

    @Test
    public void testCalcularCustoTotalComDataInicioIgualDataFim() {
        Cliente cliente = new Cliente("Maria", "987654321");
        Equipamento equipamento = new Equipamento("E002", "Betoneira", 40.0);
        Date dataInicio = new Date(2023, 9, 10);
        Date dataFim = new Date(2023, 9, 10);
        double valorDiario = equipamento.getValorDiario();
        RegistroAluguel registroAluguel = new RegistroAluguel(cliente, equipamento, dataInicio, dataFim, valorDiario);


        double custoTotal = registroAluguel.calcularCustoTotal();

        assertEquals(0.0, custoTotal, 0.01);
    }
}
