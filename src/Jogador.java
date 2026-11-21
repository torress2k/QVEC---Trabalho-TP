public abstract class Jogador {
    protected String nome;
    protected int hp; //pontos de vida atual
    protected int hpMaximo; //pontos de vida máximo
    protected int chakra;
    protected int chakraMaximo;
    protected boolean defendendo;
    protected boolean jaRecuperouChakra;

    public Jogador(String nome, int hp, int hpMaximo, int chakra, int chakraMaximo, boolean defendendo, boolean jaRecuperouChakra) {
        this.nome = nome;
        this.hp = hp;
        this.hpMaximo = hpMaximo;
        this.chakra = chakra;
        this.chakraMaximo = chakraMaximo;
        this.defendendo = defendendo;
        this.jaRecuperouChakra = jaRecuperouChakra;
    }

    public abstract void contarHistoria();

    public boolean estaVivo(){
        return hp > 0;
    }

    public void receberDano(int dano){
        if(defendendo){
            dano /= 2;
            defendendo = false;
            System.out.println(nome + " defendeu e reduziu o dano pela metade!");
        }
        hp = Math.max(0, hp - dano); //pro hp não ficar negativo se o dano for maior que o hp do personagem
        System.out.println(nome + " recebeu " + dano + " de dano. HP: " + hp + "/" + hpMaximo);
    }

    public void atacar(Jogador adversario){
        //testando ataque básico
        int dano = 20;
        System.out.println(nome + " usou ataque básico!");
        adversario.receberDano(dano);
    }

    public boolean recuperarChakra(){
        if(jaRecuperouChakra){
            System.out.println(nome + "Já recuperou chakra nesta batalha!");
            return false;
        }
        chakra = Math.min(chakraMaximo, chakra + 30);
        jaRecuperouChakra = true;
        System.out.println(nome + " recuperou chakra. Chakra: " + chakra + "/" + chakraMaximo);
        return true;
    }

    public void defender(){
        defendendo = true;
        System.out.println(nome + " está se defendendo!");
    }
}
