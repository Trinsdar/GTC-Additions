package gtc_additions.block;

import gtc_additions.data.GTCABlocks;
import gtc_additions.tile.GTCATileAutoclave;
import gtc_additions.tile.GTCATileCircuitAssembler;
import gtc_additions.tile.GTCATileLaminator;
import gtc_expansion.block.GTCXBlockTile;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.platform.lang.components.base.LocaleComp;
import ic2.core.platform.lang.storage.Ic2InfoLang;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class GTCABlockTile extends GTCXBlockTile {
    public GTCABlockTile(String name, LocaleComp comp) {
        super(name, comp);
    }

    @Override
    public TileEntityBlock createNewTileEntity(World worldIn, int meta) {
        if (this == GTCABlocks.autoclave){
            return new GTCATileAutoclave();
        }
        if (this == GTCABlocks.circuitAssembler){
            return new GTCATileCircuitAssembler();
        }
        if (this == GTCABlocks.laminator){
            return new GTCATileLaminator();
        }
        return null;
    }

    @Override
    public void addReaderInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag iTooltipFlag) {
        if (this.compare(stack, GTCABlocks.laminator) || this.compare(stack, GTCABlocks.circuitAssembler)) {
            tooltip.add(Ic2InfoLang.euReaderSinkInfo.getLocalizedFormatted(new Object[]{32}));
        }
        if (this.compare(stack, GTCABlocks.autoclave)) {
            tooltip.add(Ic2InfoLang.euReaderSinkInfo.getLocalizedFormatted(new Object[]{128}));
        }
    }
}
