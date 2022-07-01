import java.time.LocalDate;

// Class Employee kế thừa được class Staff
public class Employee extends Staff implements ICalculator {
    public int overTimeHours;

    public Employee(String staffId, String staffName, int age, int salaryCoefficient, LocalDate dateEmployment, Department departmentWork, int numberLeaveDays, int overTimeHours) {
        super(staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays);
        this.overTimeHours = overTimeHours;
    }

    @Override
    public String toString() {
        return String.format("%-17s%-17s%-8s%-14s%-17s%-17s%-19s", staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays);
    }

    // Tính được đúng lương cho nhân viên
    @Override
    public double calculateSalary() {
        return salaryCoefficient * 3000000 + overTimeHours * 200000;
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
