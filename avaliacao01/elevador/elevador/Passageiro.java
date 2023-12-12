package elevador;

import java.util.concurrent.Semaphore;

public class Passageiro extends Thread {

    public int InPos;
    public int DesPos;
    public int index;
    public Elevador elevador;
    public Screen screen;
    public boolean chegou = false;
    public Semaphore semaforo = new Semaphore(1);

    public Passageiro(int index, int inicial, int des, Elevador elevador, Screen screen) {
        InPos = inicial;
        DesPos = des;
        this.elevador = elevador;
        this.screen = screen;
        this.index = index;
    }

    public void usarElevador(int andarIn, int andarDes, Screen telaPredio) {
        chamarElevador();
        Esperar();
        Esperar();
        entrar();
        Esperar();
        Esperar();
        ChegouDestino();
        Esperar();
        Esperar();
        sair();
        Esperar();
        Esperar();

        chegou = true;
    }

    public void Esperar() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    void chamarElevador() {
        Elevador.SetDestino(InPos, this);
    }

    void AbrirPorta() {
        elevador.AbrePorta();
    }

    public void entrar() {
        try {
            semaforo.acquire();
            screen.personagem[index].setBounds(250, 630 - (int) Predio.altura * InPos, 100, 100);
            Elevador.SetDestino(DesPos, this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void FecharPorta() {
        elevador.FecharPorta();
    }

    void ChegouDestino() {
        screen.personagem[index].setBounds(250, 630 - (int) Predio.altura * DesPos, 100, 100);
        semaforo.release();
    }

    public void sair() {
        screen.personagem[index].setBounds(125, 630 - (int) Predio.altura * DesPos, 100, 100);
        Elevador.requisitante = null;
    }

    @Override
    public void run() {
        while (!chegou) {
            try {
                Elevador.semaforo.acquire();
                usarElevador(InPos, DesPos, screen);
                Elevador.semaforo.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}