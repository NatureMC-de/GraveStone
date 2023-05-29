package de.leontendev.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;


import java.util.HashMap;
import java.util.UUID;


public class onDeath implements Listener {

    public static HashMap<UUID, Item[]> items = new HashMap<>();
    public static HashMap<UUID, Location> deathLocations = new HashMap<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Location location = event.getEntity().getLocation();
        Vector3 vector3 = new Vector3(location.x, location.y, location.z);
        Block block = Block.get(Block.CUSTOM_BLOCK_ID_MAP.get("powernukkitx:gravestoneblock"));
        location.level.setBlock(vector3, block);
        if (!deathLocations.containsKey(player.getUniqueId())){
            items.put(player.getUniqueId(), event.getDrops());
            deathLocations.put(player.getUniqueId(), player.getLevel().getBlock(vector3).getLocation());
        }else {
            items.remove(player.getUniqueId());
            deathLocations.remove(player.getUniqueId());
            items.put(player.getUniqueId(), event.getDrops());
            deathLocations.put(player.getUniqueId(), player.getLevel().getBlock(vector3).getLocation());
        }
        event.setDrops(new Item[]{});
    }
}
