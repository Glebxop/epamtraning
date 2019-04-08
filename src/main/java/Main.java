
import controlevent.AbstractControlEvent;
import controlevent.ControlEventFirstType;
import controlevent.ControlEventSecondType;
import controlevent.ControlEventThirdType;

import org.xml.sax.SAXException;
import xml.XMLreader;
import xml.XMLwriter;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ControlEventSecondType controlEventSecondType = new ControlEventSecondType(5, 6, true);
        ControlEventThirdType controlEventThirdType = new ControlEventThirdType(true, true, 20);
        ControlEventFirstType controlEventFirstType = new ControlEventFirstType(7, 7);

        List<AbstractControlEvent> list = new ArrayList<>();
        list.add(controlEventFirstType);
        list.add(controlEventSecondType);
        list.add(controlEventThirdType);

        /*for (AbstractControlEvent abstractControlEvent:list){
            abstractControlEvent.print();}

        Collections.sort(list);

        List <AbstractControlEvent>passed=new ArrayList<AbstractControlEvent>();
        List<AbstractControlEvent> notPassed=new ArrayList<AbstractControlEvent>();
        for (AbstractControlEvent abstractControlEvent :list){
            if (abstractControlEvent.isPassed()){
                passed.add(abstractControlEvent);
            }else notPassed.add(abstractControlEvent);
        }
        for (AbstractControlEvent abstractControlEvent:passed){
        abstractControlEvent.print();}*/


        XMLwriter xmLwriter = new XMLwriter();
        xmLwriter.write("D:/MyXML.xml", list);

        XMLreader xmLreader = new XMLreader();
        List<AbstractControlEvent> abstractControlEventList = xmLreader.read("D:/MyXML.xml");
        for (AbstractControlEvent abstractControlEvent : abstractControlEventList) {
            abstractControlEvent.print();
        }

    }
}
