import java.util.Date;

class RegistroAluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private Date dataInicio;
    private Date dataFim;
    private double valorDiario;

    public RegistroAluguel(Cliente cliente, Equipamento equipamento, Date dataInicio, Date dataFim, double valorDiario) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
    }

    public double calcularCustoTotal() {
        long diferenca = dataFim.getTime() - dataInicio.getTime();
        int dias = (int) (diferenca / (24 * 60 * 60 * 1000));
        return dias * valorDiario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public double getValorDiario() {
        return valorDiario;
    }
}