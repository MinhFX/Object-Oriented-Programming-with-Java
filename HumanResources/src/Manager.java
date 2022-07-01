import java.time.LocalDate;

// Class Manager kế thừa được class Staff
public class Manager extends Staff implements ICalculator {
    public String title;

    public Manager(String staffId, String staffName, int age, int salaryCoefficient, LocalDate dateEmployment, Department departmentWork, int numberLeaveDays, String title) {
        super(staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays);
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%-17s%-17s%-8s%-14s%-17s%-17s%-19s%-25s", staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays, title);
    }

    // Tính được đúng lương cho quản lý
    @Override
    public double calculateSalary() {
        double salary = salaryCoefficient * 5000000;
        double responsibleSalary = 0;

        if (title.equalsIgnoreCase("Business Leader")) {
            responsibleSalary = 8000000;
        } else if (title.equalsIgnoreCase("Project Leader")) {
            responsibleSalary = 5000000;
        } else if (title.equalsIgnoreCase("Technical Leader")) {
            responsibleSalary = 6000000;
        }

        return salary + responsibleSalary;
    }

    @Override
    public int compareTo(Staff staff) {
        if (staff instanceof Manager aStaff) {
            Double staffSalary = aStaff.calculateSalary();
            return staffSalary.compareTo(this.calculateSalary());
        } else if (staff instanceof Employee aStaff) {
            Double staffSalary = aStaff.calculateSalary();
            return staffSalary.compareTo(this.calculateSalary());
        }

        return 0;
    }
}
