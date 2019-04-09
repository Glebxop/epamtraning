package controlevent;

public abstract class AbstractAbstractControlEventWithOffsets extends AbstractControlEvent {
    private boolean[] offsets;

    public boolean[] getOffsets() {
        return offsets;
    }

    public void setOffsets(boolean[] offsets) {
        this.offsets = offsets;
    }

    public String getPassedString(boolean passed) {
        return passed ? "Зачтено" : "Незачтено";
    }
}
