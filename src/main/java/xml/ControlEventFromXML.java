package xml;


import controlevent.AbstractControlEvent;

import controlevent.ControlEventFirstType;
import controlevent.ControlEventSecondType;
import controlevent.ControlEventThirdType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class ControlEventFromXML extends DefaultHandler {


    private List<Boolean> offsetsList;
    private List<Double> examsList;
    private List<AbstractControlEvent> controlEventList;


    ControlEventFromXML() {
        examsList = new ArrayList<>();
        offsetsList = new ArrayList<>();
        controlEventList = new ArrayList<>();

    }

    List<AbstractControlEvent> getControlEventList() {
        return controlEventList;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {


        if (qName.equalsIgnoreCase("exam")) {

            examsList.add(Double.valueOf(attributes.getValue(0)));


        } else if (qName.equalsIgnoreCase("offset")) {
            offsetsList.add(Boolean.valueOf(attributes.getValue(0)));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equalsIgnoreCase("event")) {
            if (offsetsList.size() == 0) {
                controlEventList.add(new ControlEventFirstType(examsList.get(0), examsList.get(1)));
            } else if (offsetsList.size() == 1) {
                controlEventList.add(new ControlEventSecondType(examsList.get(0), examsList.get(1), offsetsList.get(0)));
            } else if (offsetsList.size() == 2) {
                controlEventList.add(new ControlEventThirdType(offsetsList.get(0), offsetsList.get(1), examsList.get(0)));
            }
            clearLists();

        }
    }

    private void clearLists() {
        examsList.clear();
        offsetsList.clear();
    }

}
