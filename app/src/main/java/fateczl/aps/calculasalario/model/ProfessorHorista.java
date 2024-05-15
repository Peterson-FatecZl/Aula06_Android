package fateczl.aps.calculasalario.model;

public class ProfessorHorista extends Professor {
    private int horasAula;
    private double valorHoraAula;

    //Construtor
    public ProfessorHorista(){
        super();
    }

    //Getters e Setters


    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    //Métodos
    @Override
    public double calcSalario() {
        int horaAula = getHorasAula();
        double valorHora = getValorHoraAula();
        double salarioFinal = horaAula * valorHora;

        return salarioFinal;
    }
}
