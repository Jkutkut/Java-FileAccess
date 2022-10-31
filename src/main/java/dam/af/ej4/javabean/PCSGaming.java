package dam.af.ej4.javabean;

import dam.af.ej3.aleaSeq.javabean.PCGaming;
import jkutkut.dom.write.NodeXML;

import java.io.Serializable;
import java.util.ArrayList;

public class PCSGaming implements Serializable, NodeXML {
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


    // WriteXML interface

    @Override
    public String nodeName() {
        return "pcs_gaming";
    }

    @Override
    public Object[] nodeValues() {
        Object[] values = new Object[pcs.size()];
        for (int i = 0; i < pcs.size(); i++)
            values[i] = pcs.get(i);
        return values;
    }
}
