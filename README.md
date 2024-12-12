# FINAL-PROJECT---OBJECT-ORIENTED-PROGRAMMING
This reporitory is for my final project in Object Oriented Programming.

# I. Project Overview

<p align="justify">
  This project is a Veterinary Clinic Management System designed to manage pet appointments for dogs and cats. It allows users to book, view, and cancel appointments for their pets. The system helps veterinary clinics manage their schedules and ensures that animal owners can easily interact with the clinic.
</p>

# II. Explanation of how OOP principles were applied

## Abstraction
<p align="justify">
  The system uses an abstract class Animal, which represents all animals' common properties and behavior (e.g., name and type). The sound() method is abstract, meaning each specific animal (like Dog and Cat) must provide its implementation.
  The AppointmentManager interface provides an abstraction for the operations related to booking, viewing, and canceling appointments. This ensures that the specific actions related to appointments are implemented consistently
</p>

## Encapsulation
<p align="justify">
  The Animal and Appointment classes are designed with private fields and public getter and setter methods. This encapsulates the data, ensuring that these objects are manipulated only through the methods defined in the class.
	The Animal class encapsulates details like the name and type of the animal, while the Appointment class encapsulates the appointment details like the pet's name, date, time, and the issue being addressed.
</p>

## Inheritance
<p align="justify">
The Dog and Cat classes are derived from the Animal class. This allows them to inherit common properties such as the animal’s name and type while also implementing the specific sound() method to reflect the different sounds of a dog and a cat.
</p>

## Polymorphism
<p align="justify">
The sound() method is polymorphic, meaning it behaves differently depending on the type of animal. If the animal is a Dog, it returns "Woof! Woof!", while if it is a Cat, it returns "Meow! Meow!". This is achieved through method overriding.
	The use of the Appointment class with a reference to Animal allows polymorphism in the viewAppointments() method, where the system can handle different animals without knowing their specific type. 
</p>

# III. Details of the chosen SDG and its integration into the project
<p align="justify">

The Veterinary Clinic Appointment System supports SDG 15: Life on Land by promoting the health and well-being of land-based species, both domestic and wild. It facilitates the monitoring of animal health, including endangered species, through regular veterinary care, helping prevent disease outbreaks and aiding in wildlife rehabilitation efforts. By tracking appointments and health records, the system contributes to conservation programs by ensuring animals receive necessary treatment, promoting biodiversity, and supporting reintroduction initiatives. Additionally, it can raise awareness about the importance of protecting ecosystems and wildlife, aligning with SDG 15's focus on sustainable land use and biodiversity conservation.
</p>

# IV. Instructions for running the program
<p align="justify">

When you run the program, you’ll see a welcome message and a menu with several options to choose from:

**Menu Options**

The program provides the following menu options:

Book an Appointment
View All Appointments
Cancel an Appointment
Exit

You can enter the number corresponding to the option you want to select.

**1.  Booking an Appointment**

If you choose Option 1: Book an Appointment, the program will ask for the following details:

**A. Pet's Name**

The program will ask you to enter the name of your pet:
Enter Pet's name:
You will type in the name of your pet, for example: Max

**B. Animal Type (Dog or Cat)**

Next, you’ll be asked to specify whether your pet is a Dog or Cat:
Enter animal type (Dog, Cat):

For example, you could enter: Dog

**C. Owner's Name**

Then, the program will ask for your name (the pet owner):
Enter owner's name:
You could enter your name, for example: Anne Canales

**D. Appointment Date**

Next, the program will ask for the appointment date in the format YYYY-MM-DD:
Enter appointment date (YYYY-MM-DD):
You will enter a future date.

For example: 2024-12-05

The program will check if the date is valid and if it’s in the future. If the date entered is not valid or in the past, it will ask you to try again.

**E. Appointment Time**

Then, the program will ask you for the appointment time in the format HH: MM (hours and minutes):
Enter appointment time (HH: MM format):

For example: 10:30

The program will check if the time slot is already booked. If it’s already taken, it will ask you to pick another time.

**F. Issue/Concern**

Finally, the program will ask what issue or concern your pet is facing:
Enter issue/concern:

For example: Annual vaccination
Once all these details are provided, the program will confirm that the appointment has been successfully booked.

**2. Viewing All Appointments**

If you choose Option 2: View All Appointments, the program will display a list of all booked appointments. If there are no appointments, it will inform you with a message like: No appointments found.

If there are appointments, it will display the details, including the pet’s name, type, owner’s name, appointment date, time, and the pet's issue. Additionally, the program will play a sound for each animal based on its type. 

For example: Animal sound: Woof! Woof!   (if the animal is a dog)

**3. Cancelling an Appointment**

If you choose Option 3: Cancel an Appointment, the program will display all the existing appointments with numbers assigned to each. You’ll be asked to enter the appointment number of the appointment you wish to cancel.

For example:
Enter the number of the appointment to cancel:
If the appointment number is valid, it will be removed from the list. If the number is invalid, the program will ask you to try again.

**4. Exiting the Program**

If you choose Option 4: Exit, the program will stop, and you will see a farewell message:
Your pet's health is our priority! See you on your next visit!
</p>













