package me.lachy.bedwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.google.common.collect.Sets;
import me.lachy.bedwars.game.team.BedwarsFlag;
import me.lachy.bedwars.game.team.Team;
import me.lachy.bedwars.utils.Utils;
import org.apache.commons.lang.WordUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Bed;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBed;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlock;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@CommandAlias("teams")
public class TeamsCommand extends BaseCommand {

    @Default
    public void _default(Player player) {
        for (Team team : Team.values()) {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.randomUUID());
            team.getMembers().add(offlinePlayer.getUniqueId());
        }

        StringBuilder builder = new StringBuilder();

        List<?> collect = Arrays.stream(Team.values())
                .sorted(Comparator.comparing(Team::ordinal))
                .map(team -> {

                    team.getFlags().add(BedwarsFlag.TEST_FLAG);
                            return builder.append(team.getColor())
                                    .append(WordUtils.capitalize(team.name().toLowerCase()))
                                    .append(ChatColor.GRAY)
                                    .append(": ")
                                    .append(Arrays.toString(team.getMembers().toArray()))
                                    .append("\n")
                                    .append(Arrays.toString(team.getFlags().toArray()))
                                    .append("\n");
                        }
                )
                .collect(Collectors.toList());

        player.sendMessage(builder.toString());

        Team team = Team.values()[ThreadLocalRandom.current().nextInt(0, Team.values().length)];
        setBed(player.getLocation().add(0, 3, 0).getBlock(), team.getBedDirection(), team.getBed());

        team = Team.values()[ThreadLocalRandom.current().nextInt(0, Team.values().length)];
        player.getLocation().add(0,5,0).getBlock().setType(team.getWool());
    }

    public void setBed(Block start, BlockFace facing, Material material) {
        for (Bed.Part part : Bed.Part.values()) {
            start.setBlockData(Bukkit.createBlockData(material, (data) -> {
                ((Bed) data).setPart(part);
                ((Bed) data).setFacing(facing);
            }));
            start = start.getRelative(facing.getOppositeFace());
        }
    }

}
