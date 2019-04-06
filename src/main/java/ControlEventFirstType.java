public class ControlEventFirstType extends AbstractControlEvent {
    static {
        passing = 12;
    }


    private static double passing;


    public ControlEventFirstType(int exam1, int exam2) {
        setExams(new double[]{exam1, exam2});

    }


    public void print() {
        System.out.println("Экзамен № 1 - " + getExams()[0]+" экзамен № 2 -"+ getExams()[1]);
    }

    @Override
    public boolean isPassed() {

        return (getExams()[0] + getExams()[1]) > passing;
    }

}
