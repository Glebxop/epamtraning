package xml;

import controlevent.AbstractAbstractControlEventWithOffsets;
import controlevent.AbstractControlEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

class ControlEventToXML {
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

        if (controlEvent instanceof AbstractAbstractControlEventWithOffsets) {
            setOffsetElements(controlEvent, event);

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


    private void setOffsetElements(AbstractControlEvent controlEvent, Element event) {
        Element offsets = doc.createElement("offsets");
        event.appendChild(offsets);
        for (int i = 0; i < ((AbstractAbstractControlEventWithOffsets) controlEvent).getOffsets().length; i++) {
            Element ofset = doc.createElement("offset");
            ofset.setAttribute("offset" + getName(i), String.valueOf(((AbstractAbstractControlEventWithOffsets) controlEvent).getOffsets()[i]));
            offsets.appendChild(ofset);
        }

    }

    private String getName(int number) {
        return String.valueOf(number + 1);
    }
}
