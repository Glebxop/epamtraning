package xml;

import controlevent.AbstractControlEvent;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLreader {

    public List<AbstractControlEvent> read(String pathName) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File(pathName);
        ControlEventFromXML controlEventFromXML = new ControlEventFromXML();
        parser.parse(file, controlEventFromXML);
        return controlEventFromXML.getControlEventList();
    }
}
