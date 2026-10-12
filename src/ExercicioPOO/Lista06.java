package ExercicioPOO;

import java.util.ArrayList;
import java.util.List;

class Produto {
    private int codigo;
    private String nome;
    private double precoBase;

    //Construtor vazio
    public Produto() {
        this.codigo = 0;
        this.nome = "Teste";
        this.precoBase = 0.0;
    }

    //Construtor custom
    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = 0.0;
    }

    // Construtor de modo geral
    public Produto(int codigo, String nome, double precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    //Metodo de negocio
    public double calcularPreco() {
        return this.precoBase;
    }

    public void exibirDetalhes() {
        System.out.println("Código: " + codigo + " | Produto: " + nome + " | Preço Base: R$ " + precoBase);
    }
}

class Eletronico extends Produto {
    private int voltagem;
    private int garantia;

    // Construtor vazio
    public Eletronico() {
        super();
        this.voltagem = 127;
        this.garantia = 12;
    }

    // Construtor custom
    public Eletronico(int codigo, String nome, double precoBase) {
        super(codigo, nome, precoBase);
        this.voltagem = 220;
        this.garantia = 12;
    }

    // Construtor: Modo geral
    public Eletronico(int codigo, String nome, double precoBase, int voltagem, int garantiaMeses) {
        super(codigo, nome, precoBase);
        this.voltagem = voltagem;
        this.garantia = garantiaMeses;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public int getGarantiaMeses() {
        return garantia;
    }

    public void setGarantiaMeses(int garantia) {
        this.garantia = garantia;
    }

    // Sobrescrita (Override) & Polimorfismo
    @Override
    public double calcularPreco() {
        return getPrecoBase() + (getPrecoBase() * 0.05);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println(" [Eletrônico] Voltagem: " + voltagem + "V | Garantia: " + garantia + " meses");
    }
}

class Vestuario extends Produto {
    private String tamanho;
    private String cor;

    // Construtor Vazio
    public Vestuario() {
        super();
        this.tamanho = "M";
        this.cor = "Verde";
    }

    // Construtor custom
    public Vestuario(int codigo, String nome, double precoBase) {
        super(codigo, nome, precoBase);
        this.tamanho = "G";
        this.cor = "Azul";
    }

    // Construtor total
    public Vestuario(int codigo, String nome, double precoBase, String tamanho, String cor) {
        super(codigo, nome, precoBase);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // Sobrescrita (Override) & Polimorfismo
    @Override
    public double calcularPreco() {
        return getPrecoBase() * 0.90;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println(" [Vestuário] Tamanho: " + tamanho + " | Cor: " + cor);
    }
}

class Cliente {
    private String nome;
    private String email;
    private String cpf;

    // Construtor 1: Vazio
    public Cliente() {
        this.nome = "Não informado";
        this.email = "sem@email.com";
        this.cpf = "000.000.000-00";
    }

    // Construtor 2: Customizado Parcial
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.cpf = "000.000.000-00";
    }

    // Construtor 3: Customizado Completo
    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

class Pedido {
    private String data;
    private Cliente cliente;
    private List<Produto> produtos;

    // Construtor 1: Vazio
    public Pedido() {
        this.data = "01/01/2026";
        this.cliente = new Cliente();
        this.produtos = new ArrayList<>();
    }

    // Construtor custom
    public Pedido(String data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    //Construtor customizado totalmente
    public Pedido(String data, Cliente cliente, List<Produto> produtos) {

        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
    }

    //Método de Negócio
    public double calcularValorTotal() {

        double total = 0;
        for (Produto p : produtos) {
            total += p.calcularPreco(); // Chama a sublcasse

        }
        return total;
    }

    public void emitirResumo() {
        System.out.println("==========================================");
        System.out.println(" COMPROVANTE DE PEDIDO");
        System.out.println("==========================================");

        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        System.out.println("------------------------------------------");

        System.out.println("Itens do Pedido:");
        for (Produto p : produtos) {
            p.exibirDetalhes();
            System.out.println(" -> Preço Calculado: R$ " + p.calcularPreco());

        }

        System.out.println("------------------------------------------");

        System.out.println("VALOR TOTAL DO PEDIDO: R$ " + calcularValorTotal());
        System.out.println("==========================================\n");
    }
}


public class Lista06 {
    public static void main(String[] args) {
        // Criando Cliente via Construtor Completo
        Cliente cliente1 = new Cliente("Pedro Souza", "pedro.souza@email.com", "087.401.343-44");

// Produtos via Construtores Customizados
        Eletronico notebook = new Eletronico(101, "Notebook Gamer", 4000.0, 220, 24);

        Vestuario camisa = new Vestuario(201, "Camiseta de Linho", 120.0, "M", "Cinza");

// Criando Produto via Construtor Vazio + Setters
        Eletronico fone = new Eletronico();
        fone.setCodigo(103);
        fone.setNome("Fone Bluetooth");
        fone.setPrecoBase(200.0);

       Vestuario CamisaPolo = new Vestuario();
        CamisaPolo.setCodigo(203);
        CamisaPolo.setNome("Camisa Polo");
        CamisaPolo.setPrecoBase(100.0);
// Criando o Pedido e adicionando os produtos
        Pedido pedido1 = new Pedido("22/09/2026", cliente1);
        pedido1.adicionarProduto(notebook);
        pedido1.adicionarProduto(camisa);
        pedido1.adicionarProduto(CamisaPolo);
// Emitindo Comprovante
        pedido1.emitirResumo();
    }
}

// Questão de reflexão: Observe a saída do console. O preço base da camiseta é R$ 100,00,
//mas quanto apareceu no valor calculado? Qual conceito de POO garantiu esse cálculo
//automático?
// Usa a mesma método, mas cada tipo de produto calcula o seu valor final do seu modo
//Por isso, saiu 90 reais, na sua classe ela calcula o preço inicial x 90% do valor