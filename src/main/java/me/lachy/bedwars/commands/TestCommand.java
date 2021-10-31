package me.lachy.bedwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("test")
public class TestCommand extends BaseCommand {

    @Default
    public void test(Player player, String arg1, @Default("1") int arg2) {
        player.sendMessage(arg1 + arg2);
    }

    @Subcommand("diamond")
    public void diamond(Player player) {
        player.getInventory().addItem(new ItemStack(Material.DIAMOND));
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
