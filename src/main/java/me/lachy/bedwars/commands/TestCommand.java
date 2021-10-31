package me.lachy.bedwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.HelpCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand extends BaseCommand {

    @Default
    public void test(Player player, String arg1, @Default("1") int arg2) {
        player.sendMessage(arg1 + arg2);
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
