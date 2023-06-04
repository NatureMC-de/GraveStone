package de.leontendev.utils;

import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import de.leontendev.GraveStone;

import java.io.File;
import java.util.UUID;

public class GravesFile {

    private GraveStone plugin;
    private Config config;
    private File file;

    public GravesFile(GraveStone plugin) {
        this.plugin = plugin;
    }

    public void createFile(UUID uuid, Item[] items, Location location){
        this.file = new File(plugin.getDataFolder() + "/graves", uuid.toString() + ".yml");
        this.config = new Config(this.file, 2);
        this.addDefault("grave.uuid", uuid);
        this.addDefault("grave.items", items);
        this.addDefault("grave.location.x", location.x);
        this.addDefault("grave.location.y", location.y);
        this.addDefault("grave.location.z", location.z);
        this.addDefault("grave.location.world", location.getLevel().getName());
    }

    public void addDefault(String path, Object object) {
        if (!this.config.exists(path)) {
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }
}
