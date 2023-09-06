package aluguelDeEquipamentos;


import java.util.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AluguelTest {

    @Test
    public void testCalcularValorTotal() {
        Equipamento equipamento = new Equipamento("E001", "Escavadeira");
        Date dataInicio = new Date();
        Date dataTermino = new Date(dataInicio.getTime() + 7 * 24 * 60 * 60 * 1000); // Data de término após 7 dias
        double valorDiario = 100.0;

        Aluguel aluguel = new Aluguel("ClienteA", equipamento, dataInicio, dataTermino, valorDiario);

        // O valor total deve ser 7 dias * 100.0 reais por dia = 700.0 reais
        double resultadoEsperado = 700.0;
        double resultadoCalculado = aluguel.calcularValorTotal();

        assertEquals(resultadoEsperado, resultadoCalculado, 0.001); // Usamos delta para lidar com a precisão de ponto flutuante
    }
}