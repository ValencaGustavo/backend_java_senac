package controller;

import model.DespertadorModel;
import view.DespertadorView;

public class DespertadorController {
    // aqui na controller vocês terão que colocar o switch/case

    public static String[] verOpcoes() {
        return DespertadorModel.buscarOpcoes();
    }

    public static String userToResponse(int userResponse) {
        String resposta;
    
        switch (userResponse) {
            case 1:
            
                resposta = "Despertador adiado por 10 segundos";
                break;
            case 2:
                resposta = "Despertador parado";
                break;
            default:
                resposta = "Opção inexistente";
                break;
        }
        return resposta;
    }
    
}