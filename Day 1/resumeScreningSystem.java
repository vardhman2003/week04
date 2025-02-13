import java.util.*;

// Abstract base class for job roles
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) { this.roleName = roleName; }
    public String toString() { return roleName; }
}

// Specific job roles
class SoftwareEngineer extends JobRole { public SoftwareEngineer() { super("Software Engineer"); } }
class DataScientist extends JobRole { public DataScientist() { super("Data Scientist"); } }
class ProductManager extends JobRole { public ProductManager() { super("Product Manager"); } }

// Generic class to process resumes for specific roles
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public T getJobRole() { return jobRole; }
    public String toString() { return candidateName + " applying for " + jobRole; }
}

// Utility class for resume screening
class ResumeScreeningUtil {
    public static <T extends JobRole> boolean isEligible(Resume<T> resume) {
        // Simple validation (extendable for real-world logic)
        return resume.getJobRole() != null && !resume.toString().isEmpty();
    }

    public static void displayResumes(List<? extends JobRole> roles) {
        roles.forEach(System.out::println);
    }
}

// Main class
public class resumeScreningSystem {
    public static void main(String[] args) {
        // Create resumes for different roles
        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager());

        // Validate resumes
        System.out.println("Eligibility Check:");
        System.out.println(seResume + " - " + ResumeScreeningUtil.isEligible(seResume));
        System.out.println(dsResume + " - " + ResumeScreeningUtil.isEligible(dsResume));
        System.out.println(pmResume + " - " + ResumeScreeningUtil.isEligible(pmResume));

        // Create a pipeline of job roles
        List<JobRole> pipeline = Arrays.asList(
            seResume.getJobRole(),
            dsResume.getJobRole(),
            pmResume.getJobRole()
        );

        // Display job roles in the pipeline
        System.out.println("\nJob Roles in Screening Pipeline:");
        ResumeScreeningUtil.displayResumes(pipeline);
    }
}
