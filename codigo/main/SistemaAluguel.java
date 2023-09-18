import java.util.ArrayList;
import java.util.List;


class SistemaAluguel {
    private List<RegistroAluguel> registrosAluguel;
    private List<Cliente> clientes;

    public SistemaAluguel() {
        registrosAluguel = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void adicionarRegistroAluguel(RegistroAluguel registro) {
        registrosAluguel.add(registro);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<RegistroAluguel> getRegistrosAluguel() {
        return registrosAluguel;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<RegistroAluguel> consultarAlugueisPorCliente(Cliente cliente) {
        List<RegistroAluguel> alugueisCliente = new ArrayList<>();
        for (RegistroAluguel registro : registrosAluguel) {
            if (registro.getCliente().getNome().equalsIgnoreCase(cliente.getNome())) {
                alugueisCliente.add(registro);
            }
        }
        return alugueisCliente;
    }

    public double calcularReceitaMensal(int ano, int mes) {
        double receitaTotal = 0;
        for (RegistroAluguel registro : registrosAluguel) {
            int anoRegistro = registro.getDataInicio().getYear() + 1900;
            int mesRegistro = registro.getDataInicio().getMonth() + 1;
            if (anoRegistro == ano && mesRegistro == mes) {
                receitaTotal += registro.calcularCustoTotal();
            }
        }
        return receitaTotal;
    }
}
