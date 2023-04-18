package blocks;

public class AirBlock extends AbstractBlock {
    public AirBlock() {
        this.fallsWithGravity = false;
        this.fallsThrough = true;
        this.type = '.';
        this.blockName = "Air";
    }
}