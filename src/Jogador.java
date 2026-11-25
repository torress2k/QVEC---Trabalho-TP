import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Jogador {

    protected static final Scanner input = new Scanner(System.in);

    protected String nome;
    protected int hp; //pontos de vida atual
    protected int hpMaximo; //pontos de vida máximo
    protected int chakra;
    protected int chakraMaximo;
    protected boolean defendendo;
    protected boolean jaRecuperouChakra;
    protected List<Jutsu> jutsus = new ArrayList<>();
    protected Jutsu ultimoJutsu;

    //pra usar no pensarEstrategia()
    protected Jutsu jutsuEscolhido;
    protected int acaoEscolhida; // 1 = ataque, 2 = jutsu, 3 = defender, 4 = recuperar chakra

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

    public abstract void modificarRegra();

    public boolean estaVivo() {
        return hp > 0;
    }

    public void receberDano(int dano) {
        if (defendendo) {
            dano /= 2;
            defendendo = false;
            System.out.println(nome + " defendeu e reduziu o dano pela metade!");
        }
        hp = Math.max(0, hp - dano); //pro hp não ficar negativo se o dano for maior que o hp do personagem
        System.out.println(nome + " recebeu " + dano + " de dano. HP: " + hp + "/" + hpMaximo);
    }

    public void atacar(Jogador adversario) {
        //testando ataque básico
        int dano = 20;
        System.out.println(nome + " usou ataque básico!");
        adversario.receberDano(dano);
    }

    public void usarJutsu(Jutsu jutsu, Jogador adversario) {
        chakra -= jutsu.getCustoChakra();
        System.out.println(nome + " usou: " + jutsu.getNome() + "!");
        adversario.receberDano(jutsu.getDano());
        ultimoJutsu = jutsu; //pra ajudar com a regra de usar jutsus diferentes em sequencia dar mais dano
    }

    public boolean recuperarChakra() {
        if (jaRecuperouChakra) {
            System.out.println(nome + "Já recuperou chakra nesta batalha!");
            return false;
        }
        chakra = Math.min(chakraMaximo, chakra + 30);
        jaRecuperouChakra = true;
        System.out.println(nome + " recuperou chakra. Chakra: " + chakra + "/" + chakraMaximo);
        return true;
    }

    public void defender() {
        defendendo = true;
        System.out.println(nome + " está se defendendo!");
    }

    public void pensarEstrategia() {
        while (true) {
            System.out.println("\nVez de " + nome + " | HP: " + hp + "/" + hpMaximo + " | Chakra: " + chakra + "/" + chakraMaximo);
            System.out.println("1 - Ataque básico");
            System.out.println("2 - Jutsu");
            System.out.println("3 - Defender");
            System.out.println("4 - Recuperar Chakra");
            System.out.print("Escolha: ");

            int opcao;
            try {
                opcao = Integer.parseInt(input.nextLine().trim()); // o trim é pra deixar limpo tipo " 67 " vira "67"
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número de 1 a 4.");
                continue;
            }

            switch (opcao) {
                case 1:
                    acaoEscolhida = 1;
                    return;

                case 2:
                    //tem que fazer a parte de escolherJutsu
                case 3:
                    acaoEscolhida = 3;
                    return;

                case 4:
                    if (jaRecuperouChakra) {
                        System.out.println("Você já recuperou chakra nesta batalha!");
                    } else {
                        acaoEscolhida = 4;
                        return;
                    }
                    break;

                default:
                    System.out.println("Opção inexistente. Escolha de 1 a 4.");
            }
        }
    }

    public void aplicarEstrategia(Jogador adversario) {
        switch (acaoEscolhida) {
            case 1:
                atacar(adversario);
                break;

            case 2:
                usarJutsu(jutsuEscolhido, adversario);

            case 3:
                defender();
                break;

            case 4:
                recuperarChakra();
                break;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getChakra() {
        return chakra;
    }
}
