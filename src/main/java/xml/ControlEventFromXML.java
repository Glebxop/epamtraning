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


    private List<Boolean> ofsetsList;
    private List<Double> examsList;
    private List<AbstractControlEvent> controlEventList;


    ControlEventFromXML() {
        examsList = new ArrayList<>();
        ofsetsList = new ArrayList<>();
        controlEventList = new ArrayList<>();

    }

    List<AbstractControlEvent> getControlEventList() {
        return controlEventList;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {


        if (qName.equalsIgnoreCase("exam")) {

            examsList.add(Double.valueOf(attributes.getValue(0)));


        } else if (qName.equalsIgnoreCase("ofset")) {
            ofsetsList.add(Boolean.valueOf(attributes.getValue(0)));
        }


    }


    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equalsIgnoreCase("event")) {
            if (ofsetsList.size() == 0) {
                controlEventList.add(new ControlEventFirstType(examsList.get(0), examsList.get(1)));
            } else if (ofsetsList.size() == 1) {
                controlEventList.add(new ControlEventSecondType(examsList.get(0), examsList.get(1), ofsetsList.get(0)));
            } else if (ofsetsList.size() == 2) {
                controlEventList.add(new ControlEventThirdType(ofsetsList.get(0), ofsetsList.get(1), examsList.get(0)));
            }
            clearLists();

        }
    }

    private void clearLists() {
        examsList.clear();
        ofsetsList.clear();
    }

}
