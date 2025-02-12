import java.util.*;

// Policy class implementing Comparable for TreeSet sorting
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public Date getExpiryDate() { return expiryDate; }

    // toString method for displaying policy details
    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }

    // Equals and HashCode based on policyNumber (ensures uniqueness)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare by Expiry Date for TreeSet sorting
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

public class InsurancePolicyManager {
    public static void main(String[] args) {
        // Create policies
        Policy p1 = new Policy("P1001", "Alice", new Date(2025, 5, 10), "Health", 500.0);
        Policy p2 = new Policy("P1002", "Bob", new Date(2024, 8, 15), "Auto", 700.0);
        Policy p3 = new Policy("P1003", "Charlie", new Date(2026, 2, 20), "Home", 900.0);

        // HashSet - Fast Lookups
        Set<Policy> hashSet = new HashSet<>();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        System.out.println("HashSet (Unordered Policies): " + hashSet);

        // LinkedHashSet - Maintains Insertion Order
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(p1);
        linkedHashSet.add(p2);
        linkedHashSet.add(p3);
        System.out.println("LinkedHashSet (Insertion Order): " + linkedHashSet);

        // TreeSet - Sorted by Expiry Date
        Set<Policy> treeSet = new TreeSet<>();
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        System.out.println("TreeSet (Sorted by Expiry Date): " + treeSet);
    }
}
