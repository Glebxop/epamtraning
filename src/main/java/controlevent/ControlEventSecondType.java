package controlevent;

public class ControlEventSecondType extends AbstractAbstractControlEventWithOffsets {
    {
        passing = 5;
    }

    private double passing;


    public ControlEventSecondType(double exam1, double exam2, boolean offset) {
        setOffsets(new boolean[]{offset});
        setExams(new double[]{exam1, exam2});

    }

    public void print() {
        System.out.println("Экзамен № 1 - " + getExams()[0] + ", экзамен № 2 - " + getExams()[1] + ", зачет № 1 - " + getPassedString(getOffsets()[0]));

    }

    public boolean isPassed() {

        return getExams()[0] >= passing & getExams()[1] >= passing & getOffsets()[0];
    }
}
