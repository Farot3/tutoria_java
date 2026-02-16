package com.mycompany.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblUsuario, lblPassword;
    
    public Login() {
        // Configuración de la ventana
        setTitle("inicio de sesión");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));
        
        // Label Usuario
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 30, 80, 25);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblUsuario);
        
        // Campo de texto Usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 30, 150, 25);
        panel.add(txtUsuario);
        
        // Label Password
        lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 70, 90, 25);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblPassword);
        
        // Campo de texto Password
        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 70, 150, 25);
        panel.add(txtPassword);
        
        // Botón Login
        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(120, 110, 100, 30);
        btnLogin.setBackground(new Color(70, 130, 180));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogin.setFocusPainted(false);
        panel.add(btnLogin);
        
        // Acción del botón
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());
                
                // Validación simple (puedes cambiar estos valores)
                if (usuario.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, 
                        "¡Bienvenido " + usuario + "!", 
                        "Login Exitoso", 
                        JOptionPane.INFORMATION_MESSAGE);
                    // Aquí puedes abrir otra ventana o realizar otra acción
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Usuario o contraseña incorrectos", 
                        "Error de Login", 
                        JOptionPane.ERROR_MESSAGE);
                    txtPassword.setText("");
                }
            }
        });
        
        // Permitir login con Enter
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }
        });
        
        add(panel);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}
