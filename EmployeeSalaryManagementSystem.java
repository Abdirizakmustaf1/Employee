package javaassigments;



class Employee {
    String employeeId;
    String name;
    String department;
    double basicSalary;

    Employee(String employeeId, String name, String department,
             double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    String getCategory() {
        return "Employee";
    }

    void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: " + getCategory());
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
        System.out.println();
    }
}

class FullTimeEmployee extends Employee {
    double allowance;

    FullTimeEmployee(String id, String name, String department,
                     double basicSalary, double allowance) {
        super(id, name, department, basicSalary);
        this.allowance = allowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    String getCategory() {
        return "Full-Time Employee";
    }
}

class PartTimeEmployee extends Employee {
    double hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String id, String name, String department,
                     double hoursWorked, double hourlyRate) {
        super(id, name, department, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    String getCategory() {
        return "Part-Time Employee";
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String id, String name, String department,
            double basicSalary, double bonus) {
        super(id, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    String getCategory() {
        return "Manager";
    }
}

public class EmployeeSalaryManagementSystem {
    public static void main(String[] args) {
        System.out.println("===== EMPLOYEE SALARY REPORT =====");
        System.out.println();

        Employee[] employees = {
                new FullTimeEmployee("EMP001", "Ahmed Ali",
                        "IT", 500, 150),
                new PartTimeEmployee("EMP002", "Fatima Hassan",
                        "HR", 20, 12),
                new Manager("EMP003", "Mohamed Omar",
                        "Management", 1000, 200)
        };

        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }
}
