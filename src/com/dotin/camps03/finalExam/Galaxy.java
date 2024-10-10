package com.dotin.camps03.finalExam;
import java.util.List;
public class Galaxy {
    private String galaxyName;
    private List<Planets> planets;
    public Galaxy(String galaxyName, List<Planets> planets) {
        this.galaxyName = galaxyName;
        this.planets = planets;
    }
    public String getGalaxyName() {        return galaxyName;    }
    public void setGalaxyName(String galaxyName) {        this.galaxyName = galaxyName;    }
    public List<Planets> getPlanets() {        return planets;    }
    public void setPlanets(List<Planets> planets) {        this.planets = planets;    }
    @Override
    public String toString() {
        return "{Galaxy Name = '" + galaxyName + "', Planets = " + planets + '}';
    }
}
