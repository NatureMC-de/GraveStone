package de.leontendev;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;

public class GraveStone extends PluginBase {

    public static String prefix = "§lGraveStone §r» ";

    @Override
    public void onEnable() {
        Server.getInstance().getLogger().info(prefix + "§aThe plugin has been activated!");
    }
}
