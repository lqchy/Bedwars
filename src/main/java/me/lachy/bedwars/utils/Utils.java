package me.lachy.bedwars.utils;

import org.bukkit.block.BlockFace;

public class Utils {
    public static byte getBedData(BlockFace bedDirection) {
        byte flags = (byte) 8;
        return switch (bedDirection) {
            case EAST -> flags;
            case SOUTH -> (byte) (flags | 0x1);
            case WEST -> (byte) (flags | 0x2);
            case NORTH -> (byte) (flags | 0x3);
            default -> throw new IllegalStateException("Unexpected value: " + bedDirection);
        };
    }
}
