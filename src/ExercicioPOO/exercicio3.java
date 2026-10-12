package ExercicioPOO;

class aluno{
    private String matricula;
    private String nome;
    private double nota1;
    private double nota2;

    public aluno(){
    }
    public  aluno(String matricula, String nome,double nota1, double nota2){
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    public double calcularMedia(){
        return (this.nota1 + this.nota2)/2.0;
    }
    public boolean verificarAprovacao(){
        return calcularMedia() >= 7.0;
    }
    // Getters e Setters

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
}
public class exercicio3 {
    public static void main(String[] args) {
        aluno aluno1 = new aluno("20212460","Karina", 5.9 , 8.3);
        System.out.println("Matricula: " + aluno1.getMatricula());
        System.out.println("Nome: " + aluno1.getNome());
        System.out.println( "Media: "+ aluno1.calcularMedia());
        if(aluno1.verificarAprovacao()){
            System.out.println("Aprovado");
        }else{
            System.out.println("Reprovado");
        }
    }
}
