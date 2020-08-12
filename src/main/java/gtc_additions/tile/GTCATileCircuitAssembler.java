package gtc_additions.tile;

import gtc_additions.GTCAdditions;
import gtc_additions.container.GTCAContainerCircuitAssembler;
import gtc_additions.recipes.GTCARecipeLists;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.classic.item.IMachineUpgradeItem;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.filters.MachineFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GTCATileCircuitAssembler extends GTTileBaseMachine {
    public IFilter filter = new MachineFilter(this);
    private static final int defaultEu = 8;
    static final int slotFuel = 8;
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(GTCAdditions.MODID, "textures/gui/circuitassembler.png");
    public GTCATileCircuitAssembler() {
        super(9, 4, defaultEu, 100, 32);
        this.setFuelSlot(slotFuel);
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{ 0, 1, 2 ,3 ,4 ,5 };
    }

    @Override
    public IFilter[] getInputFilters(int[] ints) {
        return new IFilter[]{filter};
    }

    @Override
    public boolean isRecipeSlot(int i) {
        return i < 6;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{ 6, 7 };
    }

    @Override
    public GTRecipeMultiInputList getRecipeList() {
        return GTCARecipeLists.CIRCUIT_ASSEMBLER_RECIPE_LIST;
    }

    @Override
    public Set<IMachineUpgradeItem.UpgradeType> getSupportedTypes() {
        return new LinkedHashSet<>(Arrays.asList(IMachineUpgradeItem.UpgradeType.values()));
    }

    @Override
    public ContainerIC2 getGuiContainer(EntityPlayer entityPlayer) {
        return new GTCAContainerCircuitAssembler(this, entityPlayer.inventory);
    }

    public ResourceLocation getGuiTexture() {
        return GUI_LOCATION;
    }
}
