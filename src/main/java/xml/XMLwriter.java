package xml;

import controlevent.AbstractControlEvent;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLwriter {
    public void write(String filePath, List<AbstractControlEvent> controlEventList) {
        ControlEventToXML controlEventToXML = new ControlEventToXML();
        try {


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(controlEventToXML.getXML(controlEventList));
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
