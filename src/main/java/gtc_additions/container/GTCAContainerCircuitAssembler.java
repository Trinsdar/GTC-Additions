package gtc_additions.container;

import gtc_additions.tile.GTCATileCircuitAssembler;
import gtclassic.api.gui.GTSlotUpgrade;
import ic2.core.inventory.container.ContainerTileComponent;
import ic2.core.inventory.gui.GuiIC2;
import ic2.core.inventory.gui.components.base.MachineProgressComp;
import ic2.core.inventory.slots.SlotCustom;
import ic2.core.inventory.slots.SlotDischarge;
import ic2.core.inventory.slots.SlotOutput;
import ic2.core.util.math.Box2D;
import ic2.core.util.math.Vec2i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCAContainerCircuitAssembler extends ContainerTileComponent<GTCATileCircuitAssembler> {
    public static Box2D machineProgressBox = new Box2D(78, 24, 20, 18); // the progress bar and size
    public static Vec2i machineProgressPos = new Vec2i(176, 0); // where the overlay is
    public GTCAContainerCircuitAssembler(GTCATileCircuitAssembler tile, InventoryPlayer player) {
        super(tile);
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 2; y++){
                this.addSlotToContainer(new SlotCustom(tile, x + y * 3, 17 + x * 18, 17 + y * 18, tile.filter));
            }
        }
        this.addSlotToContainer(new SlotOutput(player.player, tile, 6, 107, 25));
        this.addSlotToContainer(new SlotOutput(player.player, tile, 7, 125, 25));
        this.addSlotToContainer(new SlotDischarge(tile, Integer.MAX_VALUE, 8, 8, 62));
        for (int i = 0; i < 4; ++i) {
            this.addSlotToContainer(new GTSlotUpgrade(tile, 9 + i, 62 + (i * 18), 62));
        }
        this.addComponent(new MachineProgressComp(tile, machineProgressBox, machineProgressPos));
    }

    @Override
    public ResourceLocation getTexture() {
        return this.getGuiHolder().getGuiTexture();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onGuiLoaded(GuiIC2 gui) {
        gui.dissableInvName();
    }

    @Override
    public int guiInventorySize() {
        return this.getGuiHolder().getSlotCount();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.getGuiHolder().canInteractWith(playerIn);
    }
}
