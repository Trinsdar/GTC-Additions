package gtc_additions.tile;

import gtc_additions.recipes.GTCARecipeLists;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.classic.item.IMachineUpgradeItem;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.filters.MachineFilter;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GTCATileCircuitAssembler extends GTTileBaseMachine {
    public IFilter filter = new MachineFilter(this);
    private static final int defaultEu = 64;
    static final int slotFuel = 7;
    public GTCATileCircuitAssembler() {
        super(8, 2, defaultEu, 100, 128);
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
        return i != slotFuel;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{ 6 };
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
        return null;
    }
}
