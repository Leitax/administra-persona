package cl.desafio.restdesafioadministrapersona.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
    private static Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static boolean detectarVuln(String valor) {
        int contador = 0;
        for (int index = 0; index < valor.length(); index++) {
            if ((valor.charAt(index) >= 0 && valor.charAt(index) <= 47)
                    || (valor.charAt(index) >= 58 && valor.charAt(index) <= 64)
                    || (valor.charAt(index) >= 91 && valor.charAt(index) <= 96)
                    || (valor.charAt(index) >= 123 && valor.charAt(index) <= 126)
            ) {
                contador++;
            }
        }

        if (contador > 0) {
            LOGGER.info("Vulnerabilidad encontrada en la variable nombre");
            return true;
        }
        LOGGER.info("Variable nombre sin vulnerabilidades");
        return false;

    }
}
