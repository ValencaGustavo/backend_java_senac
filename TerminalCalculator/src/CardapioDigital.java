import java.util.*;

public class CardapioDigital {
    public static void main(String[] args) {    

        System.out.println("Bem vindo ao Cardápio Digital!");
        System.out.println("[1] >> Strogonoff");
        System.out.println("[2] >> Hamburguer");
        System.out.println("[3] >> Pizza");

        Scanner scanner = new Scanner(System.in);
        String erro = "";
        int opcoes = scanner.nextInt();

            switch (opcoes) {
                case 1: {
                    System.out.println("Você selecionou a opção: 1");
                    break;
            }   
                case 2: {
                    System.out.println("Você selecionou a opção: 2");
                    break;
                }
                case 3: {
                    System.out.println("Você selecionou a opção: 3");
                    break;
                }
                default:
                break;
            } 

            switch (erro) {
                case "":
                System.out.println("Você deve selecionar alguma opção disponibilizada no menu.");
                    break;
            
                default:
                    break;
            }
    }
}

