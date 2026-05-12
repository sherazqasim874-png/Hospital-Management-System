import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Disease   : " + disease);
        System.out.println("-----------------------------");
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void display() {
        System.out.println("Doctor ID       : " + id);
        System.out.println("Doctor Name     : " + name);
        System.out.println("Specialization  : " + specialization);
        System.out.println("-----------------------------");
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public void display() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Doctor ID  : " + doctorId);
        System.out.println("Date       : " + date);
        System.out.println("-----------------------------");
    }
}

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Search Patient by ID");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    addDoctor();
                    break;

                case 4:
                    viewDoctors();
                    break;

                case 5:
                    bookAppointment();
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 7:
                    searchPatient();
                    break;

                case 8:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient Added Successfully!");
    }

    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No Patients Found!");
            return;
        }

        System.out.println("\n===== PATIENT LIST =====");

        for (Patient p : patients) {
            p.display();
        }
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));

        System.out.println("Doctor Added Successfully!");
    }

    static void viewDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No Doctors Found!");
            return;
        }

        System.out.println("\n===== DOCTOR LIST =====");

        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void bookAppointment() {

        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Add Patients and Doctors First!");
            return;
        }

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Appointment Date: ");
        String date = sc.nextLine();

        appointments.add(new Appointment(patientId, doctorId, date));

        System.out.println("Appointment Booked Successfully!");
    }

    static void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No Appointments Found!");
            return;
        }

        System.out.println("\n===== APPOINTMENT LIST =====");

        for (Appointment a : appointments) {
            a.display();
        }
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to Search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("\nPatient Found:");
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient Not Found!");
        }
    }
}
 
