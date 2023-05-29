package de.leontendev.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;

public class onMove implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (onDeath.deathLocations.containsKey(player.getUniqueId())) {
            Location deathloc = onDeath.deathLocations.get(player.getUniqueId());
            int distance = (int) deathloc.distance(new Vector3(player.getX(), player.getY(), player.getZ()));
            player.sendActionBar("Grave: " + distance + " blocks.");
        }
    }
}
