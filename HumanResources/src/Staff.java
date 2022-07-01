import java.time.LocalDate;

// Cài đặt class Staff dạng abstract
public abstract class Staff implements Comparable<Staff> {
    public String staffId;
    public String staffName;
    public int age;
    public int salaryCoefficient;
    public LocalDate dateEmployment;
    public Department departmentWork;
    public int numberLeaveDays;

    public Staff(String staffId, String staffName, int age, int salaryCoefficient, LocalDate dateEmployment, Department departmentWork, int numberLeaveDays) {
        super();
        this.staffId = staffId;
        this.staffName = staffName;
        this.age = age;
        this.salaryCoefficient = salaryCoefficient;
        this.dateEmployment = dateEmployment;
        this.departmentWork = departmentWork;
        this.numberLeaveDays = numberLeaveDays;
    }

    // Cài đặt phương thức abstract hiển thị thông tin tương ứng
    public abstract String toString();

    public String getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public Department getDepartmentWork() {
        return departmentWork;
    }
}
