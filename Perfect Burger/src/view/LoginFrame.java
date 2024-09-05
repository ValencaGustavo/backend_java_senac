package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;

public class LoginFrame extends JFrame {

    public final static JTextField usuarioJTextField = new JTextField("");
    public final static JPasswordField senhaJPasswordField = new JPasswordField(""); 

    private final JButton logarJButton = new JButton("Login");
    private final JButton cadastrarJButton = new JButton("Cadastrar-se >");

    private final JLabel usuarioJLabel = new JLabel("Digite seu nome de usuário", SwingConstants.CENTER);
    private final JLabel senhaJLabel = new JLabel("Digite sua senha", SwingConstants.CENTER);
    public final static JLabel notificacaoJLabel = new JLabel("Notificações");

    public final static String dbPadrao = "db_perfect_burger";
    public final static String tblPadrao = "tbl_perfect_burger";

    public LoginFrame() {
        super("Tela de Login");
        setLayout(new GridLayout(9, 3, 5, 5));

        JPanel linha1 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha2 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha3 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha5 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha6 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha7 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha8 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha9 = new JPanel(new GridLayout(1, 3, 5, 5));

        add(linha1);
        linha2.add(usuarioJLabel);
        add(linha2);
        linha3.add(usuarioJTextField);
        add(linha3);
        add(linha4);
        linha5.add(senhaJLabel);
        add(linha5);
        linha6.add(senhaJPasswordField);
        add(linha6);
        add(linha7);
        linha8.add(logarJButton);
        linha8.add(cadastrarJButton);
        add(linha8);
        linha9.add(notificacaoJLabel);
        add(linha9);

        setSize(400, 600);
        setVisible(true);

        logarJButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    Logar.logar();
                }
            }
        );

        cadastrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cadastrar cadastrar = new Cadastrar();
                cadastrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastrar.setVisible(true);
            }
        });
    }

    
    public static LoginFrame application ;

    public static void main(String[] args) {
        LoginFrame application = new LoginFrame();
        application.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
