package ejemplo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Game extends JFrame implements ActionListener {

    JLabel lbl11, lbl1;
    // JButton hace referencia a los botones
    JButton btn1;
    ImagenFondo ILogin = new ImagenFondo();
    Rectangle moto, item;

    public Game() {

        // Establece el panel de contenido como la imagen de fondo
        this.setContentPane(ILogin);
        btn1 = new JButton("Give me Gas");
        btn1.setBounds(650, 580, 130, 30);
        btn1.setFont(new Font("Agency FB", Font.BOLD, 20));
        btn1.setVisible(true);
        btn1.addActionListener(this);
        this.add(btn1);
        ///////////////////// DOG ////////////////////////////
        //LBL11
        lbl11 = new JLabel();
        lbl11.setBounds(40, 400, 150, 150);
        ImageIcon img = new ImageIcon(getClass().getResource("../imgs/moto.gif"));
        Image nuevo = img.getImage().getScaledInstance(lbl11.getWidth(), lbl11.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon render = new ImageIcon(nuevo);
        lbl11.setIcon(render);
        lbl11.setVisible(true);
        this.add(lbl11);
        moto = lbl11.getBounds();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Asignar el borde al JLabel
        lbl11.setBorder(border);
        //MAIN WINDOW	
        this.setTitle("Looking for gas");
        this.setLayout(null);
        this.setSize(800, 650);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            Gas gas = new Gas(this);
            gas.start();
            item = lbl1.getBounds();
        }
    }

    class ImagenFondo extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("../imgs/fondo.gif")).getImage();

            // Dibuja la imagen en el panel en las coordenadas (0, 0) con el ancho y altura del panel
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            // Establece el panel como transparente para que la imagen de fondo sea visible
            setOpaque(false);
            // Llama al método paint de la clase padre para completar el proceso de pintado
            super.paint(g);
        }

    }
}
