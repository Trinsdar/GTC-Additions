package gtc_additions.tile;

import gtc_additions.GTCAdditions;
import gtc_additions.recipes.GTCARecipeLists;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.classic.item.IMachineUpgradeItem;
import ic2.api.classic.network.adv.NetworkField;
import ic2.core.fluid.IC2Tank;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.filters.MachineFilter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GTCXTileAutoclave extends GTTileBaseMachine {
    public IFilter filter = new MachineFilter(this);
    private static final int defaultEu = 64;
    static final int SLOT_FUEL = 4;
    public static final int SLOT_TANK = 3;
    public static final String NBT_TANK = "tank";
    protected static final int[] SLOT_INPUTS = { 0, 1 };
    protected static final int[] SLOT_OUTPUTS = { 2 };
    @NetworkField(index = 13)
    private IC2Tank tank;
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(GTCAdditions.MODID, "textures/gui/autoclave.png");
    public GTCXTileAutoclave() {
        super(5, 2, defaultEu, 100, 128);
        this.setFuelSlot(SLOT_FUEL);
    }

    @Override
    public int[] getInputSlots() {
        return SLOT_INPUTS;
    }

    @Override
    public IFilter[] getInputFilters(int[] ints) {
        return new IFilter[]{ filter };
    }

    @Override
    public boolean isRecipeSlot(int i) {
        return i < 2;
    }

    @Override
    public int[] getOutputSlots() {
        return SLOT_OUTPUTS;
    }

    @Override
    public GTRecipeMultiInputList getRecipeList() {
        return GTCARecipeLists.AUTOCLAVE_RECIPE_LIST;
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
