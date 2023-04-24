package uniandes.dpoo.taller4.interfaz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTablero extends JPanel implements MouseListener {

    private  int TAMANO_CASILLA; // Tamaño de cada casilla en píxeles 
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private int tamano;
    private boolean[][] matrizBooleanos ;

    Interfaz padre;

    public PanelTablero(Interfaz ventana) {
        padre = ventana;
        this.setPreferredSize(new Dimension(380, 300));
        this.addMouseListener(this);
    }



    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int d  =255;
        // Dibujar las casillas del tablero
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                Boolean colorBoolean = matrizBooleanos[fila][columna];

                if(colorBoolean == true){
                    g2d.setColor(new Color(240, d-(3*fila), 0));
                }
                else{
                    g2d.setColor(Color.BLACK);
                }
                
                g2d.fillRoundRect(columna * TAMANO_CASILLA, fila * TAMANO_CASILLA, TAMANO_CASILLA, TAMANO_CASILLA,20,20);




                g2d.setColor(new Color(100,100,250));
                g2d.drawRoundRect(columna * TAMANO_CASILLA, fila * TAMANO_CASILLA, TAMANO_CASILLA, TAMANO_CASILLA,20,20);
                repaint();
            }
        }

        // Dibujar el borde de la casilla seleccionada (si hay una)
        if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
            g.setColor(Color.RED);
            g.drawRoundRect(columnaSeleccionada * TAMANO_CASILLA, filaSeleccionada * TAMANO_CASILLA, TAMANO_CASILLA, TAMANO_CASILLA,20,20);
        }
    }



    public void cambiarTamano(boolean[][] tableroBooleanos, int numero){
        tamano = numero;
        if(numero ==5){
            TAMANO_CASILLA = 70;
        }
        else if(numero ==4){
            TAMANO_CASILLA = 90;
        }
        else if(numero ==3){
            TAMANO_CASILLA = 120;
        }
        matrizBooleanos = new boolean[numero][numero];
        matrizBooleanos = tableroBooleanos;
       
        repaint();

    }
    public void cambiarDificultad(boolean[][] tableroBooleanos){
        matrizBooleanos = tableroBooleanos;
        repaint();
    }





    public void reiniciarTablero(boolean[][] tableroNuevo){
        matrizBooleanos = tableroNuevo;
        filaSeleccionada = -1;
        columnaSeleccionada =-1;
        repaint();
    }



    



    @Override
    public void mousePressed(MouseEvent e) {
        int fila = e.getY() / TAMANO_CASILLA;
        int columna = e.getX() / TAMANO_CASILLA;
        if (fila >= 0 && fila < tamano && columna >= 0 && columna < tamano) {
            filaSeleccionada = fila;
            columnaSeleccionada = columna;
            repaint();
        }

        matrizBooleanos = padre.jugar(filaSeleccionada, columnaSeleccionada);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    
}
