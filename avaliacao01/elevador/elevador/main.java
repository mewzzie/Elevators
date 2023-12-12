package elevador;


import java.util.Random;

public class main {

    public static void main(String[] args) {

        Passageiro[] passageiros;
        Screen ScreenPredio;
        Random rand = new Random();

        int numAndares = 6;
        int numPassageiros = 6;

        ScreenPredio = new Screen(numPassageiros);

        Predio predio = new Predio(numAndares);

        passageiros = new Passageiro[numPassageiros];

        int[] andaresOrigem = new int[numAndares];
        int[] andaresDestino = new int[numAndares];

        andaresDestino[0] = 0;
        for (int i = 1; i < numAndares; i++) {
            andaresDestino[i] = i;
        }
        andaresOrigem[0] = 0;
        for (int i = 1; i < numAndares; i++) {
            andaresOrigem[i] = i;
        }

        for (int i = 0; i < numPassageiros; i++) {
            int in = rand.nextInt(numAndares);
            int des = rand.nextInt(numAndares);

            while (des == in) {
                des = rand.nextInt(numAndares);
            }

            passageiros[i] = new Passageiro(i, in, des, predio.getElevador(), ScreenPredio);
            passageiros[i].start();
        }

        for (int i = 0; i < passageiros.length; i++) {
            ScreenPredio.personagem[i].setBounds(400, 630 - (int) Predio.altura * passageiros[i].InPos, 100, 100);
        }

        for (int i = 0; i < passageiros.length; i++) {
            ScreenPredio.personagem[i].setVisible(true);
        }
    }
}
