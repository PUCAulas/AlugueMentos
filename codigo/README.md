# Código do Projeto

CLASSE ALUGUEL

package aluguelDeEquipamentos;

import java.util.Date;

public class Aluguel {
	private String cliente;
    private Equipamento equipamento;
    private Date dataInicio;
    private Date dataTermino;
    private double valorDiario;

    public Aluguel(String cliente, Equipamento equipamento, Date dataInicio, Date dataTermino, double valorDiario) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorDiario = valorDiario;
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

CLASSE EQUIPAMENTOS

package aluguelDeEquipamentos;

import java.util.Date;

public class Equipamento {
	private String codigo;
    private String descricao;

    public Equipamento(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
