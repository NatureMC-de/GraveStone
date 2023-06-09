package de.leontendev;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.plugin.PluginBase;
import de.leontendev.block.GraveStoneBlock;
import de.leontendev.events.onBreak;
import de.leontendev.events.onDeath;
import de.leontendev.events.onMove;

import java.util.List;

public class GraveStone extends PluginBase {

    public static String prefix = "§lGraveStoneMod §r» ";

    @Override
    public void onLoad() {
        Block.registerCustomBlock(List.of(GraveStoneBlock.class));
    }

    @Override
    public void onEnable() {
        Server.getInstance().getPluginManager().registerEvents(new onDeath(), this);
        Server.getInstance().getPluginManager().registerEvents(new onMove(), this);
        Server.getInstance().getPluginManager().registerEvents(new onBreak(), this);
        Server.getInstance().getLogger().info(prefix + "§aThe plugin has been activated!");
    }
}
