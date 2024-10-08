public class Planets implements SpecialFeatures {
    private String planetName;
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
        return "Planets{" +
                "planetName='" + planetName + '\'' +
                ", planetsType=" + planetsType +
                ", numberOfMoons='" + numberOfMoons + '\'' +
                ", distanceFromSun='" + distanceFromSun + '\'' +
                ", lifeExistence=" + lifeExistence +
                ", resourceType=" + resourceType +
                '}';
    }
}
