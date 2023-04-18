package blocks;

public abstract class AbstractBlock implements Block {
    protected boolean fallsWithGravity;
    protected boolean fallsThrough;
    protected char type;
    protected String blockName;

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