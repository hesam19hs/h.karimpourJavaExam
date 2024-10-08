import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galaxy galaxy = defineGalaxy(scanner);

    }

    private static Galaxy defineGalaxy(Scanner scanner) {
        while (true){
            try{
                System.out.println("Enter Galaxy name: ");
                String glxyName = scanner.nextLine();
                if(glxyName.trim().equals("")){
                    throw new Exception("Invalid name");
                }
                Galaxy galaxy = new Galaxy(glxyName);
                return galaxy;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
