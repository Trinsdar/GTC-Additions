package gtc_additions.tile;

import gtc_additions.GTCAMachineGui;
import gtc_additions.GTCAdditions;
import gtc_additions.container.GTCAContainerLaminator;
import gtc_additions.recipes.GTCARecipeLists;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.classic.item.IMachineUpgradeItem;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.filters.MachineFilter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GTCATileLaminator extends GTTileBaseMachine {
    public IFilter filter = new MachineFilter(this);
    private static final int defaultEu = 4;
    static final int slotFuel = 3;
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(GTCAdditions.MODID, "textures/gui/laminator.png");
    public GTCATileLaminator() {
        super(4, 4, defaultEu, 100, 32);
        this.setFuelSlot(slotFuel);
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{ 0, 1 };
    }

    @Override
    public IFilter[] getInputFilters(int[] ints) {
        return new IFilter[]{filter};
    }

    @Override
    public boolean isRecipeSlot(int i) {
        return i < 2;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{ 2 };
    }

    @Override
    public GTRecipeMultiInputList getRecipeList() {
        return GTCARecipeLists.LAMINATOR_RECIPE_LIST;
    }

    @Override
    public Set<IMachineUpgradeItem.UpgradeType> getSupportedTypes() {
        return new LinkedHashSet<>(Arrays.asList(IMachineUpgradeItem.UpgradeType.values()));
    }

    @Override
    public ContainerIC2 getGuiContainer(EntityPlayer entityPlayer) {
        return new GTCAContainerLaminator(this, entityPlayer.inventory);
    }

    @Override
    public Class<? extends GuiScreen> getGuiClass(EntityPlayer player) {
        return GTCAMachineGui.GTCALaminatorGui.class;
    }

    public ResourceLocation getGuiTexture() {
        return GUI_LOCATION;
    }
}
