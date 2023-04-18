package blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock() {
        this.fallsWithGravity = true;
        this.fallsThrough = false;
        this.type = 'S';
    }

    public Block smelt() {
        return new GlassBlock();
    }
}