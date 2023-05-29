package de.leontendev.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;


public class onDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Item[] items = event.getDrops();
        Location location = event.getEntity().getLocation();
        location.level.setBlock(new Vector3(location.x, location.y, location.z), Block.get(Block.ACACIA_WOOD_STAIRS));
        event.setDrops(new Item[]{});
    }
}
