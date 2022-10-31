package dam.af.ej4.javabean;

import dam.af.ej3.aleaSeq.javabean.PCGaming;

import java.io.Serializable;
import java.util.ArrayList;

public class PCSGaming implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<PCGaming> pcs;

    public PCSGaming() {
        this.pcs = new ArrayList<>();
    }

    public ArrayList<PCGaming> getPCSGaming() {
        return pcs;
    }

    public void addPCGaming(PCGaming pc) {
        pcs.add(pc);
    }
}
