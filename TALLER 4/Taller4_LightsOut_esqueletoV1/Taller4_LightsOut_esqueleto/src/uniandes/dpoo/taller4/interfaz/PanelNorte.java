package uniandes.dpoo.taller4.interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelNorte extends JPanel implements ActionListener{

    private JComboBox<String> combo =  new JComboBox<String>();


    private JRadioButton radio1,radio2,radio3;
    ButtonGroup bg = new ButtonGroup();
    private Interfaz padre;
    private int tamano = 0;
    private int dificultad=20;
    

    public PanelNorte(Interfaz n){

        padre = n;
        setLayout(new FlowLayout());

        JLabel label5 = new JLabel("Tamano");
        JLabel label6 = new JLabel("Dificultad");
        
        combo.setPreferredSize(new Dimension(140, 20));
        

       

        radio1 = new JRadioButton("Facil");
        radio2 = new JRadioButton("Intermedio");
        radio3 = new JRadioButton("Complicadisimo mi bro");


        ButtonGroup bg = new ButtonGroup();
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        

        

        combo.addItem("5x5");
        combo.addItem("4x4");
        combo.addItem("3x3");
        combo.addActionListener(this);
        add(label5);
        add(combo);
        add(label6);
        add(radio1);
        add(radio2);
        add(radio3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getSource().equals(combo)){
            String seleccionado=(String)combo.getSelectedItem();

           if( seleccionado.equals("5x5")){
                tamano = 5;
                padre.setTamano(tamano);
           }
           if( seleccionado.equals("4x4")){
            tamano = 4;
            padre.setTamano(tamano);
            }
            if( seleccionado.equals("3x3")){
                tamano = 3;
                padre.setTamano(tamano);
                }

        }
        if(e.getSource().equals(radio1)){dificultad=21;}
        if(e.getSource().equals(radio2)){dificultad=22;}
        if(e.getSource().equals(radio3)){dificultad=23;}

    


        
        
    }
    public int getDificultad(){
        return dificultad;
    }
    
}