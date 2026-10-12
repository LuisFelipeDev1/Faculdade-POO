package ExercicioPOO.Lista6;

class Main {
    public static void main(String[] args) {
        // Instanciação dos objetos usando o Construtor com Parâmetros
        Cavaleiro arthur = new Cavaleiro("Arthur", 120, "Trovão");
        Mago merlin = new Mago("Merlin", 80, 15);
        Pocao pocao = new Pocao("Poção de Cura", 25);
        Arma espada = new Arma("Espada Longa", 30);
        Arma cajado = new Arma("Cajado de Carvalho", 18);

        System.out.println("--- Herança ---");
        System.out.println(arthur.getNome() + " tem " + arthur.getVida() + " de vida.");
        System.out.println(merlin.getNome() + " tem " + merlin.getVida() + " de vida.");
        arthur.cavalgar();
        merlin.lancarFeitico();
        merlin.lancarFeitico();

        System.out.println("\n--- Dependência ---");
        // A poção é entregue ao método, usada e não fica guardada em Merlin
        merlin.beberPocao(pocao);

        System.out.println("\n--- Associação ---");
        merlin.atacar();          // Merlin ainda não tem arma
        arthur.setArma(espada);   // a partir daqui Arthur guarda a referência da espada
        merlin.setArma(cajado);
        arthur.atacar();
        merlin.atacar();
        System.out.println("Arma guardada por " + arthur.getNome() + ": " + arthur.getArma().getNome());

        // Instancia do Arqueiro

        Arqueiro arqueiro = new Arqueiro("Robin",90, 2);

        Armadilha armadilha = new Armadilha("Fosso Com Espinhos", 20);

        Escudo escudo = new Escudo("Escudo de ferro", 15);

        System.out.println("\n--- Parte 2: Herança ---");

        System.out.println(arqueiro.getNome()+ "tem " + arqueiro.getVida()+ "de vida");

        arqueiro.dispararFlechas();
        arqueiro.dispararFlechas();
        arqueiro.dispararFlechas();

        System.out.println("\n--- Parte 2: Dependência ---");

        arqueiro.CairArmadilha(armadilha);

        System.out.println("\n--- Parte 2: Associação ---");

        arqueiro.defender();

        arqueiro.setEscudo(escudo);

        arqueiro.defender();

        System.out.println("Escudo guardado por "+ arqueiro.getNome()+ ": "+ escudo.getNome());
    }
}

// Superclasse
class Personagem {
    //Atributos Privados - Encapsulamento
    private String nome;
    private int vida;

    // ASSOCIAÇÃO
    private Arma arma;
    private  Escudo escudo;

    // Construtor Com Parâmetros (Inicialização)
    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    //  Métodos de Negócio (Comportamentos/Regras)
    // DEPENDÊNCIA: Personagem DEPENDE de Pocao
    public void beberPocao(Pocao pocao) {
        this.vida += pocao.getCura();
        System.out.println(this.nome + " bebeu " + pocao.getNome() + " e recuperou " + pocao.getCura() + " de vida. Vida atual: " + this.vida);
    }

    // Usa a ASSOCIAÇÃO: consulta a arma que está guardada no atributo
    public void atacar() {
        if (this.arma == null) {
            System.out.println(this.nome + " ataca sem arma e causa 1 de dano.");
        } else {
            System.out.println(this.nome + " ataca com " + this.arma.getNome() + " e causa " + this.arma.getDano() + " de dano.");
        }
    }
    public void CairArmadilha(Armadilha armadilha){
        this.vida -= armadilha.getDano();
        System.out.println(this.nome + " caiu em "+ armadilha.getNome()+ "e perdeu "+ armadilha.getDano()+ " de vida. Vida atual: " + this.vida);
    }

    public void defender(){
        if (this.escudo == null){
            System.out.println(this.nome + "se defende sem escudo e bloqueia 0 de dano. ");
        }else{
            System.out.println(this.nome + "se defende com " + escudo.getNome() + "bloqueia " + this.escudo.getDefesa() + " de dano.");
        }
    }
}

// Subclasses

class Cavaleiro extends Personagem {
    //Atributos Privados - Encapsulamento
    private String montaria;

    // Construtor: com o super(...) que chama o construtor da classe-mãe
    public Cavaleiro(String nome, int vida, String montaria) {
        super(nome, vida);
        this.montaria = montaria;
    }

    // Getters e Setters
    public String getMontaria() {
        return montaria;
    }

    public void setMontaria(String montaria) {
        this.montaria = montaria;
    }

    // Método próprio da subclasse
    public void cavalgar() {
        System.out.println(getNome() + " cavalga em " + this.montaria + ".");
    }
}

class Mago extends Personagem {
    // Atributos Privados - Encapsulamento
    private int mana;

    // Construtor: com o super(...) que chama o construtor da classe-mãe
    public Mago(String nome, int vida, int mana) {
        super(nome, vida);
        this.mana = mana;
    }

    // Getters e Setters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // Método próprio da subclasse
    public void lancarFeitico() {
        if (this.mana >= 10) {
            this.mana -= 10;
            System.out.println(getNome() + " lançou um feitiço! Mana restante: " + this.mana);
        } else {
            System.out.println(getNome() + " não tem mana suficiente.");
        }
    }
}

// Classe usada na DEPENDÊNCIA (
class Pocao {
    //Atributos Privados - Encapsulamento
    private String nome;
    private int cura;

    // Construtor Com Parâmetros
    public Pocao(String nome, int cura) {
        this.nome = nome;
        this.cura = cura;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }
}

// Classe usando a ASSOCIAÇÃO
class Arma {
    // Atributos Privados - Encapsulamento
    private String nome;
    private int dano;

    // Construtor Com Parâmetros
    public Arma(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}

// Classe usando a HERANÇA
class Arqueiro extends Personagem {
    // Atributos Privados - Encapsulamento
    private int flechas;

    // Construtor
    public Arqueiro(String nome, int vida, int flechas){
        super(nome, vida);
        this.flechas = flechas;
    }
    // Getters e Setters
    public int getFlechas(){
        return flechas;
    }
    public void setFlechas(int flechas){
        this.flechas= flechas;
    }
    // Metodo de negocio
    public void  dispararFlechas(){
        if (this.flechas >= 1){
            this.flechas -=1 ;
            System.out.println(getNome() + " disparou uma flecha! Flechas restantes: " + getFlechas());
        }else{
            System.out.println(getNome()+ " não tem flechas suficientes.");
        }
    }
}

//  Classe usando DEPENDÊNCIA
class Armadilha {
    // Atributos Privados - Encapsulamento
    private String nome;
    private int dano;

    // Construtor
    public Armadilha(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}

//  Classe usando a ASSOCIAÇÃO
class Escudo{
    // Atributos Privados - Encapsulamento
    private String nome;
    private  int defesa;

    // Construtor
    public Escudo(String nome, int defesa){
        this.nome = nome;
        this.defesa = defesa;
    }
    //Getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome= nome;
    }
    public int getDefesa(){
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}

// Os métodos cairEmArmadilha e defender foram escritos em Personagem. Arthur (Cavaleiro) e Merlin (Mago) também conseguem chamá-los?
// Sim, pois a classe mãe é Personagem e todas as outras subclasses Cavaleiro e Mago herdam os métodos da classe mãe por meio do extends