
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaAluguelTest {

    @Test
    public void testAdicionarRegistroAluguel() {
        SistemaAluguel sistemaAluguel = new SistemaAluguel();
        Cliente cliente = new Cliente("João", "123456789");
        Equipamento equipamento = new Equipamento("E001", "Escavadeira", 50.0);
        Date dataInicio = new Date(2023, 9, 15);
        Date dataFim = new Date(2023, 9, 20);
        double valorDiario = equipamento.getValorDiario();
        RegistroAluguel registroAluguel = new RegistroAluguel(cliente, equipamento, dataInicio, dataFim, valorDiario);

        sistemaAluguel.adicionarRegistroAluguel(registroAluguel);

        List<RegistroAluguel> registros = sistemaAluguel.getRegistrosAluguel();
        assertEquals(1, registros.size());
        assertEquals(registroAluguel, registros.get(0));
    }

    @Test
    public void testAdicionarCliente() {
        SistemaAluguel sistemaAluguel = new SistemaAluguel();
        Cliente cliente = new Cliente("Maria", "987654321");

        sistemaAluguel.adicionarCliente(cliente);

        List<Cliente> clientes = sistemaAluguel.getClientes();
        assertEquals(1, clientes.size());
        assertEquals(cliente, clientes.get(0));
    }

    @Test
    public void testConsultarAlugueisPorCliente() {
        SistemaAluguel sistemaAluguel = new SistemaAluguel();
        Cliente cliente = new Cliente("João", "123456789");
        Cliente outroCliente = new Cliente("Maria", "987654321");
        Equipamento equipamento = new Equipamento("E001", "Escavadeira", 50.0);
        Date dataInicio = new Date(2023, 9, 15);
        Date dataFim = new Date(2023, 9, 20);
        double valorDiario = equipamento.getValorDiario();
        RegistroAluguel registroAluguel = new RegistroAluguel(cliente, equipamento, dataInicio, dataFim, valorDiario);
        RegistroAluguel outroRegistro = new RegistroAluguel(outroCliente, equipamento, dataInicio, dataFim, valorDiario);

        sistemaAluguel.adicionarRegistroAluguel(registroAluguel);
        sistemaAluguel.adicionarRegistroAluguel(outroRegistro);

        List<RegistroAluguel> alugueisCliente = sistemaAluguel.consultarAlugueisPorCliente(cliente);
        assertEquals(1, alugueisCliente.size());
        assertEquals(registroAluguel, alugueisCliente.get(0));
    }

    @Test
    public void testCalcularReceitaMensal() {
        SistemaAluguel sistemaAluguel = new SistemaAluguel();
        Cliente cliente = new Cliente("João", "123456789");
        Equipamento equipamento = new Equipamento("E001", "Escavadeira", 50.0);
        Date dataInicio1 = new Date(2023, 9, 15);
        Date dataFim1 = new Date(2023, 9, 20);
        Date dataInicio2 = new Date(2023, 9, 1);
        Date dataFim2 = new Date(2023, 9, 5);
        double valorDiario = equipamento.getValorDiario();
        RegistroAluguel registroAluguel1 = new RegistroAluguel(cliente, equipamento, dataInicio1, dataFim1, valorDiario);
        RegistroAluguel registroAluguel2 = new RegistroAluguel(cliente, equipamento, dataInicio2, dataFim2, valorDiario);

        sistemaAluguel.adicionarRegistroAluguel(registroAluguel1);
        sistemaAluguel.adicionarRegistroAluguel(registroAluguel2);

        double receitaTotal = sistemaAluguel.calcularReceitaMensal(2023, 9);

        assertEquals(250.0, receitaTotal, 0.01);
    }
}
