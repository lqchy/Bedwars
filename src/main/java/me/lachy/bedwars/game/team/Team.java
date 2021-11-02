package me.lachy.bedwars.game.team;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;

import java.util.*;

public enum Team {

    RED(Material.RED_WOOL, Material.RED_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.RED, new HashSet<>()),
    BLUE(Material.BLUE_WOOL, Material.BLUE_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.BLUE, new HashSet<>()),
    GREEN(Material.LIME_WOOL, Material.LIME_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.GREEN, new HashSet<>()),
    YELLOW(Material.YELLOW_WOOL, Material.YELLOW_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.YELLOW, new HashSet<>()),
    AQUA(Material.CYAN_WOOL, Material.CYAN_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.AQUA, new HashSet<>()),
    WHITE(Material.WHITE_WOOL, Material.WHITE_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.WHITE, new HashSet<>()),
    PINK(Material.PINK_WOOL, Material.PINK_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.LIGHT_PURPLE, new HashSet<>()),
    GRAY(Material.GRAY_WOOL, Material.GRAY_BED, BlockFace.EAST, new ArrayList<>(), ChatColor.DARK_GRAY, new HashSet<>());

    private final Material woolMaterial;
    private final Material bedMaterial;
    private final BlockFace bedDirection;
    private final List<UUID> members;
    private final ChatColor color;
    private final Set<BedwarsFlag> flags;

    Team(Material woolMaterial, Material bedMaterial, BlockFace bedDirection, List<UUID> members, ChatColor color, Set<BedwarsFlag> flags) {
        this.woolMaterial = woolMaterial;
        this.bedMaterial = bedMaterial;
        this.bedDirection = bedDirection;
        this.members = members;
        this.color = color;
        this.flags = flags;
    }

    public Material getWool() {
        return this.woolMaterial;
    }

    public Material getBed() {
        return this.bedMaterial;
    }

    public List<UUID> getMembers() {
        return this.members;
    }

    public ChatColor getColor() {
        return this.color;
    }

    public Set<BedwarsFlag> getFlags() {
        return this.flags;
    }

    public BlockFace getBedDirection() {
        return bedDirection;
    }
}
