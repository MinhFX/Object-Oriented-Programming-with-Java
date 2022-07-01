public class Department {
    public String departmentId;
    public String departmentName;

    public Department(String departmentId, String departmentName) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Mỗi phần tử dùng toString() để hiển thị thông tin các bộ phận
    @Override
    public String toString() {
        return String.format("%-15s%-15s", departmentId, departmentName);
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
