package me.lachy.bedwars.map.utils;

import lombok.Getter;
import me.lachy.bedwars.Bedwars;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapUtils {

    public static final NamespacedKey GENERATOR_ITEM = new NamespacedKey(Bedwars.getInstance(), "generatorItem");
    @Getter private static final Path path = Path.of(Bedwars.getInstance().getDataFolder().getPath(), "Maps");

    public static List<File> getAllMaps() {
        File folder = path.toFile();

        File[] files = folder.listFiles();
        if (files != null) {
            return Arrays.stream(files)
                    .filter(File::isFile)
                    .filter(file -> file.getAbsolutePath().endsWith(".json"))
                    .collect(Collectors.toList());
        }

        return null;
    }

    public static File getMap(String name) {
        List<File> allMaps = getAllMaps();
        if (allMaps == null) {
            return null;
        }

        List<File> collect = allMaps.stream()
                .filter(file -> file.getName().equalsIgnoreCase(name + ".json"))
                .collect(Collectors.toList());
        Optional<File> first = collect.stream().findFirst();
        return first.orElse(null);
    }

    public static void setBed(Block start, BlockFace facing, Material material) {
        for (Bed.Part part : Bed.Part.values()) {
            start.setBlockData(Bukkit.createBlockData(material, (data) -> {
                ((Bed) data).setPart(part);
                ((Bed) data).setFacing(facing);
            }));
            start = start.getRelative(facing.getOppositeFace());
        }
    }

}
