package me.lachy.bedwars.listeners;

import me.lachy.bedwars.map.utils.MapUtils;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.persistence.PersistentDataType;

public class ItemMergeListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onItemMerge(ItemMergeEvent event) {
        if (isGenItem(event.getEntity())) {
            event.setCancelled(true);
        }
    }

    private boolean isGenItem(Entity entity) {
        return entity.getPersistentDataContainer().has(MapUtils.GENERATOR_ITEM, PersistentDataType.BYTE);
    }
}
