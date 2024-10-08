import java.util.List;

public class Planets implements SpecialFeatures {
    private String planetName;
    private PlanetsType planetsType;
    private String numberOfMoons;
    private String distanceFromSun;
    private LifeExistence lifeExistence;
    private ResourceType resourceType;
    @Override
    public void Life_SupportingPlanet() {
        System.out.println("Hayat darad");
    }
    @Override
    public void Resource_RichPlanet(){
        System.out.println("Manabe darad");
    }
}
