package dam.af.ej3.aleaSeq.javabean;

import java.io.Serializable;

public class PCGaming implements Serializable {
    public static final long serialVersionUID = 1L;

    private final int id;
    private final String modelo;
    private final String marca;
    private final Procesador procesador;
    private final int ram;
    private final int precio;

    public PCGaming(int id, String modelo, String marca, Procesador procesador, int ram, int precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.precio = precio;
    }

    // ********* GETTERS *********

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public int getRam() {
        return ram;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "PCGaming{\n" +
                "\tid = " + id + ",\n" +
                "\tmodelo = '" + modelo + "',\n" +
                "\tmarca = '" + marca + "',\n" +
                "\tprocesador = " + procesador + ",\n" +
                "\tram = " + ram + ",\n" +
                "\tprecio = " + precio + "\n" +
                '}';
    }
}
