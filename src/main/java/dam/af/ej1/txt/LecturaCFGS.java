package dam.af.ej1.txt;

import java.io.*;

public class LecturaCFGS {
    private static final String FICHERO = "res/txt/cfgs.txt";

    private static final int BUFFER_SIZE = 512;
    private static final String DELIMITER_NODE = "\n";
    private static final String DELIMITER_ELEMENTS = ";";

    private static final String[] FIELDS = {"Titulación: ", "Acrónimo: ", "Familia: ", "Ley Orgánica: ", "Duración: "};

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(FICHERO), "UTF-8");
            System.out.println("Leyendo fichero " + FICHERO);

            StringBuffer sb = new StringBuffer();
            char[] buffer = new char[BUFFER_SIZE];
            int read;
            while (isr.ready()) {
                read = isr.read(buffer);
                sb.append(buffer, 0, read);
            }

            String[] nodes = sb.toString().split(DELIMITER_NODE);
            String[] node;
            System.out.println("\nCFGS:");
            for (String n : nodes) {
                node = n.split(DELIMITER_ELEMENTS);
                System.out.println("**************************************");
                for (int i = 0; i < FIELDS.length; i++) {
                    System.out.printf(
                        "%s%s\n",
                        FIELDS[i],
                        node[i]
                    );
                }
                System.out.println("**************************************\n");
            }
            isr.close();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("El archivo no es válido");
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
