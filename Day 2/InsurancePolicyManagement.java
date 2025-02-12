import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("[%s: %s, Expiry: %s, %s, Premium: %.2f]", policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> insertionOrderMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> expiryDateMap = new TreeMap<>();

    // Add policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        expiryDateMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by policy number
    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        List<InsurancePolicy> result = new ArrayList<>();

        expiryDateMap.subMap(today, next30Days).values().forEach(result::addAll);
        return result;
    }

    // List policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        expiryDateMap.headMap(today, false).clear();
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        insertionOrderMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.now().plusDays(20), "Auto", 700.0));
        system.addPolicy(new InsurancePolicy("P1003", "Alice", LocalDate.now().minusDays(5), "Home", 1000.0));

        System.out.println("Policy by Number (P1002): " + system.getPolicy("P1002"));
        System.out.println("Policies Expiring in Next 30 Days: " + system.getExpiringPolicies());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("After Removing Expired Policies, All Policies: " + system.policyMap.values());
    }
}
