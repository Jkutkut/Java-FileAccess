package jkutkut.dom.write;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class WriteXML {
    public static void generateXML(String filename, NodeXML rootNode) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, rootNode.nodeName(),null);

            fillNode(document, document.getDocumentElement(), rootNode);

            document.setXmlVersion("1.0");
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(filename));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.transform(source,  result);

        } catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void fillNode(Document doc, Element parent, NodeXML node) {
        for (Object ele : node.nodeValues()) {
            if (ele instanceof NodeXML) {
                Element child = doc.createElement(((NodeXML) ele).nodeName());
                fillNode(doc, child, (NodeXML) ele);
                parent.appendChild(child);
            } else {
                Text text = doc.createTextNode(ele.toString());
                parent.appendChild(text);
            }
        }
    }
}
