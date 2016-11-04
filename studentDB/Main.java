package studentDB;
import java.io.*;
import java.util.*;

public class Main {

    private  static final String FILE_NAME = "C:\\Users\\rameojfanner\\Desktop\\Lab13\\src\\studentDB\\StudentInfoDatabase.ser";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> listOfStudents = new ArrayList<>();

        FileOutputStream fOS;
        ObjectOutputStream oOS;
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        int choice;
        try {

            File fin = new File(FILE_NAME);
            if(fin.length() == 0){

            }else {
                fIS = new FileInputStream(fin);
                oIS = new ObjectInputStream(fIS);
                listOfStudents = (List<Student>) oIS.readObject();
                oIS.close();
                fIS.close();
            }
            do {
                System.out.println("STUDENT INFORMATION SYSTEM");
                System.out.println("\t1. Register a Student.\n\t2. Retrieve Student Information.\n\t3. Delete a Student.\n\t4. Edit a Student.\n\t5. Save.\n\t6. Display.\n\t7. Exit.\n");
                System.out.println("Press the number of your choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String studentNum = sc.nextLine();

                    if (!checkStudentNum(listOfStudents, studentNum)) {
                        System.out.print("Enter first name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter middle initial: ");
                        String in = sc.nextLine();
                        char initial;
                        if (in.equals("")) {
                            initial = 32;
                        } else {
                            initial = in.charAt(0);
                        }
                        System.out.print("Enter last name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter program/course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter year level: ");
                        int yearLevel = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter crush name: ");
                        String crushName = sc.nextLine();
                        System.out.print("Enter fave course code: ");
                        String courseCode = sc.nextLine();
                        System.out.print("Enter fave course Description: ");
                        String courseDescription = sc.nextLine();
                        Course faveSubject = new Course(courseCode, courseDescription);
                        Student student = new Student(studentNum, firstName, initial, lastName, course, yearLevel, crushName, faveSubject);
                        listOfStudents.add(student);
                        System.out.println("OUTPUT ADDED!");
                        System.out.print(student);

                    } else if (checkStudentNum(listOfStudents, studentNum)) {
                        System.out.println("Student already exists!");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            System.out.print(listOfStudents.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 3) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            listOfStudents.remove(i);
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 4) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            System.out.println(listOfStudents.get(i));
                            System.out.print("Set first name to: ");
                            listOfStudents.get(i).setFirstName(sc.nextLine());
                            System.out.print("Set middle initial to: ");
                            listOfStudents.get(i).setMiddleInitial(sc.nextLine().charAt(0));
                            System.out.print("Set last name to: ");
                            listOfStudents.get(i).setLastName(sc.nextLine());
                            System.out.print("Set course: ");
                            listOfStudents.get(i).setCourse(sc.nextLine());
                            System.out.print("Set year level: ");
                            listOfStudents.get(i).setYearLevel(sc.nextInt());
                            System.out.print("Set crushNAme: ");
                            listOfStudents.get(i).setCrushName(sc.nextLine());
                            System.out.print("Set favorite Course code: ");
                            listOfStudents.get(i).setCourseCode(sc.nextLine());
                            System.out.print("Set favorite Course description: ");
                            listOfStudents.get(i).setCourseDescription(sc.nextLine());
                            System.out.println("Updated information:\n" + listOfStudents.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 5) {

                        File fout = new File(FILE_NAME);
                        fOS = new FileOutputStream(fout);
                        oOS = new ObjectOutputStream(fOS);
                        oOS.writeObject(listOfStudents);
                        oOS.close();

                } else if (choice == 6) {
                      listOfStudents.forEach(System.out::print);
                }
                } while (choice != 7);
                        System.out.println("Goodbye! (っ◕‿◕)っ");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean checkStudentNum(List<Student> a, String student){
        for(int x = 0; x < a.size(); x++) {
            if (student.equals(a.get(x).getStudentNumber())) {
                return true;
            }
        }
        return false;
    }
}
