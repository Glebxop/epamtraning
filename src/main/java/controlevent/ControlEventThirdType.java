package controlevent;

public class ControlEventThirdType extends AbstractAbstractControlEventWithOffsets {

    static double passing;

    static {
        passing = 40;
    }

    public ControlEventThirdType(boolean offset1, boolean offset2, double exam) {
        setOffsets(new boolean[]{offset1, offset2});
        setExams(new double[]{exam});

    }


    public boolean isPassed() {

        return getExams()[0] >= passing & getOffsets()[0] & getOffsets()[1];
    }


    public void print() {
        System.out.println("Зачет №1- " + getPassedString(getOffsets()[0]) + ", зачет №2- " + getPassedString(getOffsets()[1]) + ", экзамен- " + getExams()[0]);
    }

    @Override
    public double getMaxScaledScore() {
        return (super.getMaxScaledScore()) / 10;
    }
}
