import java.util.*;

public class CardapioDigital {
    public static void main(String[] args) {    

        System.out.println("Bem vindo ao Cardápio Digital!");
        System.out.println("[1] >> Cardápio de Strogonoffs");
        System.out.println("[2] >> Cardápio de Hamburguers");
        System.out.println("[3] >> Cardápio de Pizzas");

        Scanner scanner = new Scanner(System.in);
        int opcoes = scanner.nextInt();
        double saldo = 47.99d;

            switch (opcoes) {
                case 1: {
                    System.out.println("Nossos Strogonoffs:");
                    System.out.println("========================");
                    System.out.println("[1] >> Strogonoff de frango com shimeji = R$25.00");
                    System.out.println("[2] >> Strogonoff de frango = R$21.99");
                    System.out.println("[3] >> Strogonoff de carne com shimeji = R$28.59");
                    System.out.println("[4] >> Strogonoff de carne = R$23.89");
                    System.out.println("========================"); 
                    System.out.println("Escolha um Strogonoff:");
                    int cardapio1 = scanner.nextInt();

                    switch (cardapio1) {
                        case 1:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento = scanner.nextInt();
                            double preçoLanche = 25.99;
                            double saldoRestante = saldo - preçoLanche;
                            switch (pagamento) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                            break;
                        case 2:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento2 = scanner.nextInt();
                        double preçoLanche2 = 21.99;
                        double saldoRestante2 = saldo - preçoLanche2;
                        switch (pagamento2) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante2);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                            break;
                            case 3:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento3 = scanner.nextInt();
                            double preçoLanche3 = 28.59;
                            double saldoRestante3 = saldo - preçoLanche3;
                            switch (pagamento3) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante3);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                    
                        default:
                            break;
                        case 4:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento4 = scanner.nextInt();
                        double preçoLanche4 = 23.89;
                        double saldoRestante4 = saldo - preçoLanche4;
                        switch (pagamento4) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante4);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                    }
                    break;
            }   
                case 2: {
                    System.out.println("Nossos Hamburgueres:");
                    System.out.println("========================");
                    System.out.println("[1] >> Hambúrguer Clássico = R$21.99");
                    System.out.println("[2] >> Cheeseburguer = R$23.89");
                    System.out.println("[3] >> Hambúrguer BBQ = R$25.00");
                    System.out.println("[4] >> Hambúrguer Vegetariano = R$28.59");
                    System.out.println("========================"); 
                    System.out.println("Escolha um Hamburgueres:");
                    int cardapio1 = scanner.nextInt();

                    switch (cardapio1) {
                        case 1:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento = scanner.nextInt();
                            double preçoLanche = 25.99;
                            double saldoRestante = saldo - preçoLanche;
                            switch (pagamento) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                            break;
                        case 2:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento2 = scanner.nextInt();
                        double preçoLanche2 = 21.99;
                        double saldoRestante2 = saldo - preçoLanche2;
                        switch (pagamento2) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante2);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                            break;
                            case 3:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento3 = scanner.nextInt();
                            double preçoLanche3 = 28.59;
                            double saldoRestante3 = saldo - preçoLanche3;
                            switch (pagamento3) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante3);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                    
                        default:
                            break;
                        case 4:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento4 = scanner.nextInt();
                        double preçoLanche4 = 23.89;
                        double saldoRestante4 = saldo - preçoLanche4;
                        switch (pagamento4) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante4);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                    }
                    break;
            }   
                case 3: {
                    System.out.println("Nossas Pizzas:");
                    System.out.println("========================");
                    System.out.println("[2] >> Margherita = R$21.99");
                    System.out.println("[4] >> Pepperoni = R$23.89");
                    System.out.println("[1] >> Quatro Queijos = R$25.00");
                    System.out.println("[3] >> Frango com Bacon = R$28.59");
                    System.out.println("========================"); 
                    System.out.println("Escolha um Strogonoff:");
                    int cardapio1 = scanner.nextInt();

                    switch (cardapio1) {
                        case 1:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento = scanner.nextInt();
                            double preçoLanche = 25.99;
                            double saldoRestante = saldo - preçoLanche;
                            switch (pagamento) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                            break;
                        case 2:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento2 = scanner.nextInt();
                        double preçoLanche2 = 21.99;
                        double saldoRestante2 = saldo - preçoLanche2;
                        switch (pagamento2) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante2);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                            break;
                            case 3:
                            System.out.println("Deseja confirmar o pagamento?");
                            System.out.println("[1] >> Sim");
                            System.out.println("[2] >> Não");
                            int pagamento3 = scanner.nextInt();
                            double preçoLanche3 = 28.59;
                            double saldoRestante3 = saldo - preçoLanche3;
                            switch (pagamento3) {
                                case 1:
                                    System.out.println("Obrigado por confirmar seu pagamento.");
                                    System.out.println("Seu saldo restante é: " + "R$" + saldoRestante3);
                                    break;
                                case 2:
                                System.out.println("Você cancelou o pedido!");
                                break;
                            
                                default:
                                    break;
                            }
                    
                        default:
                            break;
                        case 4:
                        System.out.println("Deseja confirmar o pagamento?");
                        System.out.println("[1] >> Sim");
                        System.out.println("[2] >> Não");
                        int pagamento4 = scanner.nextInt();
                        double preçoLanche4 = 23.89;
                        double saldoRestante4 = saldo - preçoLanche4;
                        switch (pagamento4) {
                            case 1:
                                System.out.println("Obrigado por confirmar seu pagamento.");
                                System.out.println("Seu saldo restante é: " + "R$" + saldoRestante4);
                                break;
                            case 2:
                            System.out.println("Você cancelou o pedido!");
                            break;
                        
                            default:
                                break;
                        }
                    }
                    break;
            }    
                default:
                System.out.println("Você deve selecionar alguma opção disponibilizada no menu.");
                break;
            } 
    }
}

