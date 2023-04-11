public class Cell {
    private int value;
    private boolean isEditable;

    public Cell(int value, boolean isEditable) {
        this.value = value;
        this.isEditable = isEditable;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEditable() {
        return isEditable;
    }
}
