package ExercicioPOO;
class carro{
    private String marca;
    private String modelo;
    private int ano;
    private double velocidadeAtual;
    private boolean ligada;

    public carro(){

    }

    public carro(String marca, String modelo,int ano,double velocidadeAtual,boolean ligada){
        this.marca= marca;
        this.modelo = modelo;
        this.ano= ano;
        this.velocidadeAtual= velocidadeAtual;
        this.ligada = ligada;
    }
    public void acelerar(double quantidade){
        if (quantidade>0){
            this.velocidadeAtual += quantidade;
            System.out.println("Velocidade atual: "+ this.velocidadeAtual + "km/h");
        }
        else{
            System.out.println("Acelere para o carro andar");
        }
    }
    public void frear(double quantidade){
        if (quantidade >= this.velocidadeAtual){
            this.velocidadeAtual = 0 ;
        }else {
            this.velocidadeAtual -= quantidade;
        }
        System.out.println("Velocidade atual: "+ this.velocidadeAtual + "km/h");
    }
    public void ligar(){
        if (!this.ligada ){
            this.ligada = true;
            System.out.println("Ligado");
        }else{
            System.out.println("Já está Ligado");
        }
    }
    public void desligar(){
        if (this.ligada ){
            this.ligada = false;
            System.out.println("Desligado");
        }else{
            System.out.println("Já está desligado");
        }
    }
    // get e setters

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca= marca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo= modelo;
    }

    public  int getAno(){
        return ano;
    }
    public  void setAno(int ano){
        this.ano= ano;
    }

    public double getVelocidadeAtual(){
        return velocidadeAtual;
    }
    public void setVelocidadeAtual (double velocidadeAtual){
        this.velocidadeAtual = velocidadeAtual;
    }

    public boolean isLigada() {
        return ligada;
    }
    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }
}


public class exercicio2 {
    public static void main(String[] args) {
        carro carro1 = new carro("TOYOTA", "Corolla", 2020, 82 , true );
        System.out.println("===== CARRO =====");
        System.out.println("Marca: " + carro1.getMarca());
        System.out.println("Modelo: " +carro1.getModelo());
        System.out.println("Ano: " + carro1.getAno());
        System.out.println("Velocidade: " + carro1.getVelocidadeAtual() + " Km/h");
        System.out.println("Ligado: " + carro1.isLigada());

        System.out.println("\nTestando ");
        carro1.acelerar(150);
        carro1.frear(60);
        carro1.desligar();
    }
}
