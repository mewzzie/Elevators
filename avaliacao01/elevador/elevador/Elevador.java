package elevador;

import java.util.concurrent.Semaphore;

public class Elevador extends Thread {

    public static final int numAndares = 5;
    Screen screen;

    static int destino = -1;
    public static Semaphore semaforo = new Semaphore(1);
    public static Passageiro requisitante;

    public Elevador(int numAndares) {
        numAndares = numAndares;
        screen = Screen.instance;
    }

    public void AbrePorta() {
        screen.Portas.setVisible(false);
    }

    public void FecharPorta() {
        screen.Portas.setVisible(true);
    }

    private void VisitarAndar() {
        screen.elevador.setBounds(250, 630 - (int) Predio.altura * destino, 100, 100);
        screen.Portas.setBounds(350, 630 - (int) Predio.altura * destino, 100, 100);
    }

    public void Esperar() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void SetDestino(int d, Passageiro p) {
        destino = d;
        requisitante = p;
    }

    @Override
    public void run() {
        while (true) {
            if (requisitante != null) {
                VisitarAndar();
                Esperar();
                AbrePorta();
                Esperar();
                Esperar();
                FecharPorta();
                Esperar();
            }
        }
    }
}