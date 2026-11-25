public final class Sasuke extends Jogador{
    public Sasuke(String nome, int hpMaximo, int chakraMaximo) {
        super(nome, hpMaximo, chakraMaximo);
        jutsus.add(new Jutsu("Chidori", 35, 40));
        jutsus.add(new Jutsu("Bola de Fogo", 25, 25));
    }
}
