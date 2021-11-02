package me.lachy.bedwars.map.models;

import java.util.List;

public class MapModel {

    private String worldName;
    private List<IslandModel> islands;

    public List<IslandModel> getIslands() {
        return this.islands;
    }

    public IslandModel getIsland(int index) {
        return this.islands.get(index);
    }

    public String getWorldName() {
        return this.worldName;
    }
}
