package dam.af.ej4.main;

import com.thoughtworks.xstream.XStream;
import dam.af.ej3.aleaSeq.javabean.PCGaming;
import dam.af.ej4.javabean.PCSGaming;
import jkutkut.dom.ReadXML;
import jkutkut.dom.write.WriteXML;

import java.io.*;

public class InsertPCGamingObj {

    private static final String DATA_FILENAME = dam.af.ej3.aleaSeq.InsertPCGamingObj.FILENAME;
    private static final String XML_FILENAME = "res/xml/PCSGaming.xml";
    private static final String XML_FILENAME_DOM = "res/xml/PCSGaming_dom.xml";

    public static void main(String[] args) {
        PCSGaming data = loadData();

        saveXML(data, XML_FILENAME);

        ReadXML.printDocumentXML(XML_FILENAME);

        WriteXML.generateXML(XML_FILENAME_DOM, data);

        ReadXML.printDocumentXML(XML_FILENAME_DOM);
    }

    private static void saveXML(PCSGaming pcs, String filename) {
        XStream xstream = new XStream();

        xstream.alias("pcs_gaming", PCSGaming.class);
        xstream.alias("pc", PCGaming.class);

        xstream.aliasField("id", PCGaming.class, "idPC");

        xstream.addImplicitCollection(PCSGaming.class, "pcs"); // Collection name

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            xstream.toXML(pcs, fos);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static PCSGaming loadData() {
        PCSGaming data = new PCSGaming();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILENAME));
            while (true) {
                data.addPCGaming((PCGaming) ois.readObject());
            }
        } catch (IOException e) {
            // End of file
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
