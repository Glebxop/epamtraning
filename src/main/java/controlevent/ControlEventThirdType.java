package controlevent;

public class ControlEventThirdType extends AbstractAbstractControlEventWithOfsets {

    static double passing;

    static {
        passing = 40;
    }

    public ControlEventThirdType(boolean offset1, boolean offset2, double exam) {
        setOfsets(new boolean[]{offset1, offset2});
        setExams(new double[]{exam});

    }


    public boolean isPassed() {

        return getExams()[0] >= passing & getOfsets()[0] & getOfsets()[1];
    }


    public void print() {
        System.out.println("Зачет №1- " + getPassedString(getOfsets()[0]) + ", зачет №2- " + getPassedString(getOfsets()[1]) + ", экзамен- " + getExams()[0]);
    }

    @Override
    public double getMaxScaledScore() {
        return (super.getMaxScaledScore()) / 10;
    }
}
