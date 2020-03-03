package pissuti.nathalia.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        fim.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String inicioFormatado = formatoBrasileiro.format(inicio.getTime());
        String fimFormatado = formatoBrasileiro.format(fim.getTime());
        return inicioFormatado + " - " + fimFormatado + " de " + fim.get(Calendar.YEAR);
    }

}
