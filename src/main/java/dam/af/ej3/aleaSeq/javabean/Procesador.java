package dam.af.ej3.aleaSeq.javabean;

import java.io.Serializable;

public class Procesador implements Serializable {
    public static final long serialVersionUID = 1L;

    private final String nombre;
    private final double velocidad;

    public Procesador(String nombre, double velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    // *********** GETTERS ***********

    public String getNombre() {
        return nombre;
    }

    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "Procesador{" +
                "nombre='" + nombre + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }
}
