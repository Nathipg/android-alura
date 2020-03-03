package pissuti.nathalia.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LINGUAGEM = "pt";
    public static final String PAIS = "br";

    public static String formataParaBr(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(LINGUAGEM, PAIS));
        return formatoBrasileiro.format(valor);
    }

}
