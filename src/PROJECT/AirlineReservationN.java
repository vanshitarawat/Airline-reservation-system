package PROJECT;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AirlineReservationN {
	public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pre-populate user data
        users.put("Vanshita", "vanshita123");
        users.put("Shreya", "shreya123");
        users.put("Ishika", "ishika123");

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Welcome to XYZ Airlines!!!");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    login(scanner, users);
                    break;
                case 2:
                    signUp(scanner, users);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    private static void login(Scanner scanner, Map<String, String> users) {
        System.out.println("\nLogin:");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
		Scanner sc=new Scanner(System.in);
	
   
     	boolean[][] seats = new boolean[10][5];
     	String[][] customerinfoN = new String[45][10];
     	  String[] nationalFlights = {"Flight A", "Flight B", "Flight C"};
     	    double[] flightRates = {250.0, 300.0, 200.0};
     	    double[] departureTime = {12.00, 10.00, 11.45};
     	    double[] arrivalTime = {3.36, 2.30, 1.03};
     	    String[] internationalFlights = {"Flight D", "Flight E"};
     	    double[] flightRatesI = {1050.0, 1300.0};
     	    double[] departureTimeI = {5.45, 10.40};
     	    double[] arrivalTimeI = {7.00, 1.12};
     
 System.out.println("Select flight type:");
 System.out.println("1. National Flights");
 System.out.println("2. International Flights");
 System.out.print("Enter your choice (1 or 2): ");
 int flightType = sc.nextInt();

 System.out.println("From: ");
 String departure = sc.next();
sc.nextLine();
 System.out.println("To: ");
 String arrival = sc.next();
 sc.nextLine();
 System.out.println("Depart: ");
 String from = sc.next();
 sc.nextLine();
 System.out.println("Return: ");
 String returnn = sc.next();
 sc.nextLine();
 String[] bookedSeats = new String[50]; // Assuming a maximum of 50 booked seats
 int numBookedSeats = 0;

 if (flightType == 1) {
     // Show available national flights
     System.out.println("Available national flights:");
     System.out.println("---------------------------------------------------------------------------------------");
     System.out.printf("| %-10s| %-10s| %-20s| %-14s| %-16s|\n", "S.No","Flight", "Rate ($)", "Departure Time", "Arrival Time(IST)");
     System.out.println("---------------------------------------------------------------------------------------");
     for (int i = 0; i < nationalFlights.length; i++) {
         System.out.printf("| %-10d| %-10s| %-20.2f| %-14.2f| %-16.2f|\n", i+1,nationalFlights[i], flightRates[i], departureTime[i], arrivalTime[i]);
     }
     System.out.println("---------------------------------------------------------------------------------------");

     // Ask user to choose a flight
     System.out.println("Enter the flight number you want to book:");
     int selectedFlight = sc.nextInt();
     sc.nextLine();
     // Check if selected flight number is valid
     if (selectedFlight >= 1 && selectedFlight <= nationalFlights.length) {
         System.out.println("You selected: " + nationalFlights[selectedFlight - 1]);

         // Ask for confirmation to book a seat
         System.out.println("Do you want to book a seat for this flight?");
         System.out.println("1. Yes");
         System.out.println("2. No");
         int seatConfirmation = sc.nextInt();

         switch (seatConfirmation) {
             case 1:
             	
                 System.out.println("Enter the number of seats to book:");
                 int numSeats = sc.nextInt();
                 for (int seat = 0; seat < numSeats; seat++) {
                     
                     for (int i = 0; i < numSeats; i++) {
                    	 System.out.println("Enter customer information for Seat " + (i + 1) + ":");
                     System.out.print("Enter First Name: ");
                     String Fname= sc.next();
                     
                     System.out.print("Enter Last Name: ");
                     String Lname= sc.next();
                     
                     System.out.print("Enter Age: ");
                     String ageN= sc.next();
                     
                     System.out.print("Enter Gender: ");
                     String gender= sc.next();

                     System.out.print("Enter row number (1-10): ");
                     int row = sc.nextInt();
                     
                     System.out.print("Enter seat letter (A-E): ");
                     char seatLetter = sc.next().charAt(0);

                     int col = seatLetter - 'A';

                     if (row >= 1 && row <= 10 && col >= 0 && col < 5) {
                         if (!seats[row - 1][col]) {
                             seats[row - 1][col] = true;
                             System.out.println(ANSI_YELLOW+"Seat " + row + seatLetter + " is successfully booked for " + Fname  +Lname +"!!!"+ANSI_RESET);
                         }
                         
                         else {
                             System.out.println(ANSI_RED+"Seat " + row + seatLetter + " is already booked."+ANSI_RESET);
                         }
                     } else {
                         System.out.println(ANSI_RED+"Invalid seat selection. Please enter valid row and seat letter."+ANSI_RESET);
                     }
                     customerinfoN[i][0] = Fname;
                     customerinfoN[i][1] = Lname;
                     customerinfoN[i][2] = String.valueOf(ageN);
                     customerinfoN[i][3] = String.valueOf(gender);
                     customerinfoN[i][4] = String.valueOf(row);
                     customerinfoN[i][5] = String.valueOf(col);
                     customerinfoN[i][6] = String.valueOf(departure);
                     customerinfoN[i][7] = String.valueOf(arrival);
              
                     
                         // Prompt user to enter customer mobile number
                     
                          // Consume newline character
                         
                         
                        
                         
                         // Store customer information in the array
                        
                     }
                     System.out.println(ANSI_GREEN+"Congratulations! You have booked " + numSeats + " seat(s)."+ANSI_RESET);
                     sc.nextLine();

                 // Payment options
                 System.out.println("Select a payment option:");
                 System.out.println("1. Credit Card");
                 System.out.println("2. Debit Card");
                
                 int paymentOption = sc.nextInt();
                 switch (paymentOption) {
                     case 1:
                         System.out.println("You have selected Credit Card payment.");
                         // Add Credit Card payment logic here
                         System.out.println("Enter credit card number:");
                         
                         String creditCardNumber = sc.next();
                         
                         System.out.println("Name on the card:");
                         
                         String creditCardName = sc.next();
                         
                         
                        System.out.println("Expiration Date:");
                         
                         String creditCarddate= sc.next();
                         System.out.println("Enter cvv number:");
                         
                         String cvv = sc.next();
                         
                         System.out.print("Enter the amount to pay:$ ");
                         
                         String amountC= sc.next();
                         
                         System.out.println(ANSI_GREEN+"Credit Card payment of $"+amountC+" processed successfully."+ ANSI_RESET);
                         break;
                         // Process credit card payment
                         
                     case 2:
                         System.out.println("You have selected Debit Card payment.");
                         // Add Debit Card payment logic here
                         System.out.println("Enter debit card number:");
                         String debitCardNumber = sc.next();
                         
                         System.out.println("Expiration Date:");
                         
                         String debitCarddate= sc.next();
                         
                         System.out.println("Enter cvv number:");
                         
                         String cvvD = sc.next();
                         
                        System.out.println("Enter the amount to pay:$ ");
                         
                         String amount = sc.next();
                         // Process debit card payment
                        
                         System.out.println(ANSI_GREEN+"Debit Card payment of $ "+ amount+ "processed successfully."+ ANSI_RESET);
                         break;
                         
                     default:
                         System.out.println(ANSI_RED+"Invalid option."+ANSI_RESET);
                         break;
                 }
                 sc.nextLine();
                 
                 System.out.println("Customer Information:");
                 System.out.println("--------------------------------------------------------------------------------");
                 System.out.printf("| %-6s| %-10s| %-10s| %-5s| %-7s| %-5s| %-5s| %-8s| %-8s|\n", "S.No.", "First Name", "Last Name", "Age", "Gender", "Row", "Column", "Departure", "Arrival");
                 System.out.println("--------------------------------------------------------------------------------");

                 int serialNumber = 1;
                 for (int i = 0; i < numSeats; i++) {
                     System.out.printf("| %-6d| %-10s| %-10s| %-5s| %-7s| %-5s| %-5s| %-8s| %-8s|\n",
                             serialNumber++,
                             customerinfoN[i][0],  // First Name
                             customerinfoN[i][1],  // Last Name
                             customerinfoN[i][2],  // Age
                             customerinfoN[i][3],  // Gender
                             customerinfoN[i][4],  // Row
                             customerinfoN[i][5],  // Col
                             customerinfoN[i][6],  // Departure
                             customerinfoN[i][7]); // Arrival
                 }
                 System.out.println("-----------------------------------------------------------------------------------");
                 break; 
                      }
                 }
         }
 } else if (flightType == 2) {
	 String[][] customerinfo = new String[50][10];
     System.out.println("Available international flights:");
     System.out.println("---------------------------------------------------------------------------------------");
     System.out.printf("| %-10s| %-10s| %-20s| %-14s| %-16s|\n", "S.No","Flight", "Rate ($)", "Departure Time", "Arrival Time(IST)");
     System.out.println("---------------------------------------------------------------------------------------");
     for (int i = 0; i < internationalFlights.length; i++) {
         System.out.printf("| %-10d | %-10s| %-20.2f| %-14.2f| %-16.2f|\n",i+1, internationalFlights[i], flightRatesI[i], departureTimeI[i], arrivalTimeI[i]);
     }
     System.out.println("---------------------------------------------------------------------------------------");

     // Ask user to choose a flight
     System.out.println("Enter the flight number you want to book:");
     int selectedFlightI = sc.nextInt();

     // Check if selected flight number is valid
     if (selectedFlightI >= 1 && selectedFlightI <= internationalFlights.length) {
         System.out.println("You selected: " + internationalFlights[selectedFlightI - 1]);

         // Ask for confirmation to book a seat
         System.out.println("Do you want to book a seat for this flight?");
         System.out.println("1. Yes");
         System.out.println("2. No");
         int seatConfirmation = sc.nextInt();

         switch (seatConfirmation) {
             case 1:
                 // Seat booking process
                 System.out.println("Enter the number of seats to book:");
                 int numSeats = sc.nextInt();
                 for (int seat = 0; seat < numSeats; seat++) {
                     
                     
                     String[][] customerInfo = new String[numSeats][10];
                     for (int i = 0; i < numSeats; i++) {
                         System.out.println("Enter customer information for Seat " + (i + 1) + ":");
                     
                     System.out.print("Enter First Name: ");
                     String FnameI= sc.next();
                     
                     System.out.print("Enter Last Name: ");
                     String LnameI= sc.next();
                     
                     System.out.print("Enter Age: ");
                     String age= sc.next();
                     
                     System.out.print("Enter Gender: ");
                     String genderI= sc.next();

                     System.out.print("Enter row number (1-10): ");
                     int row = sc.nextInt();

                     System.out.print("Enter seat letter (A-E): ");
                     char seatLetter = sc.next().charAt(0);
                     
                     

                     int col = seatLetter - 'A';

                     if (row >= 1 && row <= 10 && col >= 0 && col < 5) {
                         if (!seats[row - 1][col]) {
                             seats[row - 1][col] = true;
                             System.out.println(ANSI_YELLOW+"Seat " + row + seatLetter + " is successfully booked for " + FnameI  +LnameI +"!!!"+ANSI_RESET);
                         }
                         
                         else {
                             System.out.println(ANSI_RED+"Seat " + row + seatLetter + " is already booked."+ANSI_RESET);
                         }
                     } else {
                         System.out.println(ANSI_RED+"Invalid seat selection. Please enter valid row and seat letter."+ANSI_RESET);
                     }
                     customerInfo[i][0] = FnameI;
                     customerInfo[i][1] = LnameI;
                     customerInfo[i][2] = String.valueOf(age);
                     customerInfo[i][3] = String.valueOf(genderI);
                     customerInfo[i][4] = String.valueOf(row);
                     customerInfo[i][5] = String.valueOf(col);
                     customerInfo[i][6] = String.valueOf(departure);
                     customerInfo[i][7] = String.valueOf(arrival);
 
                 }
                 
                 System.out.println(ANSI_GREEN+"Congratulations! You have booked " + numSeats + " seat(s)."+ANSI_RESET);
                 sc.nextLine();
                 
                 System.out.println("Select a payment option:");
                 System.out.println("1. Credit Card");
                 System.out.println("2. Debit Card");
                 
                 int paymentOption = sc.nextInt();
                

                 switch (paymentOption) {
                     case 1:
                    	 System.out.println("You have selected Credit Card payment.");
                         // Add Credit Card payment logic here
                         System.out.println("Enter credit card number:");
                         
                         String creditCardNumberI = sc.next();
                         
                         System.out.println("Name on the card:");
                         
                         String creditCardNameI = sc.next();
                         
                         
                        System.out.println("Expiration Date:");
                         
                         String creditCarddateI= sc.next();
                         System.out.println("Enter cvv number:");
                         
                         String cvvI = sc.next();
                         
                         System.out.print("Enter the amount to pay:$ ");
                         
                         String amountCI= sc.next();
                         
                         System.out.println(ANSI_GREEN+"Credit Card payment of $ "+amountCI+"processed successfully."+ ANSI_RESET);
                         break;
                
             case 2:
                 // User chose not to book a seat
            	 System.out.println("You have selected Debit Card payment.");
                 // Add Debit Card payment logic here
                 System.out.println("Enter debit card number:");
                 String debitCardNumber = sc.next();
                 
                 System.out.println("Expiration Date:");
                 
                 String debitCarddate= sc.next();
                 
                 System.out.println("Enter cvv number:");
                 
                 String cvvD = sc.next();
                 
                System.out.println("Enter the amount to pay:$ ");
                 
                 String amount = sc.next();
                 // Process debit card payment
                
                 System.out.println(ANSI_GREEN+"Debit Card payment of $ "+ amount+ "processed successfully."+ ANSI_RESET);
                 sc.nextLine();
                 break;
                 
                 default:
                     System.out.println(ANSI_RED+"Invalid payment option."+ANSI_RESET);
                     break;
                     
         }
                
                
                 System.out.println("Customer Information:");
                 System.out.println("--------------------------------------------------------------------------------");
                 System.out.printf("| %-6s| %-10s| %-10s| %-5s| %-7s| %-5s| %-5s| %-8s| %-8s|\n ", "S.No.","First Name", "Last Name", "Age", "Gender", "Row", "Column","Departure","Arrival");
                 System.out.println("--------------------------------------------------------------------------------");
               
                 int serialNumber = 1;
              for (int i = 0; i < customerInfo.length; i++) {
                  System.out.printf("| %-6d| %-10s| %-10s| %-5s| %-7s| %-5s| %-5s| %-8s| %-8s|\n", 
                		  serialNumber++,
                          customerInfo[i][0],  // First Name
                          customerInfo[i][1],  // Last Name
                          customerInfo[i][2],  // Age
                          customerInfo[i][3],  // Gender
                          customerInfo[i][4],  // Row
                          customerInfo[i][5],  // Col
                          customerInfo[i][6],  // Departure
                          customerInfo[i][7]); // Arriva
                 
                 }
              System.out.println("-----------------------------------------------------------------------------------");
                break; 
                 }
         }
         } else {
             System.out.println("Invalid username or password. Please try again.");
         }
     
     }
 
        }
        }
     private static void signUp(Scanner scanner, Map<String, String> users) {
         System.out.println("\nSign Up:");
         System.out.print("Enter a new username: ");
         String newUsername = scanner.nextLine();
         System.out.print("Enter a password: ");
         String newPassword = scanner.nextLine();

         if (users.containsKey(newUsername)) {
             System.out.println("Username already exists. Please choose a different username.");
         } else {
             users.put(newUsername, newPassword);
             System.out.println("Sign up successful! You can now log in.");
         }
     }
}
