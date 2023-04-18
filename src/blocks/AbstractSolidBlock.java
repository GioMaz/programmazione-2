package blocks;

public abstract class AbstractSolidBlock implements Block {
    protected boolean fallsWithGravity;
    protected boolean fallsThrough;
    protected char type;
    protected String blockName;

    public AbstractSolidBlock() {
        fallsWithGravity = false;
        fallsThrough = false;
    }

    public String toString() {
        return "<" + blockName + ", " + type + ", " + fallsWithGravity + ", " + fallsThrough + ">";
    }

    public char display() {
        return this.type;
    }

    public boolean fallsThrough() {
        return this.fallsThrough;
    }

    public boolean fallsWithGravity() {
        return this.fallsWithGravity;
    }
}