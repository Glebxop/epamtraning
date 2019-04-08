package controlevent;

public abstract class AbstractAbstractControlEventWithOfsets extends AbstractControlEvent {
    private boolean[] ofsets;
    public boolean[] getOfsets() {
        return ofsets;
    }

    public void setOfsets(boolean[] ofsets) {
        this.ofsets = ofsets;
    }

    public String getPassedString(boolean passed){
        return passed?"Зачтено":"Незачтено";
    }
}
