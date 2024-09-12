package view;

import java.util.*;
import controller.DespertadorController;

public class DespertadorView {
    public static int adiar = 10; 

    public static void main(String[] args) {

        String CSI = "\u001B[";

        int hourDespertar;
        int minuteDespertar;
        int secondsDespertar;

        Scanner scnDespertador = new Scanner(System.in);

        System.out.print (CSI + "31" + "m");
        System.out.println("Digite as horas que deseja configurar para o despertador tocar!");
        hourDespertar = scnDespertador.nextInt();

        System.out.println("Digite os minutos que deseja configurar para o despertador tocar!");
        minuteDespertar = scnDespertador.nextInt();

        System.out.println("Digite os segundos que deseja configurar para o despertador tocar!");
        secondsDespertar = scnDespertador.nextInt();

        boolean sair = false;
        while (!sair) {
            Calendar calendar = GregorianCalendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);
            int currentSecond = calendar.get(Calendar.SECOND);

            if (currentHour > hourDespertar || 
               (currentHour == hourDespertar && currentMinute > minuteDespertar) ||
               (currentHour == hourDespertar && currentMinute == minuteDespertar && currentSecond >= secondsDespertar)) {
                
                System.out.println("Acorda, seu despertador está chamando.");
                System.out.println("Digite abaixo uma opção numérica:");

                String[] opcoes = DespertadorController.verOpcoes();
                for (int v = 0; v < opcoes.length; v++) {
                    System.out.println(String.format("[%d] >> %s", v + 1, opcoes[v]));
                }

                try {
                    int userResponse = scnDespertador.nextInt();
                    System.out.println(DespertadorController.userToResponse(userResponse));

                    if (userResponse == 1) {
                        secondsDespertar += adiar;

                        while (secondsDespertar >= 60) {
                            secondsDespertar -= 60;
                            minuteDespertar++;
                        }
                        while (minuteDespertar >= 60) {
                            minuteDespertar -= 60;
                            hourDespertar++;
                        }
                    } else if (userResponse == 2) { 
                        sair = true;
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scnDespertador.next(); 
                }
            }

            System.out.println(String.format("Agora são: %d:%d:%d", currentHour, currentMinute, currentSecond));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scnDespertador.close();
    }
}











