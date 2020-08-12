package gtc_additions;

import gtc_additions.proxy.GTCACommonProxy;
import ic2.core.IC2;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GTCAdditions.MODID, name = GTCAdditions.MODNAME, version = GTCAdditions.MODVERSION, dependencies = GTCAdditions.DEPENDS)
public class GTCAdditions{
    public static final String MODID = "gtc_additions";
    public static final String MODNAME = "GTC Additions";
    public static final String MODVERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;required-after:gtclassic@[1.1.3,)";
    @SidedProxy(clientSide = MODID + ".proxy.GTCAClientProxy", serverSide = MODID + ".proxy.GTCACommonProxy")
    public static GTCACommonProxy proxy;
    @Mod.Instance
    public static GTCAdditions instance;
    public static Logger logger;


    public GTCAdditions(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public synchronized void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        IC2.getInstance().saveRecipeInfo(IC2.configFolder);
    }

}