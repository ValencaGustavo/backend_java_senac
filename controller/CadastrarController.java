package controller;
import model.*;
import view.*;

// import java.awt.*;
import javax.swing.*;

public class CadastrarController extends JFrame {
    public static void cadastrar() {
        try {
            boolean achouUsuario = LoginModel.loginUsuario(NovoCadastroView.txtLogin.getText(), String.valueOf(NovoCadastroView.txtSenha.getPassword()).trim());
            if (achouUsuario == true) {
                MenuFrameView appMenuFrame = new MenuFrameView();
                appMenuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                NovoCadastroView.appLoginFrame.dispose();
            } else {
                NovoCadastroView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Não foi encontrado o login e/ou senha digitados! Por favor, verifique e tente novamente."));
            }
        } catch (Exception e) {
            System.err.println(e);
            NovoCadastroView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Ops! Houve um problema com o banco de dados. Por favor, tente novamente mais tarde, obrigado."));
        }        
    }
}