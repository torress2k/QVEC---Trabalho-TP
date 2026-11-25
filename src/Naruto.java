public final class Naruto extends Jogador {
    public Naruto(){
        super("Naruto Uzumaki", 120,100 );
        jutsus.add(new Jutsu("Rasengan", 30,35));
        jutsus.add(new Jutsu("Clone das sombras", 20,25));
    }

    @Override
    public void contarHistoria(){
        System.out.println("Naruto nasceu na Vila Oculta da Folha e teve uma infância difícil. " +
                "Quando ainda era bebê, a Raposa de Nove Caudas foi selada em seu corpo, fazendo com que os moradores da vila o rejeitassem e o tratassem como uma ameaça.");
        System.out.println("Crescendo sozinho, Naruto passou a fazer travessuras para chamar atenção, mas nunca abandonou seu maior sonho: Se tornar Hokage e conquistar o respeito de todos.");
        System.out.println("Após se formar na Academia Ninja, entrou para o Time 7, ao lado de Sasuke e Sakura, sob a liderança de Kakashi. Agora, participa do Exame Chūnin determinado a provar seu valor.");
    }

    @Override
    public void modificarRegra(){
        System.out.println("Regra modificada: bônus de 15% de dano ao usar jutsus diferentes em turnos consecutivos.");
    }
}
