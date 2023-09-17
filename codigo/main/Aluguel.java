package main.java;

public class Aluguel {
	private Cliente cliente;
    private Equipamento equipamento;
    private int diaInicio;
    private int mesInicio;
    private int anoInicio;
    private int diaTermino;
    private int mesTermino;
    private int anoTermino;
    private double valorDiario;
    
    public Aluguel(Cliente cliente, Equipamento equipamento, int diaInicio, int mesInicio, int anoInicio, int diaTermino, int mesTermino, int anoTermino, double valorDiario) {
    	this.cliente = cliente;
    	this.equipamento = equipamento;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.anoInicio = anoInicio;
        this.diaTermino = diaTermino;
        this.mesTermino = mesTermino;
        this.anoTermino = anoTermino;
        this.valorDiario = valorDiario;
    }
    
    public double calcularValorTotal() {
        
        int numDias = calcularDiferencaDias();

        if (equipamento != null && equipamento.getValorEquipamento() > 0) {
            return numDias * equipamento.getValorEquipamento();
        } else {
            return numDias * valorDiario;
        }
    }
    
    private int calcularDiferencaDias() {
        int totalDiasInicio = anoInicio * 365 + mesInicio * 30 + diaInicio;
        int totalDiasTermino = anoTermino * 365 + mesTermino * 30 + diaTermino;
        return totalDiasTermino - totalDiasInicio;
    }
    
    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getDiaTermino() {
        return diaTermino;
    }

    public void setDiaTermino(int diaTermino) {
        this.diaTermino = diaTermino;
    }

    public int getMesTermino() {
        return mesTermino;
    }

    public void setMesTermino(int mesTermino) {
        this.mesTermino = mesTermino;
    }

    public int getAnoTermino() {
        return anoTermino;
    }

    public void setAnoTermino(int anoTermino) {
        this.anoTermino = anoTermino;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }
}
