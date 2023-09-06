package aluguelDeEquipamentos;

import java.util.Date;

public class Aluguel { 
    private String cliente; private Equipamento equipamento; private Date dataInicio; private Date dataTermino; private double valorDiario;

    public Aluguel(String cliente, Equipamento equipamento, Date dataInicio, Date dataTermino, double valorDiario) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorDiario = valorDiario;
    }

    public double calcularValorTotal() {
        long diferenca = dataTermino.getTime() - dataInicio.getTime();
        //converte para dias
        int numDias = (int) (diferenca / (24 * 60 * 60 * 1000)); //horas, minutos, segundos, milissegundos
        return numDias * valorDiario;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }
    }
