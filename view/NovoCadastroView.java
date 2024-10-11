    package view;
    import java.awt.*;
    import javax.swing.*;
    import java.awt.event.*;
    import java.sql.*;

    import model.*;
    import controller.*;

    public class NovoCadastroView extends JFrame {

        private final JLabel JLabelEmail = new JLabel("Email", SwingConstants.LEFT);
        public final static JTextField JTextFieldEmail = new JTextField();
        private final JLabel JLabelUser = new JLabel("Usuario", SwingConstants.LEFT);
        public final static JTextField JTextFieldUser = new JTextField();
        private final JLabel JLabelPass = new JLabel("Senha", SwingConstants.LEFT);
        public final static JTextField JPasswordFieldPass = new JTextField();
        private final JButton JButtonCadastrar = new JButton("Cadastrar");
        private final JButton JButtonEnterUser = new JButton("Logar >");
        private final JCheckBox JCheckBoxTerms = new JCheckBox("Aceite os Termos");
        public final static JLabel JLabelNotification = new JLabel("Notificações...", SwingConstants.LEFT);
        private final JLabel JLabelImagePath = new JLabel("Caminho da Imagem");
        private final JLabel JLabelImagePreview = new JLabel();
        private final JButton JButtonSelectImage = new JButton("Selecionar Imagem");

        private final JLabel espacador = new JLabel("");
        private final JLabel espacador2 = new JLabel("");
        private final JLabel espacador3 = new JLabel("");
        private final JLabel espacador4 = new JLabel("");
        private final JLabel espacador5 = new JLabel("");
        private final JLabel espacador6 = new JLabel("");
        private final JLabel espacador7 = new JLabel("");
        private final JLabel espacador8 = new JLabel("");
        private final JLabel espacador9 = new JLabel("");
        private final JLabel espacador10 = new JLabel("");

        private final String dbPadrao = "db_teste";
        private final String tblPadrao = "tbl_teste";

        private final JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        public NovoCadastroView() {
            super("Tela de Cadastro");
            setLayout(new GridLayout(7, 3, 5, 5));

            JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
            JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
            JPanel linha3 =  new JPanel(new GridLayout(1, 3, 10, 10));
            JPanel linha4 =  new JPanel(new GridLayout(1, 1, 10, 10));
            JPanel linha5 = new JPanel(new GridLayout(1, 1, 10, 10));
            JPanel linha6 = new JPanel(new GridLayout(1, 1, 10, 10));

            JButtonCadastrar.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {

                        JTextFieldUser.requestFocus();
                        
                        String nome = JTextFieldUser.getText();
                        String email = JTextFieldEmail.getText();
                        String senha = JPasswordFieldPass.getText();
                        String profile_picture = JLabelImagePath.getText();

                        if (JCheckBoxTerms.isSelected()) {
                            try {
                                Connection connection = MySQLConnectorModel.conectar();
                                String strSqlsearchEmail = "select email FROM `" + dbPadrao + "`.`" + tblPadrao + "` where `email` = '" + email + "' order by `id` asc";
                                Statement stmSqlsearchEmail = connection.createStatement();
                                ResultSet rstSearchEmail = stmSqlsearchEmail.executeQuery(strSqlsearchEmail);


                                if (rstSearchEmail.next()) {
                                    JLabelNotification.setText("Email já cadastrado");
                                    System.out.println("Email já cadastrado");
                                } else {
                                    NavegadorDeRegistro.newRegister(dbPadrao, tblPadrao, "nome", "email", "senha", "profile_picture", nome, email, senha, profile_picture);
                                    JLabelNotification.setText("Cadastro realizado com sucesso");
                                }

                                stmSqlsearchEmail.close();
                                connection.close();
                            } catch (Exception e) {
                                JLabelNotification.setText("Digite alguma coisa:");
                            }
                        } else {
                            JLabelNotification.setText("Você deve aceitar os Termos");
                        }
                    }
                });

                JButtonEnterUser.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            setVisible(false);
                            LoginFrameView appLogin = new LoginFrameView();
                            appLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        } 
                    }
                );

                JButtonSelectImage.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        int returnValue = fileChooser.showOpenDialog(null);
                        
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                            JLabelImagePath.setText(imagePath);
                            
                            ImageIcon imageIcon = new ImageIcon(imagePath);
                            Image image = imageIcon.getImage().getScaledInstance(400, 700, Image.SCALE_SMOOTH); // Redimensiona para 300x300
                            JLabelImagePreview.setIcon(new ImageIcon(image));
                            JLabelImagePreview.setPreferredSize(new Dimension(300, 300));
                        }
                    }
                });

            imagePanel.add(JLabelImagePreview);
            add(imagePanel);

            add(linha1);
            linha1.add(JLabelUser);
            linha1.add(JTextFieldUser);

            add(linha2);
            linha2.add(JLabelEmail);
            linha2.add(JTextFieldEmail);

            add(linha3);
            linha3.add(JLabelPass);
            linha3.add(JPasswordFieldPass);
            
            add(linha4);
            linha4.add(JButtonSelectImage);
            linha4.add(espacador);
            linha4.add(JButtonCadastrar);
            
            add(linha5);
            linha5.add(JCheckBoxTerms);

            add(linha6);
            linha6.add(JLabelNotification);

            setSize(550, 600);
            setVisible(true);

            //----------------------------------------------    ----------------------------------------------------------------//

        }

        public static NovoCadastroView appRegisterUSer;

        public static void main(String[] args) {
            appRegisterUSer = new NovoCadastroView();
            appRegisterUSer.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }