import controlevent.AbstractControlEvent;
import org.xml.sax.SAXException;
import xml.XMLreader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

class Launcher {
    void start() {

        System.out.println("Enter file name");
        Scanner scanner = new Scanner(System.in);
        String filePathFromConsole = scanner.nextLine();
        XMLreader xmLreader = new XMLreader();
        List<AbstractControlEvent> abstractControlEventList = null;
        try {
            abstractControlEventList = xmLreader.read(filePathFromConsole);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            abstractControlEventList = new ArrayList<>();
            System.out.println("Problem reading file");
        }

        output(abstractControlEventList);

        Collections.sort(abstractControlEventList);

        abstractControlEventList = passedSort(abstractControlEventList);

        output(abstractControlEventList);

        isRangeEstimate(abstractControlEventList);


    }

    private static void output(List<AbstractControlEvent> abstractControlEventList) {
        for (AbstractControlEvent abstractControlEvent : abstractControlEventList) {
            abstractControlEvent.print();
        }
    }

    private static List<AbstractControlEvent> passedSort(List<AbstractControlEvent> abstractControlEventList) {
        List<AbstractControlEvent> passed = new ArrayList<>();
        List<AbstractControlEvent> notPassed = new ArrayList<>();
        for (AbstractControlEvent abstractControlEvent : abstractControlEventList) {
            if (abstractControlEvent.isPassed()) {
                passed.add(abstractControlEvent);
            } else notPassed.add(abstractControlEvent);
        }
        passed.addAll(notPassed);
        return passed;
    }

    private static void isRangeEstimate(List<AbstractControlEvent> abstractControlEventList) {
        for (AbstractControlEvent abstractControlEvent : abstractControlEventList) {
            if (abstractControlEvent.isPassed() & abstractControlEvent.getMaxScaledScore() >= 4 & abstractControlEvent.getMaxScaledScore() <= 5) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
