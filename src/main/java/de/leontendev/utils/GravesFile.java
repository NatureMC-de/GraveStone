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

    public void setFile(UUID uuid, Item[] items, Location location){
        this.file = new File(plugin.getDataFolder() + "/graves", uuid.toString() + ".yml");
        if (!file.exists() && !file.isDirectory()) {
            this.config = new Config(this.file, 2);
            int n = 0;
            this.addDefault("Grave.count", n);
            this.addDefault(n + ".grave.items", items);
            this.addDefault(n + ".grave.location.x", location.x);
            this.addDefault(n + ".grave.location.y", location.y);
            this.addDefault(n + ".grave.location.z", location.z);
            this.addDefault(n + ".grave.location.world", location.getLevel().getName());
        }else {
            this.config = new Config(this.file, 2);
            int n = this.config.getInt("Grave.count");
            int n2 = n + 1;
            this.config.set("Grave.count", n2);
            this.config.set(n2 + ".grave.items", items);
            this.config.set(n2 + ".grave.location.x", location.x);
            this.config.set(n2 + ".grave.location.y", location.y);
            this.config.set(n2 + ".grave.location.z", location.z);
            this.config.set(n2 + ".grave.location.world", location.getLevel().getName());
            config.save(this.file);
        }
    }

    public void addDefault(String path, Object object) {
        if (!this.config.exists(path)) {
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

    public Item[] getItems(UUID uuid){
        File file = new File(plugin.getDataFolder() + "/graves", uuid.toString() + ".yml");
        Config config1 = new Config(file, 2);
        int n = config1.getInt("Grave.count");
        return (Item[]) config.get(n + ".grave.items");
    }
}
