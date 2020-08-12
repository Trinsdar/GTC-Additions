package gtc_additions.data;

import gtc_additions.block.GTCABlockTile;
import gtc_expansion.block.GTCXBlockTile;
import gtc_expansion.item.itemblock.GTCXColorItemBlock;
import gtclassic.api.interfaces.IGTColorBlock;
import gtclassic.api.interfaces.IGTItemBlock;
import gtclassic.api.item.GTItemBlock;
import ic2.core.IC2;
import ic2.core.item.block.ItemBlockRare;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class GTCABlocks {
    private GTCABlocks() {
        throw new IllegalStateException("Utility class");
    }

    static final List<Block> toRegister = new ArrayList();
    public static final GTCXBlockTile laminator = registerBlock(new GTCABlockTile("laminator", GTCALang.LAMINATOR));
    public static final GTCXBlockTile autoclave = registerBlock(new GTCABlockTile("autoclave", GTCALang.AUTOCLAVE));
    public static final GTCXBlockTile circuitAssembler = registerBlock(new GTCABlockTile("circuitassembler", GTCALang.CIRCUIT_ASSEMBLER));


    public static final String[] textureTileBasic = new String[]{};
    public static void registerBlocks() {
        for(Block block : toRegister){
            createBlock(block);
        }
    }

    static <T extends Block> T registerBlock(T block) {
        toRegister.add(block);
        return block;
    }

    public static void createBlock(Block block) {
        IC2.getInstance().createBlock(block, getItemBlock(block));
    }

    static Class<? extends ItemBlockRare> getItemBlock(Block block) {
        if (block instanceof IGTItemBlock) {
            return ((IGTItemBlock)block).getCustomItemBlock();
        } else {
            return block instanceof IGTColorBlock ? GTCXColorItemBlock.class : GTItemBlock.class;
        }
    }
}
