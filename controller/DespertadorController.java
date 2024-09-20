package controller;
import model.*;
import view.*;
import java.util.*;

public class DespertadorController extends DespertadorView {

    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static void acaoDespertador(int opcaoUsuario) {
        if (adiamentoAtual < 3) {
            switch (opcaoUsuario) {
                case 1:
                    if (mostrarOpcoesAdiamentos()) {
                        if ((minutoAtual + adiar) > 59) {
                            horaDespertar++;
                            if (horaDespertar > 23) {
                                horaDespertar = 0;
                            }
                            minutoDespertar = (minutoAtual + adiar) - 59;
                        } else {
                            minutoDespertar = minutoAtual + adiar;
                        }
                        adiamentoAtual++; 
                        exibirAlarmeAdiado(adiar);
                    } else {
                        break;
                    }
                    break;

                case 2:
                    sairDoSistema();
                    break;

                default:
                    mostrarOpcaoInvalida();
                    break;
            }
        } else {
            sairDoSistema();
        }
    }

    public static void getHMS() {
        date = new Date();
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        minutoAtual = calendar.get(Calendar.MINUTE);
        segundoAtual = calendar.get(Calendar.SECOND);
    }

    public static String tempoRestante() {
        GregorianCalendar tempoAtual = new GregorianCalendar();
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.set(Calendar.HOUR_OF_DAY, horaDespertar);
        calendar.set(Calendar.MINUTE, minutoDespertar);
        calendar.set(Calendar.SECOND, 0);

        long diferencaMillis = calendar.getTimeInMillis() - tempoAtual.getTimeInMillis();
    
        long horas = diferencaMillis / (60 * 60 * 1000);
        long minutos = (diferencaMillis / (60 * 1000)) % 60;
        long segundos = (diferencaMillis / 1000) % 60;
        
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
