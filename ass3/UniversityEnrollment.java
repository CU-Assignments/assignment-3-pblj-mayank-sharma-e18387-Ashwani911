// Custom Exception for Course Full
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

// Custom Exception for Prerequisite Not Met
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private boolean isFull;
    private String prerequisite;

    // Constructor for Course
    public Course(String name, boolean isFull, String prerequisite) {
        this.name = name;
        this.isFull = isFull;
        this.prerequisite = prerequisite;
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return isFull;
    }

    public String getPrerequisite() {
        return prerequisite;
    }
}

class EnrollmentSystem {
    public void enroll(Course course, String completedPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        // Check if the course is full
        if (course.isFull()) {
            throw new CourseFullException("Error: " + course.getName() + " is full. Cannot enroll.");
        }

        // Check if the prerequisite is met
        if (completedPrerequisite == null || !completedPrerequisite.equals(course.getPrerequisite())) {
            throw new PrerequisiteNotMetException("Error: Complete " + course.getPrerequisite() + " before enrolling in " + course.getName() + ".");
        }

        // If no issues, enroll the student
        System.out.println("Successfully enrolled in " + course.getName() + "!");
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        // Create courses
        Course advancedJava = new Course("Advanced Java", false, "Core Java");
        Course dataScience = new Course("Data Science", true, "Python Basics");

        EnrollmentSystem system = new EnrollmentSystem();

        try {
            // Try to enroll in Advanced Java, with no prerequisite completed
            system.enroll(advancedJava, null);  // Prerequisite not met
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Try to enroll in Data Science, with "Python Basics" completed but course is full
            system.enroll(dataScience, "Python Basics");  // Course full
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
    }
}
