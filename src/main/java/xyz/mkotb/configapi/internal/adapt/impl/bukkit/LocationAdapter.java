package xyz.mkotb.configapi.internal.adapt.impl.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import xyz.mkotb.configapi.internal.adapt.ObjectAdapter;

/**
 * @author TehNeon
 * @since 3/16/2017
 */
public class LocationAdapter implements ObjectAdapter<Location, String> {

    @Override
    public Location read(String key, ConfigurationSection configurationSection) {
        String[] split = configurationSection.getString(key).split(",");
        World world = Bukkit.getWorld(split[0]);
        int x = Integer.parseInt(split[1]);
        int y = Integer.parseInt(split[2]);
        int z = Integer.parseInt(split[3]);
        float pitch = Float.parseFloat(split[4]);
        float yaw = Float.parseFloat(split[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }

    @Override
    public String write(Location location) {
        return location.getWorld().getName() + "," +
                location.getBlockX() + "," +
                location.getBlockY() + "," +
                location.getBlockZ() + "," +
                location.getPitch() + "," +
                location.getYaw();
    }
}
