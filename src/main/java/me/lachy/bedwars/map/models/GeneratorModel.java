package me.lachy.bedwars.map.models;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;

public class GeneratorModel {

    private double x;
    private double y;
    private double z;
    @Getter private String material;

    public Location toLocation(World world) {
        return new Location(world, x, y, z);
    }

    @Override
    public String toString() {
        return "GeneratorModel{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", material='" + material + '\'' +
                '}';
    }
}
