package gtc_additions.block;

import gtc_expansion.block.GTCXBlockTile;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.platform.lang.components.base.LocaleComp;
import net.minecraft.world.World;

public class GTCABlockTile extends GTCXBlockTile {
    public GTCABlockTile(String name, LocaleComp comp) {
        super(name, comp);
    }

    @Override
    public TileEntityBlock createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
