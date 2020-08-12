package gtc_additions.proxy;

import gtc_additions.data.GTCABlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GTCACommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        GTCABlocks.registerBlocks();
        //GTCAItems.registerItems();
        //GTCABlocks.registerTiles();
        //GTCACrops.init();
        //GTCAOreDict.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
