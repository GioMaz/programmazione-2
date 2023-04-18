package blocks;

public class Furnace extends AbstractSolidBlock {
    private SmeltableBlock input;
    private Block output;

    public Furnace() {
        super();
        input = null;
        output = null;
    }

    public void smelt() {
        if (isOutputEmpty()) {
            output = input.smelt();
            clearInput();
        }
    }

    public void setInput(SmeltableBlock input) {
        if (isInputEmpty()) {
            this.input = input;
        }
    }

    public void clearInput() {
        input = null;
    }

    public Block getOutput() {
        return output;
    }

    public boolean isInputEmpty() {
        return input == null;
    }

    public boolean isOutputEmpty() {
        return output == null;
    }

    public void clearOutput() {
        output = null;
    }
}