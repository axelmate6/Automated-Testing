import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Алексей Баранов", "601", 1, Map.of("Русский язык", 4, "Математика", 3, "Программировние", 5)));
        students.add(new Student("Владимир Гониев", "203", 3, Map.of("Русский язык", 4, "Математика", 4, "Программирование", 1)));
        students.add(new Student("Диана Ельская", "101", 2, Map.of("Русский язык", 5, "Химия", 5, "Физика", 5)));
        students.add(new Student("Жанна Зайцева", "601", 4, Map.of("Химия", 2, "Физика", 2, "Математика", 2)));
        students.add(new Student("Иван Ковалев", "203", 1, Map.of("Русский язык", 5, "Математика", 1, "Программирование", 1)));

        for (Student student : students) {
            student.getStudentInfo(student);
        }

        removeStudentsWithLowAverageGrade(students);

        promoteStudentsWithHighAverageGrade(students);

        printStudentsFromCourse(students,1);

        for (Student student : students) {
            student.getStudentInfo(student);
        }
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Смирнов","+132141244");
        phoneBook.add("Иванов","+898908900");
        phoneBook.add("Иванов","+981273981");
        phoneBook.add("Петров","+789164914");
        phoneBook.add("Иванов","+342424914");

        System.out.println(phoneBook.get("Иванов"));
    }

    public static void removeStudentsWithLowAverageGrade(Set<Student> students) {
        students.removeIf(student -> student.calculateAverageGrade() < 3);
    }

    public static void promoteStudentsWithHighAverageGrade(Set<Student> students) {
        for (Student student : students) {
            if (student.calculateAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudentsFromCourse(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}