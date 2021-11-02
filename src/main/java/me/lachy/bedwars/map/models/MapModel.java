package me.lachy.bedwars.map.models;

import java.util.Map;

public class MapModel {

    private String worldName;
    private Map<String, IslandModel> islands;

    public Map<String, IslandModel> getIslands() {
        return this.islands;
    }

    public IslandModel getIsland(String name) {
        return this.islands.get(name);
    }

    public String getWorldName() {
        return this.worldName;
    }
}
