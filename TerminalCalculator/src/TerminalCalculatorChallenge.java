import java.util.*;

public class TerminalCalculatorChallenge {
    public static void main(String[] args) {    

        System.out.println("Escolha uma opção:");
        System.out.println("Opção 1: Digite 1");
        System.out.println("Opção 2: Digite 2");
        System.out.println("Opção 3: Digite 3");

        Scanner scanner = new Scanner(System.in);

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
    }
}

