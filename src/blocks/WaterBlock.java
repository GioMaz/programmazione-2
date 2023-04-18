package blocks;

public class WaterBlock extends AbstractBlock {
    public WaterBlock() {
        this.fallsWithGravity = true;
        this.fallsThrough = true;
        this.type = '~';
        this.blockName = "Water";
    }
}