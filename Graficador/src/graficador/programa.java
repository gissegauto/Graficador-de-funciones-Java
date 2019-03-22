package graficador;

/**
 * @author ema
 * @author Editado por Cristel Gauto y José Almada
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class programa extends JFrame {

    public static JButton grafbutton = new JButton("Graficar");
    public static JButton evalbutton = new JButton("Evaluar");
    public static graficador panel3 = new graficador();
    public static JTextField ecufield = new JTextField(), A_field = new JTextField(), B_field = new JTextField();
    public static JMenuBar barra_menu;
    public JMenuItem menu_item;
    ActListener actlistener = new ActListener();
    Wheellistener wlistener = new Wheellistener();
    Metodos metod = new Metodos(this, panel3);
    DefaultListModel model_raiz = new DefaultListModel();
    JList list_raiz = new JList(model_raiz);
    DefaultListModel model_ec = new DefaultListModel();
    JList list_ec = new JList(model_ec);
    public static JComboBox combometodo;

    public static void main(String[] args) {
        programa prog = new programa();
    }

    public programa() {
        JPanel panel5 = propiedades();
        componentes();
        contenedores(panel5);
    }

    private JPanel propiedades() throws NumberFormatException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        JPanel panel2 = new JPanel();
        JPanel panel5 = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.decode("#BEBEBE"));
        Border borde_ec = BorderFactory.createTitledBorder(border, " Ingrese Ecuacion: ", 0, 0, Font.decode("BOLD"));
        panel2.setBackground(Color.decode("#DCDCDC"));
        panel2.setBorder(border);
        panel3.setBorder(border);
        panel3.addMouseWheelListener(wlistener);
        panel5.setBackground(Color.decode("#DCDCDC"));
        panel5.setBorder(borde_ec);
        return panel5;
    }

    private void componentes() {

        list_raiz.setVisible(true);
        list_ec.setVisible(true);
        JScrollPane bardesp_raiz = new JScrollPane(list_raiz), bardesp_ec = new JScrollPane(list_ec);
        bardesp_raiz.setPreferredSize(new Dimension(150, 150));
        bardesp_ec.setPreferredSize(new Dimension(150, 150));
        ecufield.setPreferredSize(new Dimension(800, 30));
        A_field.setPreferredSize(new Dimension(20, 30));
        B_field.setPreferredSize(new Dimension(20, 30));
        grafbutton.addActionListener(actlistener);
        barra_menu = new JMenuBar();
    }

    private void contenedores(JPanel panel5) {
        Box caja = Box.createVerticalBox(), caja2 = Box.createHorizontalBox();
        panel5.add(ecufield, BorderLayout.WEST);
        panel5.add(grafbutton, BorderLayout.EAST);
        Container contentpane = this.getContentPane();
        contentpane.add(barra_menu, BorderLayout.PAGE_START);
        contentpane.add(panel3, BorderLayout.CENTER);
        contentpane.add(panel5, BorderLayout.PAGE_END);
        this.setVisible(true);
    }

    public static void MensajeError() {
        JOptionPane.showMessageDialog(panel3, "Sintaxis Incorrecta", "Error de Evaluacion", JOptionPane.CLOSED_OPTION);
    }

    public static void actualizargrafica() {
        if (ecufield.getText().length() == 0) {
            panel3.f = false;
        } else {
            panel3.f = true;
        }
        panel3.repaint();
    }

}
