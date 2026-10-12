package ExercicioPOO;

class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    private boolean ativa;

    public ContaBancaria() {
    }

    public ContaBancaria(String numeroConta, String titular, double saldo, boolean ativa) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.ativa = ativa;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso!");
        System.out.println("Seu saldo atual é " + this.saldo);
    }

    // Corrigido de 'void' para 'boolean'
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    //Get e setters


    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
public  class Exercicio1 {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12051423-4", "Felipe",1000,true);
        System.out.println("===== Dados Bancários =====");
        System.out.println("Conta " + conta1.getNumeroConta());
        System.out.println("Titular " + conta1.getTitular());
        System.out.println("Saldo " + conta1.getSaldo());
        System.out.println("Ativa " + conta1.isAtiva());

        conta1.depositar(500);
        System.out.println("Foi depositado" + conta1.getSaldo());
        System.out.println( "Seu saldo é de" + conta1.consultarSaldo());

    }

}
