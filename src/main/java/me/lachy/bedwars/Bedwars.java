package me.lachy.bedwars;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.annotation.CommandAlias;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class Bedwars extends JavaPlugin {

    @Getter private static Bedwars instance;

    private BukkitCommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        this.commandManager = new BukkitCommandManager(this);

        this.registerCommands();
        this.registerEvents();
    }

    private void registerEvents() {
        String packageName = this.getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packageName + ".listeners").getSubTypesOf(Listener.class)) {
            try {
                Listener listener = (Listener) clazz.getDeclaredConstructor().newInstance();
                this.getServer().getPluginManager().registerEvents(listener, this);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private void registerCommands() {
        String packageName = this.getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packageName + ".commands").getSubTypesOf(BaseCommand.class)) {
            try {
                BaseCommand command = (BaseCommand) clazz.getDeclaredConstructor().newInstance();
                this.commandManager.registerCommand(command);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
