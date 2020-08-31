import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

public class Algoritmo {
    private static Logger logger = Logger.getLogger(Algoritmo.class.getName());

    public static void main(String[] args) {
        int[] casas = new int[8];
        int dias = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese el numero de dias");
            String d = reader.readLine();
            dias = Integer.parseInt(d);
            System.out.println("Ingrese el estado inicial de las casas");
            String c = reader.readLine();
            if (c.length()==8)
                for (int i = 0; i < c.length(); i++)
                    casas[i] = Integer.parseInt(String.valueOf(c.charAt(i)));
            else
                throw new Exception();
            if (!validarParametros(casas,dias))
                throw new Exception();
        } catch (Exception e) {
            logger.severe("Error en los parametros de entrada");
            System.exit(1);
        }

        int[] casasNextDay = iterateDays(casas,dias);
        logger.info("Despues de " + dias + " dias el resultado es:");
        logger.info(Arrays.toString(casasNextDay));
    }

    private static boolean validarParametros(int[] casas, int dias) {
        for (int casa: casas)
            if (!(casa==0 || casa==1))
                return false;
        return casas.length == 8 && dias > 0;
    }


    private static int[] iterateDays(int[] casas, int dias) {
        for (int i = 0; i < dias; i++) {
            int[] casasNextDay = new int[8];
            int valorAnterior, valorSiguiente;
            for (int j = 0; j < casas.length; j++) {
                switch (j) {
                    case 0:
                        valorAnterior = 0;
                        valorSiguiente = casas[j + 1];
                        break;
                    case 7:
                        valorAnterior = casas[j - 1];
                        valorSiguiente = 0;
                        break;
                    default:
                        valorAnterior = casas[j - 1];
                        valorSiguiente = casas[j + 1];
                        break;
                }
                if (valorAnterior == valorSiguiente)
                    casasNextDay[j] = 0;
                else
                    casasNextDay[j] = 1;
            }
            casas = casasNextDay;
        }
        return casas;
    }
}
