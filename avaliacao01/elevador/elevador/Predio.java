package elevador;

public class Predio {

    Elevador elevador;

    public static float altura = 115;

    public Predio(int numAndares) {
        elevador = new Elevador(numAndares);
        Elevador.destino = 0;
        elevador.start();
    }

    public Elevador getElevador() {
        return this.elevador;
    }
}