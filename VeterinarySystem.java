import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date; 
import java.util.Scanner; 

// Abstract class Animal demonstrating abstraction and encapsulation
abstract class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Encapsulation: Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Abstract method to demonstrate polymorphism
    public abstract String sound();
}

// Class Dog extending Animal (Polymorphism and Inheritance)
class Dog extends Animal {
    public Dog(String name) {
        super(name, "Dog");
    }
    @Override
    public String sound() {
        return "Woof! Woof!";
    }
}

// Class Cat extending Animal (Polymorphism and Inheritance)
class Cat extends Animal {
    public Cat(String name) {
        super(name, "Cat");
    }
    @Override
    public String sound() {
        return "Meow! Meow!";
    }
}

// Appointment class demonstrating encapsulation
class Appointment {
    private Animal animal;
    private String ownerName;
    private String appointmentDate;
    private String appointmentTime;
    private String issue;

    public Appointment(Animal animal, String ownerName, String appointmentDate, String appointmentTime, String issue) {
        this.animal = animal;
        this.ownerName = ownerName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.issue = issue;
    }

    // Encapsulation: Getters and Setters
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
    @Override
    public String toString() {
        return """
               Appointment Details:
               Pet's Name: """ + animal.getName() + "\n"
                + "Owner Name: " + ownerName + "\n"
                + "Animal Type: " + animal.getType() + "\n"
                + "Appointment Date: " + appointmentDate + "\n"
                + "Appointment Time: " + appointmentTime + "\n"
                + "Issue: " + issue + "\n";
    }
}

// Interface to handle scheduling and cancellation (Abstraction)
interface AppointmentManager {
    void bookAppointment();
    void viewAppointments();
    void cancelAppointment();
}

// Main class implementing AppointmentManager
public class VeterinaryClinicSystem implements AppointmentManager {

    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        VeterinaryClinicSystem system = new VeterinaryClinicSystem();
        System.out.println("===========================================================================");
        System.out.println("------------------------ Welcome to Fur Ever Care! ------------------------");
        System.out.println("===========================================================================");

        while (true) {
            System.out.println("\nPet Care Menu:\n");
            System.out.println("1. Book an Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel an Appointment");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> system.bookAppointment();
                case 2 -> system.viewAppointments();
                case 3 -> system.cancelAppointment();
                case 4 -> {
                    System.out.println("\nYour pet's health is our priority! See you on your next visit!");
                    return;
                }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
    @Override
    public void bookAppointment() {
        System.out.println("\n============================================================================");
        System.out.println("----------------------------- Book an Appointment --------------------------");
        System.out.println("============================================================================");
        System.out.print("\nEnter Pet's name: ");
        String animalName = scanner.nextLine();
        System.out.print("Enter animal type (Dog, Cat): ");
        String animalType = scanner.nextLine();
        System.out.print("Enter owner's name: ");
        String ownerName = scanner.nextLine();
        
        // Date validation loop
        String appointmentDate = "";
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Enter appointment date (YYYY-MM-DD): ");
            appointmentDate = scanner.nextLine();
            
            // Check if the date is in the future
            if (isValidDate(appointmentDate) && isFutureDate(appointmentDate)) {
                validDate = true;  // Exit loop if the date is valid and in the future
            } else {
                System.out.println("The selected date is either invalid or has already passed. Kindly enter a future date in YYYY-MM-DD format.");
            }
        }

        // Time validation
        String appointmentTime = "";
        boolean validTime = false;
        while (!validTime) {
            System.out.print("Enter appointment time (HH:MM format): ");
            appointmentTime = scanner.nextLine();
            
            // Check if the time is available
            if (isAvailableTime(appointmentDate, appointmentTime)) {
                validTime = true;
            } else {
                System.out.println("Time slot is already booked. Please choose another time.");
            }
        }

        System.out.print("Enter issue/concern: ");
        String issue = scanner.nextLine();

        Animal animal;
        if (animalType.equalsIgnoreCase("Dog")) {
            animal = new Dog(animalName);  // Polymorphism: creating a Dog object
        } else if (animalType.equalsIgnoreCase("Cat")) {
            animal = new Cat(animalName);  // Polymorphism: creating a Cat object
        } else {
            System.out.println("Invalid animal type! Please enter either 'Dog' or 'Cat'.");
            return;
        }

        appointments.add(new Appointment(animal, ownerName, appointmentDate, appointmentTime, issue));
        System.out.println("\nAppointment booked successfully!");
    }
    @Override
    public void viewAppointments() {
        System.out.println("\n============================================================================");
        System.out.println("--------------------------- View All Appointments --------------------------");
        System.out.println("============================================================================");
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println("\nAppointment " + (i + 1) + ":");
                System.out.println(appointments.get(i));
                // Polymorphism: calling the sound() method, which will behave differently depending on the animal type
                System.out.println("Animal sound: " + appointments.get(i).getAnimal().sound());
            }
        }
    }
    @Override
    public void cancelAppointment() {
        System.out.println("\n============================================================================");
        System.out.println("--------------------------- Cancel an Appointment --------------------------");
        System.out.println("============================================================================");
        if (appointments.isEmpty()) {
            System.out.println("\nNo appointments found.");
            return;
        }

        System.out.println("\nEnter the number of the appointment to cancel: ");
        viewAppointments();
        System.out.print("\nEnter appointment number: ");
        int appointmentNumber = scanner.nextInt();

        if (appointmentNumber <= 0 || appointmentNumber > appointments.size()) {
            System.out.println("\nInvalid appointment number. Try again.");
        } else {
            appointments.remove(appointmentNumber - 1);
            System.out.println("\nAppointment canceled successfully!");
        }
    }

    // isValidDate method defined here
    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);  // Disable lenient parsing
        try {
            sdf.parse(date);
            return true;  // Date is valid
        } catch (ParseException e) {
            return false;  // Invalid date format
        }
    }

    // Method to check if the date is in the future
    private boolean isFutureDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        try {
            Date appointmentDate = sdf.parse(date);
            return appointmentDate.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidTimeFormat(String time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);
        try {
            timeFormat.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    private boolean isAvailableTime(String date, String time) {
        // Validate time format
        if (!isValidTimeFormat(time)) {
            System.out.println("Invalid time format. Please use HH:MM.");
            return false;
        }
    
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentDate().equals(date) && appointment.getAppointmentTime().equals(time)) {
                return false;  // Time slot is already taken
            }
        }
        return true;  // Time slot is available
    }
    
}
