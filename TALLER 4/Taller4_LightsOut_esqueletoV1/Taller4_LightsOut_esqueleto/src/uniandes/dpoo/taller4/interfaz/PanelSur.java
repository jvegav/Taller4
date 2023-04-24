package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelSur extends JPanel{

    private JTextField jugadas1;
    private JTextField jugador1;

    public PanelSur(){
        setLayout(new GridLayout(1,6));

        JLabel label = new JLabel("Jugador");
        JLabel label2 = new JLabel("Jugadas");
        JLabel label3 = new JLabel("");

        jugadas1 = new JTextField();
        jugadas1.setEditable(false);
        jugador1 = new JTextField();
        jugador1.setEditable(false);
        add(label);
        add(jugador1);
        add(label2);
        add(jugadas1);
        add(label3);
    }





    public void setJugador(String jugador){

        jugador1.setText(jugador);

    }
    public void setJugadas(int jugadas){
        jugadas1.setText("" + jugadas);

    }
}
