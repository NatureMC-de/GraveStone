package de.leontendev.block;

import cn.nukkit.block.Block;
import cn.nukkit.block.customblock.CustomBlock;
import cn.nukkit.block.customblock.CustomBlockDefinition;
import cn.nukkit.block.customblock.data.Geometry;
import org.jetbrains.annotations.NotNull;

public class GraveStoneBlock extends Block implements CustomBlock {
    @Override
    public String getName() {
        return "GraveStone";
    }

    @NotNull
    @Override
    public String getNamespaceId() {
        return "powernukkitx:gravestoneblock";
    }

    @Override
    public CustomBlockDefinition getDefinition() {
        return CustomBlockDefinition.builder(this, "gravestoneblock").breakTime(1).geometry(new Geometry("geometry.grave")).build();
    }

    @Override
    public int getId() {
        return CustomBlock.super.getId();
    }

    @Override
    public double getFrictionFactor() {
        return 0.1;
    }

    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public int getBurnChance() {
        return 0;
    }

    @Override
    public int getItemMaxStackSize() {
        return 1;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 100;
    }

    @Override
    public int getLightFilter() {
        return 0;
    }

    @Override
    public int getLightLevel() {
        return 0;
    }
}
