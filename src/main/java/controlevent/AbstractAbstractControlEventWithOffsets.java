package controlevent;

public abstract class AbstractAbstractControlEventWithOffsets extends AbstractControlEvent {
    private boolean[] offsets;

    public boolean[] getOffsets() {
        return offsets;
    }

     void setOffsets(boolean[] offsets) {
        this.offsets = offsets;
    }

     String getPassedString(boolean passed) {
        return passed ? "Зачтено" : "Незачтено";
    }
}
