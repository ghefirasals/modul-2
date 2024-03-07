import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    String nim;
    String major;

    public Student(String name, String nim, String major) {
        this.name = name;
        this.nim = nim;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", NIM: " + nim + ", Jurusan: " + major;
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Merci!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (option != 3);
    }

    private static void addStudent() {
        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");

        String nim;
        while (true) {
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLine();
            if (nim.length() == 15 && nim.matches("\\d+")) { // Check if NIM is 15 digits and only contains numbers
                break;
            } else {
                System.out.println("NIM Harus 15 Digit!");
            }
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        String major = scanner.nextLine();

        students.add(new Student(name, nim, major));
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }

    private static void displayStudents() {
        System.out.println("Data Mahasiswa:");
        System.out.println("Universitas Muhammadiyah Malang");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}