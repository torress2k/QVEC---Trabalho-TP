public class Jutsu {
    //Depois que o nome e o dano são atribuídos eles não serão mais trocados. por isso o final.
    private final String nome;
    private final int custoChakra;
    private final int dano;

    public Jutsu(String nome, int custoChakra, int dano) {
        this.nome = nome;
        this.custoChakra = custoChakra;
        this.dano = dano;
    }

    //getters
    public String getNome() {
        return nome;
    }

    public int getCustoChakra() {
        return custoChakra;
    }

    public int getDano() {
        return dano;
    }
}
