
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int id;
    String name;
    List<String> courses;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }
}

public class CourseRegistrationSystem {
    static Map<String, Course> courses = new HashMap<>();
    static Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        // Adding sample courses to the database
        courses.put("CSE101", new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 50, "Mon/Wed 9-11am"));
        courses.put("ENG201", new Course("ENG201", "English Literature", "Study of literary works", 40, "Tue/Thu 1-3pm"));

        // Sample student
        Student student1 = new Student(1, "Naincy");

        // Sample student registerfor courses
        registerCourse(student1, "CSE101");
        registerCourse(student1, "ENG201");

        // Display available courses
        displayCourses();

        // Student dropping a course
        dropCourse(student1, "ENG201");
    }

    public static void registerCourse(Student student, String courseCode) {
        Course course = courses.get(courseCode);
        if (course != null && student.courses.size() < 5 && course.capacity > 0) {
            student.courses.add(courseCode);
            course.capacity--;
            System.out.println(student.name + " registered for course: " + course.title);
        } else {
            System.out.println("Registration unsuccessful. Course may be full or invalid.");
        }
    }

    public static void dropCourse(Student student, String courseCode) {
        if (student.courses.contains(courseCode)) {
            student.courses.remove(courseCode);
            courses.get(courseCode).capacity++;
            System.out.println(student.name + " dropped course: " + courses.get(courseCode).title);
        } else {
            System.out.println("Course not found in student's registered courses.");
        }
    }

    public static void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses.values()) {
            System.out.println("Course Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("----------------------------------");
        }
    }
}


