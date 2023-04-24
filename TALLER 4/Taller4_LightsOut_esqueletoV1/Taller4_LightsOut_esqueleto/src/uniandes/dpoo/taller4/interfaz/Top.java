package uniandes.dpoo.taller4.interfaz;

import java.awt.*;



import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Top extends JFrame{


    private DefaultListModel<JPanel> modelo =  new DefaultListModel<>();


    public Top(Interfaz v){

        
        setLayout(new GridLayout(1,1));

        setTitle("!!!!!!TOP10!!!!!!");

        setSize(300, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        


        

		JList<JPanel> lista = new JList<JPanel>(modelo);
        lista.setCellRenderer(new PanelListCellRenderer());

        JPanel panel1= new JPanel();
        JLabel label = new JLabel("# NUMERO ");
        panel1.add(label);
        modelo.addElement(panel1);


		JScrollPane scroll = new JScrollPane(lista);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);

        
    }


    public void agregar(String nombre, String puntaje){
        JPanel panel = new JPanel();

        panel.setBackground(Color.BLUE);
        panel.setVisible(true);
        panel.setOpaque(true);
        
        JLabel labelpuntaje = new JLabel("" + puntaje);
        JLabel labeljugador = new JLabel(nombre);
        panel.add(labeljugador);
        panel.add(labelpuntaje);
        modelo.addElement(panel);

            
            
        }


    // Clase del renderizador de celdas personalizado
    private static class PanelListCellRenderer implements ListCellRenderer<JPanel> {
        private final Color selectedColor = new Color(224, 224, 224);
        private final Color unselectedColor = Color.WHITE;

        // Método para renderizar cada celda de la lista
        @Override
        public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JPanel panel = value;

            // Establecer un borde vacío al panel
            panel.setBorder(new EmptyBorder(5, 5, 5, 5));

            // Establecer el color de fondo del panel según si está seleccionado o no
            panel.setBackground(isSelected ? selectedColor : unselectedColor);

            return panel;
        }
    }


    
    
}
