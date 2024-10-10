package com.dotin.camps03.finalExam;
public class Planets implements SpecialFeatures {
    String planetName;
    private PlanetsType planetsType;
    private String numberOfMoons;
    private String distanceFromSun;
    private LifeExistence lifeExistence;
    private ResourceType resourceType;
    public Planets(String planetName, PlanetsType planetsType, String numberOfMoons, String distanceFromSun, LifeExistence lifeExistence, ResourceType resourceType) {
        this.planetName = planetName;
        this.planetsType = planetsType;
        this.numberOfMoons = numberOfMoons;
        this.distanceFromSun = distanceFromSun;
        this.lifeExistence = lifeExistence;
        this.resourceType = resourceType;
    }
    public String getPlanetName() {        return planetName;    }
    public void setPlanetName(String planetName) {        this.planetName = planetName;    }
    public PlanetsType getPlanetsType() {        return planetsType;    }
    public void setPlanetsType(PlanetsType planetsType) {        this.planetsType = planetsType;    }
    public String getNumberOfMoons() {        return numberOfMoons;    }
    public void setNumberOfMoons(String numberOfMoons) {        this.numberOfMoons = numberOfMoons;    }
    public String getDistanceFromSun() {        return distanceFromSun;    }
    public void setDistanceFromSun(String distanceFromSun) {        this.distanceFromSun = distanceFromSun;    }
    public LifeExistence getLifeExistence() {        return lifeExistence;    }
    public void setLifeExistence(LifeExistence lifeExistence) {        this.lifeExistence = lifeExistence;    }
    public ResourceType getResourceType() {        return resourceType;    }
    public void setResourceType(ResourceType resourceType) {        this.resourceType = resourceType;    }
    @Override
    public void Life_SupportingPlanet() {
        System.out.println("Hayat darad");
    }
    @Override
    public void Resource_RichPlanet(){
        System.out.println("Manabe darad");
    }
    @Override
    public String toString() {
        return "Planet name = '" + planetName +
                "', Planets type = " + planetsType +
                ", Number of Moons = '" + numberOfMoons +
                "', Distance from the Sun = '" + distanceFromSun +
                "', Life existence = " + lifeExistence +
                ", Resource type = " + resourceType;
    }
}
