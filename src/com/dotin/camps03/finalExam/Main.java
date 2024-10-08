package com.dotin.camps03.finalExam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galaxy galaxy = defineGalaxy(scanner);
        mainMenu(scanner, galaxy);
    }
    private static void mainMenu(Scanner scanner, Galaxy galaxy) {
        while (true){
            try{
                System.out.println("Welcome to Galaxy management system!\n" +
                        "1.Show Galaxys\n" +
                        "2.1 Add New Planet from File\n" +
                        "2.2 Add New Planet By User\n" +
                        "3.Change Number Of Planet's Moon\n" +
                        "4.Show Planet Info\n" +
                        "5.Save Data And Exit");
                String inputNum = scanner.nextLine();
                if(inputNum.trim().equals("")){
                    throw new Exception("Invalid number!");
                }
                switch (inputNum) {
                    case "1":
                        System.out.println(galaxy);
                        break;
                    case "2.1":
                        getPlanetFromFile(galaxy);
                        break;
                    case "2.2":
                        getPlanetFromUser(scanner, galaxy);
                        break;
                    case "3":
                        changeMoonCount(scanner, galaxy);
                        break;
                    case "4":
                        System.out.println(galaxy.getPlanets());
                        break;
                    case "5":
                        System.out.println("Data is saved successfully, By!");
                        saveData(galaxy);
                        return;
                    default:
                        System.out.println("invalid value!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
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
    private static Planets getPlanetFromFile(Galaxy galaxy) {
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
                        default:
                            System.out.println("invalid value!");
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
                        default:
                            System.out.println("invalid value!");
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
                        default:
                            System.out.println("invalid value!");
                    }
                    Planets planets = new Planets(planetName, planetsTypes, numberOfMoons, distanceFromSun, lifeExistences, resourceTypes);
                    galaxy.getPlanets().add(planets);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    private static void getPlanetFromUser(Scanner scanner, Galaxy galaxy) throws Exception {
        System.out.println("Enter Planet info: (ex: Earth-Rock-1-150-Yes-Water) ");
        String planetString = scanner.nextLine();
        String planetName = planetString.split("-")[0];
        String PlanetsType = planetString.split("-")[1];
        PlanetsType planetsTypes = null;
        switch (PlanetsType) {
            case "Rock":
                planetsTypes = planetsTypes.Rock;
                break;
            case "Gas":
                planetsTypes = planetsTypes.Gas;
                break;
            default:
                System.out.println("invalid value!");
        }
        String numberOfMoons = planetString.split("-")[2];
        String distanceFromSun = planetString.split("-")[3];
        String lifeExistence = planetString.split("-")[4];
        LifeExistence lifeExistences = null;
        switch (lifeExistence) {
            case "Yes":
                lifeExistences = lifeExistences.Yes;
                break;
            case "No":
                lifeExistences = lifeExistences.No;
                break;
            default:
                System.out.println("invalid value!");
        }
        String resourceType = planetString.split("-")[5];
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
            default:
                System.out.println("invalid value!");
        }
        for (Planets planets : galaxy.getPlanets()){
            if( !(planets.getPlanetName().equals(planetName)) ){
                planets = new Planets(planetName, planetsTypes, numberOfMoons, distanceFromSun, lifeExistences, resourceTypes);
                galaxy.getPlanets().add(planets);
                break;
            }else {
                throw new Exception("Planet with the name is already exists");
            }
        }
    }
    private static void changeMoonCount(Scanner scanner, Galaxy galaxy) {
        System.out.println("Enter Planet name: ");
        String plName = scanner.nextLine();
        Planets planets = getPlanetFromFile(galaxy);
        if (plName != "") {
            System.out.print("Enter new Moon number: ");
            String newMoons = scanner.nextLine();
            if (planets != null && planets.getPlanetName().equals(plName)) {
                planets.setNumberOfMoons(newMoons);
            }else {
                System.out.println("Planet not exist");
            }
        } else {
            System.out.println("Planet name Invalid!");
        }
    }
    private static void saveData(Galaxy galaxy) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dotin\\IdeaProjects\\h.karimpourJavaExam\\Galaxy.txt")) ){
            String exportData = "";
            for(Planets planets : galaxy.getPlanets()){
                String planetsString = planets.toString() + "\n";
                exportData += planetsString;
            }
            exportData = exportData.substring(0, exportData.length() - 1);
            writer.write(exportData);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
