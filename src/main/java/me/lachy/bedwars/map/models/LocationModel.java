package me.lachy.bedwars.map.models;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;

public class LocationModel {

    private double x;
    private double y;
    private double z;
    private double yaw;
    private double pitch;

    public Location toLocation(World world) {
        return new Location(world, this.x, this.y, this.z, (float) this.yaw, (float) this.pitch);
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", yaw=" + yaw +
                ", pitch=" + pitch +
                '}';
    }

    public static class BedLocationModel {

        private int x;
        private int y;
        private int z;
        @Getter private Material type;
        @Getter private BlockFace facing;

        public Location toLocation(World world) {
            return new Location(world, this.x, this.y, this.z);
        }

        @Override
        public String toString() {
            return "BedLocationModel{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", type=" + type +
                    '}';
        }
    }
}
