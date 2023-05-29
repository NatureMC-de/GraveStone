package de.leontendev.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;

public class onBreak implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location loc = event.getBlock().getLocation();
        if (onDeath.deathLocations.containsKey(player.getUniqueId())){
            player.sendMessage("loc: " + onDeath.deathLocations.get(player.getUniqueId()) + " loc2: " + loc);
            if (onDeath.deathLocations.get(player.getUniqueId()).equals(loc)){
                player.sendMessage("2");
                Item[] items = onDeath.items.get(player.getUniqueId());
                event.setDrops(items);
                onDeath.deathLocations.remove(player.getUniqueId());
                onDeath.items.remove(player.getUniqueId());
            }
        }
    }
}
