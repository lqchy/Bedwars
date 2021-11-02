package me.lachy.bedwars.map.models;

import java.util.Arrays;
import java.util.List;

public class IslandModel {

    private LocationModel pos1;
    private LocationModel pos2;
    private String faceDirection;
    private List<GeneratorModel> generators;
    private List<LocationModel.BedLocationModel> beds;
    private String woolColour;

    public LocationModel getPos1() {
        return this.pos1;
    }

    public LocationModel getPos2() {
        return this.pos2;
    }

    public String getFaceDirection() {
        return this.faceDirection;
    }

    public List<GeneratorModel> getGenerators() {
        return this.generators;
    }

    public List<LocationModel.BedLocationModel> getBeds() {
        return this.beds;
    }

    public String getWoolColour() {
        return this.woolColour;
    }

    @Override
    public String toString() {
        return "IslandModel{" +
                "pos1=" + pos1 +
                ", pos2=" + pos2 +
                ", faceDirection='" + faceDirection + '\'' +
                ", generators=" + Arrays.toString(generators.stream().map(GeneratorModel::toString).toArray()) +
                ", beds=" + Arrays.toString(beds.stream().map(LocationModel.BedLocationModel::toString).toArray()) +
                ", woolMaterial='" + woolColour + '\'' +
                '}';
    }
}
