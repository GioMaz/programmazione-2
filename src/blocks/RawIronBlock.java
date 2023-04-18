package blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
     public RawIronBlock() {
         super();
         this.type = 'R';
         this.blockName = "GlassBlock";
     }

     public Block smelt() {
         return new IronBlock();
     }
}