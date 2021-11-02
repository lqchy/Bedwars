package me.lachy.bedwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.lachy.bedwars.Bedwars;
import me.lachy.bedwars.map.models.MapModel;
import me.lachy.bedwars.map.utils.MapUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@CommandAlias("maplist")
public class MapCommand extends BaseCommand {

    @Default
    public void onDefault(Player player) {
        List<File> maps = MapUtils.getAllMaps();

        if (maps != null) {
            maps.forEach(file -> {
                try {
                    MapModel model = Bedwars.getGson().fromJson(new FileReader(file), MapModel.class);
                    player.sendMessage(ChatColor.AQUA + model.getWorldName());
                    System.out.println(model);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    player.sendMessage(ChatColor.RED + "Error");
                }
            });
        }
    }

}
