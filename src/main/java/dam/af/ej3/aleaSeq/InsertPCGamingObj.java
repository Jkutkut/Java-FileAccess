package dam.af.ej3.aleaSeq;

import dam.af.ej3.aleaSeq.javabean.PCGaming;
import dam.af.ej3.aleaSeq.javabean.Procesador;

import java.io.*;

public class InsertPCGamingObj {
    public static final String FILENAME = "res/aleaSeq/pcgamingObj.dat";

    public static void main(String[] args) {
        PCGaming[] data = loadData();

        System.out.println("Saving PCGaming in " + FILENAME);
        ObjectOutputStream oss;
        try {
            oss = new ObjectOutputStream(new FileOutputStream(FILENAME));
            for (PCGaming pcgaming : data) {
                oss.writeObject(pcgaming);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reading file:");
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILENAME));
            PCGaming pcgaming;
            while (true) {
                pcgaming = (PCGaming) ois.readObject();
                System.out.println(pcgaming);
            }
        } catch (FileNotFoundException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            // EOF
        }
    }

    private static PCGaming[] loadData() {
        return new PCGaming[]{
            new PCGaming(
                0,
                "Lenovo XV3",
                "Lenovo",
                new Procesador(
                    "Intel Core i7-7700K",
                    4.2
                ),
                16,
                1000
            ),
            new PCGaming(
                1,
                "Lenovo XV4",
                "Lenovo",
                new Procesador(
                    "Intel Core i7-5700K",
                    4.4
                ),
                16,
                3000
            ),
            new PCGaming(
                2,
                "Lenovo XV5",
                "Lenovo",
                new Procesador(
                    "Intel Core i7-77600K",
                    4.3
                ),
                32,
                1200
            ),
        };
    }
}
