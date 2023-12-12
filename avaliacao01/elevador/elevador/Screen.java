package elevador;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static Screen instance;
    public JLabel[] personagem;
    public JLabel Elevador, Portas, predio, fundo, elevador;

    public Screen(int n) {
        instance = this;
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 800);
        setResizable(false);
        personagem = new JLabel[n];

        for (int i = 0; i < personagem.length; i++) {
            personagem[i] = new JLabel();
            personagem[i].setBounds(500, 630 - i * (int) Predio.altura - 100, 100, 100);
            personagem[i].setIcon(new ImageIcon("imagem/personagem.png"));
            personagem[i].setVisible(false);
            add(personagem[i]);
        }

        
        Elevador();
        this.portas();
        Predio();
        background();
        repaint(100);
    }

   
    public void Elevador() {
        elevador = new JLabel();
        elevador.setBounds(250, 460, 120, 150);
        elevador.setVisible(true);
        elevador.setIcon(new ImageIcon("imagem/elevador.png"));
        add(elevador);
    }

    public void portas() {
        Portas = new JLabel();
        Portas.setBounds(350, 460, 100, 100);
        Portas.setVisible(true);
        Portas.setIcon(new ImageIcon("imagem/porta.png"));
        add(Portas);
    }

    public void Predio() {
        predio = new JLabel();
        predio.setBounds(115, 60, 550, 800);
        predio.setVisible(true);
        predio.setIcon(new ImageIcon("imagem/predio.png"));
        add(predio);
    }
    public void background() {
        fundo = new JLabel();
        fundo.setBounds(90, 0, 1620, 750);
        fundo.setVisible(true);
        fundo.setIcon(new ImageIcon("imagem/fundo.png"));
        add(fundo);
    }

}
