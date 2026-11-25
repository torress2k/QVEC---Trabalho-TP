import java.util.ArrayList;

public interface Jogo {
    ArrayList<Jogador> iniciarJogo();

    void jogarTurno(Jogador atual, Jogador adversario);

    boolean jogoAcabou();

}
