package ch.hsr.pl;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ch.hsr.bll.CDAR_SelfInformation;

public class CDAR_OutputHelper {
    private List<CDAR_SelfInformation> informationList;

    public CDAR_OutputHelper() {
        this.informationList = new ArrayList<CDAR_SelfInformation>();
    }


    /**
     * @return html formatted title string
     */
    protected String getTitle(String name) {
        return "<h1>" + name + "</h1>";
    }

    /**
     * @param entry <String,String>
     * @return html formatted li string
     */
    protected String getLi(Entry<String, String> entry) {
        return "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>";
    }


    /***
     *
     * @param doc
     *            XML document
     * @param rootElement
     *            xml root Element
     * @param name
     *            xml element name
     * @param value
     *            xml element value
     * @param group
     *            xml group name
     */
    protected void addElement(Document doc, Element rootElement, String name,
                              String value, String group) {
        Element variableElement = doc.createElement(group);
        rootElement.appendChild(variableElement);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        variableElement.appendChild(nameElement);

        Element valueElement = doc.createElement("value");
        valueElement.appendChild(doc.createTextNode(value));
        variableElement.appendChild(valueElement);
    }

    /**
     * @return xml formatted string
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public String getXML() throws ParserConfigurationException,
            TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("SelfInformation");
        doc.appendChild(rootElement);

        for (CDAR_SelfInformation information : this.informationList) {
            for (Entry<String, String> entry : information.getInformation()
                    .entrySet()) {
                String name = entry.getKey();
                String value = entry.getValue();
                addElement(doc, rootElement, name, value,
                        information.toString());
            }
        }

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        return writer.toString();
    }

    /**
     * @return html formatted listing
     */
    public String getHTML() {
        StringBuilder sb = new StringBuilder();
        for (CDAR_SelfInformation information : this.informationList) {
            sb.append(getTitle(information.toString()));
            sb.append("<ul>");
            for (Entry<String, String> entry : information.getInformation().entrySet()) {
                sb.append(this.getLi(entry));
            }
            sb.append("</ul>");
        }
        return sb.toString();
    }

    public void addInformation(CDAR_SelfInformation information) {
        this.informationList.add(information);
    }

}
