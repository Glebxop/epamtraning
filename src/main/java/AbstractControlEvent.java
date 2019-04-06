import org.apache.commons.lang3.math.NumberUtils;


public abstract class AbstractControlEvent implements Comparable<AbstractControlEvent> {

    private double[] exams;


    public int compareTo(AbstractControlEvent o) {
        return -Double.compare(this.getMaxScaledScore(), o.getMaxScaledScore());
    }


    public double[] getExams() {
        return exams;
    }

    public void setExams(double[] exams) {
        this.exams = exams;
    }


    public abstract void print();

    public abstract boolean isPassed();

    public double getMaxScaledScore() {

        return NumberUtils.max(getExams());

    }


}
