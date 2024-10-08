import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galaxy galaxy = defineGalaxy(scanner);
        getGalaxyFromFile(galaxy);


        System.out.println(galaxy);
        System.out.println(galaxy.getPlanets());





    }




    private static void getGalaxyFromFile(Galaxy galaxy) {
        File galaxyFile = new File("C:\\Users\\Dotin\\IdeaProjects\\h.karimpourJavaExam\\Galaxy.txt");
        try{
            try (Scanner s1 = new Scanner(galaxyFile)) {
                while (s1.hasNextLine()) {
                    String planStr = s1.nextLine();
                    String planetName = planStr.split("#")[0];
                    String PlanetsType = planStr.split("#")[1];
                    PlanetsType planetsTypes = null;
                    switch (PlanetsType) {
                        case "Rock":
                            planetsTypes = planetsTypes.Rock;
                            break;
                        case "Gas":
                            planetsTypes = planetsTypes.Gas;
                            break;
                    }
                    String numberOfMoons = planStr.split("#")[2];
                    String distanceFromSun = planStr.split("#")[3];
                    String lifeExistence = planStr.split("#")[4];
                    LifeExistence lifeExistences = null;
                    switch (lifeExistence) {
                        case "Yes":
                            lifeExistences = lifeExistences.Yes;
                            break;
                        case "No":
                            lifeExistences = lifeExistences.No;
                            break;
                    }
                    String resourceType = planStr.split("#")[5];
                    ResourceType resourceTypes = null;
                    switch (resourceType) {
                        case "Water":
                            resourceTypes = resourceTypes.Water;
                            break;
                        case "Gold":
                            resourceTypes = resourceTypes.Gold;
                            break;
                        case "Iron":
                            resourceTypes = resourceTypes.Iron;
                            break;
                    }
                    Planets planets = new Planets(planetName, planetsTypes, numberOfMoons, distanceFromSun, lifeExistences, resourceTypes);
                    galaxy.getPlanets().add(planets);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Galaxy defineGalaxy(Scanner scanner) {
        while (true){
            try{
                System.out.println("Enter Galaxy name: ");
                String glxyName = scanner.nextLine();
                if(glxyName.trim().equals("")){
                    throw new Exception("Invalid name");
                }
                List<Planets> planets = new ArrayList<>();
                Galaxy galaxy = new Galaxy(glxyName, planets);
                return galaxy;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
