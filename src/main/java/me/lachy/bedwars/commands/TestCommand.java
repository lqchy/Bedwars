package me.lachy.bedwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import me.lachy.bedwars.Bedwars;
import me.lachy.bedwars.map.models.LocationModel;
import me.lachy.bedwars.map.models.MapModel;
import me.lachy.bedwars.map.utils.Cuboid;
import me.lachy.bedwars.map.utils.MapUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@CommandAlias("test")
public class TestCommand extends BaseCommand {

    @Default
    public void test(Player player, String arg1, @Default("1") int arg2) {
        player.sendMessage(arg1 + arg2);
    }

    @Subcommand("map")
    public void map(Player player, String mapName) {
        File map = MapUtils.getMap(mapName);
        if (map == null) {
            return;
        }

        try {
            FileReader reader = new FileReader(map);
            MapModel model = Bedwars.getGson().fromJson(reader, MapModel.class);
            LocationModel.BedLocationModel bedModel = model.getIsland(0).getBeds().get(0);
            Location location = bedModel.toLocation(player.getWorld());

            model.getIslands().get(0).getGenerators().forEach(generatorModel -> {
                Location genLoc = generatorModel.toLocation(player.getWorld());
                Material material = Material.valueOf(generatorModel.getMaterial());
                ItemStack stack = new ItemStack(material);

                World world = genLoc.getWorld();
                if (world != null) {
                    Item item = world.dropItem(genLoc, stack);
                    item.getPersistentDataContainer().set(MapUtils.GENERATOR_ITEM, PersistentDataType.BYTE, (byte) 1);
                }
            });

//            MapUtils.setBed(location.getBlock(), bedModel.getFacing(), bedModel.getType());
//
//            Location pos1 = model.getIsland(0).getPos1().toLocation(player.getWorld());
//            Location pos2 = model.getIsland(0).getPos2().toLocation(player.getWorld());
//
//            Cuboid cuboid = new Cuboid(pos1, pos2);
//            cuboid.blockList().forEachRemaining(block -> {
//                if (block.getType().equals(Material.WHITE_WOOL)) {
//                    block.setType(Material.valueOf(model.getIslands().get(0).getWoolColour()));
//                }
//            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @CatchUnknown
    public void onUnknown(CommandSender sender) {
        sender.sendMessage("Unknown subcommand");
    }

    @HelpCommand
    public void onHelp(CommandSender sender, CommandHelp help) {
        help.showHelp();
    }
}
