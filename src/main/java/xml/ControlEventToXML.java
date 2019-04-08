package xml;

import controlevent.AbstractAbstractControlEventWithOfsets;
import controlevent.AbstractControlEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class ControlEventToXML {
    private Document doc;


    Document getXML(List<AbstractControlEvent> controlEventList) throws ParserConfigurationException {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder = icFactory.newDocumentBuilder();
        doc = icBuilder.newDocument();
        Element mainRootElement = doc.createElement("controlEvents");
        doc.appendChild(mainRootElement);

        for (AbstractControlEvent controlEvent : controlEventList) {
            mainRootElement.appendChild(getNode(controlEvent));
        }

        return doc;

    }


    private Node getNode(AbstractControlEvent controlEvent) {

        Element event = doc.createElement("event");

        setExamElement(controlEvent, event);

        if (controlEvent instanceof AbstractAbstractControlEventWithOfsets) {
            setOfsetElements(controlEvent, event);

        }

        return event;
    }

    private void setExamElement(AbstractControlEvent controlEvent, Element event) {
        Element exams = doc.createElement("exams");
        event.appendChild(exams);
        for (int i = 0; i < controlEvent.getExams().length; i++) {

            Element exam = doc.createElement("exam");
            exam.setAttribute("exam" + getName(i), String.valueOf(controlEvent.getExams()[i]));
            exams.appendChild(exam);
        }

    }


    private void setOfsetElements(AbstractControlEvent controlEvent, Element event) {
        Element ofsets = doc.createElement("ofsets");
        event.appendChild(ofsets);
        for (int i = 0; i < ((AbstractAbstractControlEventWithOfsets) controlEvent).getOfsets().length; i++) {
            Element ofset = doc.createElement("ofset");
            ofset.setAttribute("ofset" + getName(i), String.valueOf(((AbstractAbstractControlEventWithOfsets) controlEvent).getOfsets()[i]));
            ofsets.appendChild(ofset);
        }

    }

    private String getName(int number) {
          return String.valueOf(number += 1);
    }
}
