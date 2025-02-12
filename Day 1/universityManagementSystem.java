import java.util.*;

// Abstract base class for course types
abstract class CourseType {
    private String name;

    public CourseType(String name) { this.name = name; }
    public String toString() { return name; }
}

// Specific course types
class ExamCourse extends CourseType { public ExamCourse() { super("Exam-Based"); } }
class AssignmentCourse extends CourseType { public AssignmentCourse() { super("Assignment-Based"); } }
class ResearchCourse extends CourseType { public ResearchCourse() { super("Research-Based"); } }

// Generic class to manage courses
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String toString() {
        return courseName + " (" + courseType + ")";
    }
}

// Utility class for dynamic course management
class CourseUtil {
    public static void displayCourses(List<? extends CourseType> courses) {
        courses.forEach(System.out::println);
    }
}

// Main class
public class universityManagementSystem {
    public static void main(String[] args) {
        // Create courses
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("History", new AssignmentCourse());
        Course<ResearchCourse> ai = new Course<>("Artificial Intelligence", new ResearchCourse());

        // Create a catalog
        List<Course<?>> catalog = new ArrayList<>();
        catalog.add(math);
        catalog.add(history);
        catalog.add(ai);

        // Display courses
        catalog.forEach(System.out::println);
    }
}
