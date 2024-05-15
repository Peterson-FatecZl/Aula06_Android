package fateczl.aps.calculasalario.model;

public class ProfessorTitular extends Professor{
    private int anosInstituicao;
    private double salario;

    //Construtor
    public ProfessorTitular(){
        super();
    }

    //Getters e Setters


    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Métodos
    @Override
    public double calcSalario() {
        double salario = getSalario();
        double incrementoValor = salario * 0.05;
        int anos = getAnosInstituicao();
        int incrementoBaseadoNosAnos = anos / 5;

        double SalarioFinal =(incrementoValor * incrementoBaseadoNosAnos) + salario;
        return SalarioFinal;
    }

}
