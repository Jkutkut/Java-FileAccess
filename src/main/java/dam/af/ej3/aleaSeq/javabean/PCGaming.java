package dam.af.ej3.aleaSeq.javabean;

import jkutkut.dom.write.FieldXML;
import jkutkut.dom.write.NodeXML;

import java.io.Serializable;
import java.util.ArrayList;

public class PCGaming implements Serializable, NodeXML {
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


    // WriteXML interface

    @Override
    public String nodeName() {
        return "pc";
    }

    @Override
    public Object[] nodeValues() {
        return new Object[]{
            new FieldXML("id", id),
            new FieldXML("modelo", modelo),
            new FieldXML("marca", marca),
            procesador,
            new FieldXML("ram", ram),
            new FieldXML("precio", precio)
        };
    }
}
