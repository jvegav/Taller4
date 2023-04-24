package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener{



    private JButton nuevo,reiniciar,topmejores,jugadordiferente;

    private Interfaz padre;

    public PanelBotones(Interfaz ventana){

        padre = ventana;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        nuevo = new JButton("          Nuevo Juego             ");
        nuevo.addActionListener(this);


        add(Box.createVerticalGlue());
        add(nuevo);
        add(Box.createRigidArea(new Dimension(0, 10))); 
        
        
        reiniciar = new JButton("         Reiniciar          ");


        reiniciar.addActionListener(this);
        add(reiniciar);
        add(Box.createRigidArea(new Dimension(0, 10))); 
       
        topmejores = new JButton("         Top-10           ");

        topmejores.addActionListener(this);
         
        add(topmejores);
        add(Box.createRigidArea(new Dimension(0, 10))); 

        
        
        jugadordiferente = new JButton("   Cambiar Jugador   ");

        jugadordiferente.addActionListener(this);
        
        add(jugadordiferente);
        
        

        setAlignmentY(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
    }

    @Override
    public void actionPerformed(ActionEvent e){


        if(e.getSource().equals(nuevo)){
            padre.nuevoJuego();
        }

        if(e.getSource().equals(reiniciar)){
            padre.reiniciarJuego();
        }
        if(e.getSource().equals(topmejores)){
            
        }
        if(e.getSource().equals(jugadordiferente)){
            padre.nuevoJuego();;
        }

        if(e.getSource().equals(topmejores)){
            padre.mostrarTop();;
        }


        
    };


    
}
