package javaassigments;



abstract class MedicalService {
    String serviceId;
    String serviceName;
    double baseCost;

    MedicalService(String serviceId, String serviceName,
                   double baseCost) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    abstract double calculateTotalCost();

    void displayServiceInfo() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost: $%.2f%n",
                calculateTotalCost());
        System.out.println();
    }
}

class Consultation extends MedicalService {
    double doctorFee;

    Consultation(String id, double baseCost, double doctorFee) {
        super(id, "Consultation", baseCost);
        this.doctorFee = doctorFee;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + doctorFee;
    }
}

class LaboratoryTest extends MedicalService {
    double testCharge;

    LaboratoryTest(String id, double baseCost, double testCharge) {
        super(id, "Laboratory Test", baseCost);
        this.testCharge = testCharge;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + testCharge;
    }
}

class Ultrasound extends MedicalService {
    double additionalFee;

    Ultrasound(String id, double baseCost, double additionalFee) {
        super(id, "Ultrasound", baseCost);
        this.additionalFee = additionalFee;
    }

    @Override
    double calculateTotalCost() {
        return baseCost + additionalFee;
    }
}

public class HospitalMedicalBillingSystem {
    public static void main(String[] args) {
        System.out.println("===== HOSPITAL BILLING SYSTEM =====");
        System.out.println();

        MedicalService[] services = {
                new Consultation("S001", 15, 10),
                new LaboratoryTest("S002", 10, 8),
                new Ultrasound("S003", 25, 15)
        };

        double totalBill = 0;

        for (MedicalService service : services) {
            service.displayServiceInfo();
            totalBill += service.calculateTotalCost();
        }

        System.out.println("------------------------------");
        System.out.printf("Total Hospital Bill: $%.2f%n", totalBill);
    }
}
