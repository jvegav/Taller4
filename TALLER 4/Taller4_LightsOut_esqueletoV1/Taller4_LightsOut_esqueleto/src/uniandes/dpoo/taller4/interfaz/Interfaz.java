package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.*;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
import java.util.Collection;


class Interfaz extends JFrame  {


    private PanelTablero panelTablero;
    private PanelSur panelSur;
    private PanelNorte panelNorte;

    private Tablero tablero;

    private Top10 topmodelo;



    private String nombreJugador;

    public Interfaz() {

        setLayout(new BorderLayout(5, 5));  

        panelNorte = new PanelNorte(this);
        panelSur = new PanelSur();
        PanelBotones panelDerecha = new PanelBotones(this);
        panelTablero = new PanelTablero(this);
        add(panelNorte,BorderLayout.NORTH);
        add(panelSur,BorderLayout.SOUTH);
        add(panelDerecha,BorderLayout.EAST);
        add(panelTablero,BorderLayout.WEST);
        topmodelo = new Top10();
        setTamano(5);
        JOptionPane.showMessageDialog(null, "Bienvenidooo, ESTO ES LIGHTS OUT ");
        nombreJugador = JOptionPane.showInputDialog("Ingrese porfavor el nombre del nuevo usuario: ");
        panelSur.setJugador(nombreJugador);

        

        
        
        setSize(600,490);    
        setResizable(false);
        setVisible(true);    
    }

    


	public static void main (String [ ] args) {
		Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
	}



    public void setTamano(int n){
        tablero = new Tablero(n);
        panelTablero.cambiarTamano(tablero.darTablero(),n);
    }

    public void nuevoJuego(){
        topmodelo.agregarRegistro(nombreJugador, tablero.darJugadas());

        nombreJugador = JOptionPane.showInputDialog("Ingrese porfavor el nombre del nuevo usuario: ");
        panelSur.setJugador(nombreJugador);
        JOptionPane.showMessageDialog(null, "Excelente, ahora empieze a jugar :)");
        tablero.reiniciar();
        tablero.desordenar(panelNorte.getDificultad());
        panelTablero.reiniciarTablero(tablero.darTablero());
    }

    public void reiniciarJuego(){
        tablero.reiniciar();
        panelTablero.reiniciarTablero(tablero.darTablero());
        JOptionPane.showMessageDialog(null, "Excelente, Se reinicio el tablero y las jugadas \n Inicia cuando quieras:)");

    }

    public boolean[][] jugar(int fila, int columna){
        tablero.jugar(fila, columna);
        panelSur.setJugadas(tablero.darJugadas());
        return tablero.darTablero();

    }


    public void mostrarTop(){
        Top top = new Top(this);
        Collection<RegistroTop10> registros = topmodelo.darRegistros();

        for(RegistroTop10 reg : registros){
           String nombre = reg.darNombre();
            String puntaje = "" +reg.darPuntos();
            top.agregar(nombre, puntaje);
        }

        top.setVisible(true);
        this.setVisible(true);

    }




  

}