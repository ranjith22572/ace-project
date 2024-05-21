import java.util.*;

// Parent class for Person
class Person {
    protected String name;
    protected String address;
    
    // Constructor
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}

// Student class inheriting from Person
class Student extends Person {
    private String studentId;
    private Map<String, Integer> courses = new HashMap<>();
    
    // Constructor
    public Student(String name, String address, String studentId) {
        super(name, address);
        this.studentId = studentId;
    }
    
    // Enroll student in a course
    public void enrollCourse(String course, int grade) {
        courses.put(course, grade);
    }
    
    // Update grade for a course
    public void updateGrade(String course, int grade) {
        if (courses.containsKey(course)) {
            courses.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }
    
    // Delete course enrollment
    public void deleteCourse(String course) {
        courses.remove(course);
    }
    
    // Get all enrolled courses
    public Map<String, Integer> getCourses() {
        return courses;
    }
}

// Teacher class inheriting from Person
class Teacher extends Person {
    private String teacherId;
    private String specialization;
    
    // Constructor
    public Teacher(String name, String address, String teacherId, String specialization) {
        super(name, address);
        this.teacherId = teacherId;
        this.specialization = specialization;
    }
    
    // Getters and Setters
    public String getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

// Course class
class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    
    // Constructor
    public Course(String courseId, String courseName, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
    }
    
    // Add student to course
    public void addStudent(Student student) {
        students.add(student);
    }
    
    // Remove student from course
    public void removeStudent(Student student) {
        students.remove(student);
    }
    
    // Get all students enrolled in course
    public List<Student> getStudents() {
        return students;
    }
}

// Main class
public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Creating teachers
        Teacher teacher1 = new Teacher("zakeer", "123 Main St", "T001", "Mathematics");
        Teacher teacher2 = new Teacher("vamshi", "456 Oak Ave", "T002", "English");
        
        // Creating students
        Student student1 = new Student("Ajay", "789 Elm St", "S001");
        Student student2 = new Student("Siddu", "101 Pine St", "S002");
        
        // Creating courses
        Course mathCourse = new Course("MATH101", "Mathematics", teacher1);
        Course englishCourse = new Course("ENG101", "English", teacher2);
        
        // Enrolling students in courses
        mathCourse.addStudent(student1);
        mathCourse.addStudent(student2);
        
        englishCourse.addStudent(student1);
        
        // Displaying enrolled students for each course
        System.out.println("Math Course Students:");
        for (Student student : mathCourse.getStudents()) {
            System.out.println(student.getName());
        }
        
        System.out.println("\nEnglish Course Students:");
        for (Student student : englishCourse.getStudents()) {
            System.out.println(student.getName());
        }
    }
}
