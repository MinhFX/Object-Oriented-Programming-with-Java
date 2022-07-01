import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HumanResources {
    public static HashMap<String, Integer> departmentList = new HashMap<>();

    public static void main(String[] args) {
        List<Staff> staffsCompany =  new ArrayList<>();
        System.out.println("Chào mừng bạn đến với ứng dụng quản lý nguồn nhân lực!");

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("8. Kết thúc chương trình");
            System.out.print("Chức năng thực hiện: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> displayInformation(staffsCompany);
                case 2 -> displayDepartments(staffsCompany);
                case 3 -> {
                    System.out.print("Nhập mã bộ phận: ");
                    String searchId = input.nextLine();
                    displayStaffs(staffsCompany, searchId);
                }
                // Thêm nhân viên mới vào công ty
                case 4 -> {
                    System.out.print("1. Nhân viên\n2. Quản lý\nLoại nhân viên: ");
                    int level = input.nextInt();
                    input.nextLine();
                    System.out.print("Mã nhân viên: ");
                    String staffId = input.nextLine();
                    System.out.print("Tên nhân viên: ");
                    String staffName = input.nextLine();
                    System.out.print("Tuổi: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Hệ số lương: ");
                    int salaryCoefficient = input.nextInt();
                    input.nextLine();
                    System.out.print("Ngày vào làm (dd/MM/yyyy): ");
                    String date = input.nextLine();
                    LocalDate dateEmployment = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Số ngày nghỉ phép: ");
                    int numberLeaveDays = input.nextInt();
                    input.nextLine();
                    System.out.print("Mã bộ phận: ");
                    String departmentId = input.nextLine();
                    System.out.print("Tên bộ phận: ");
                    String departmentName = input.nextLine();
                    Department departmentWork = new Department(departmentId, departmentName);

                    // Mỗi phần tử dùng toString() để hiển thị thông tin các bộ phận
                    if (departmentList.containsKey(departmentWork.toString())) {
                        departmentList.put(departmentWork.toString(), departmentList.get(departmentWork.toString()) + 1);
                    } else {
                        departmentList.put(departmentWork.toString(), 1);
                    }

                    if (level == 1) {
                        System.out.print("Số tiếng làm thêm: ");
                        int overTimeHours = input.nextInt();
                        Employee employee = new Employee(staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays, overTimeHours);
                        staffsCompany.add(employee);
                    } else if (level == 2) {
                        System.out.print("Chức danh: ");
                        String title = input.nextLine();
                        Manager manager = new Manager(staffId, staffName, age, salaryCoefficient, dateEmployment, departmentWork, numberLeaveDays, title);
                        staffsCompany.add(manager);
                    }
                }
                case 5 -> {
                    System.out.print("Nhập tên nhân viên: ");
                    String searchName = input.nextLine();
                    displaySearch(staffsCompany, searchName);
                }
                // Hiển thị bảng lương của nhân viên toàn công ty (sắp xếp theo mức lương giảm dần)
                case 6 -> {
                    Collections.sort(staffsCompany);
                    displayPayroll(staffsCompany);
                }
                // Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
                case 7 -> {
                    staffsCompany.sort(Collections.reverseOrder());
                    displayPayroll(staffsCompany);
                }
                case 8 -> System.exit(0);
            }
        }
    }

    // Hiển thị danh sách nhân viên hiện có trong công ty
    public static void displayInformation(List<Staff> staffsCompany) {
        if (staffsCompany.size() == 0) {
            System.out.println("Không tìm thấy thông tin!");
        } else {
            System.out.printf("%-20s%-20s%-10s%-20s%-20s%-20s%-20s%-25s%-15s\n", "Mã nhân viên", "Tên nhân viên", "Tuổi", "Hệ số lương", "Ngày vào làm", "Mã bộ phận", "Tên bộ phận", "Số ngày nghỉ phép", "Chức danh");
            // Dùng vòng lặp duyệt qua mảng
            for (int i = 0; i < staffsCompany.size(); i++) {
                System.out.println(staffsCompany.get(i).toString());
            }
        }
    }

    // Hiển thị các bộ phận trong công ty
    public static void displayDepartments(List<Staff> staffsCompany) {
        if (staffsCompany.size() == 0) {
            System.out.println("Không tìm thấy thông tin!");
        } else {
            System.out.printf("%-20s%-20s%-25s\n", "Mã bộ phận", "Tên bộ phận", "Số lượng nhân viên");
            // Dùng vòng lặp duyệt qua mảng
            for (Map.Entry<String, Integer> entry : departmentList.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
        }
    }

    // Hiển thị các nhân viên theo từng bộ phận
    public static void displayStaffs(List<Staff> staffsCompany, String searchId) {
        List<Staff> staffsFound = new ArrayList<>();

        for (int i = 0; i < staffsCompany.size(); i++) {
            if (staffsCompany.get(i).getDepartmentWork().getDepartmentId().equalsIgnoreCase(searchId)) {
                staffsFound.add(staffsCompany.get(i));
            }
        }

        if (staffsFound.isEmpty()) {
            System.out.println("Không tìm thấy thông tin!");
        } else {
            System.out.printf("%-20s%-20s%-10s%-20s%-20s%-20s%-20s%-25s%-15s\n", "Mã nhân viên", "Tên nhân viên", "Tuổi", "Hệ số lương", "Ngày vào làm", "Mã bộ phận", "Tên bộ phận", "Số ngày nghỉ phép", "Chức danh");
            // Dùng vòng lặp duyệt qua mảng
            for (int i = 0; i < staffsCompany.size(); i++) {
                if (staffsCompany.get(i).getDepartmentWork().getDepartmentId().equalsIgnoreCase(searchId)) {
                    System.out.println(staffsCompany.get(i).toString());
                }
            }
        }
    }

    // Tìm kiếm thông tin nhân viên theo tên nhân viên
    public static void displaySearch(List<Staff> staffsCompany, String searchName) {
        List<Staff> staffsFound = new ArrayList<>();

        for (int i = 0; i < staffsCompany.size(); i++) {
            if (staffsCompany.get(i).getStaffName().equalsIgnoreCase(searchName)) {
                staffsFound.add(staffsCompany.get(i));
            }
        }

        // Dùng lệnh điều kiện để kiểm tra thông tin nhân viên có tồn tại hay không
        if (staffsFound.isEmpty()) {
            System.out.println("Không tìm thấy thông tin!");
        } else {
            System.out.printf("%-20s%-20s%-10s%-20s%-20s%-20s%-20s%-25s%-15s\n", "Mã nhân viên", "Tên nhân viên", "Tuổi", "Hệ số lương", "Ngày vào làm", "Mã bộ phận", "Tên bộ phận", "Số ngày nghỉ phép", "Chức danh");
            for (int i = 0; i < staffsCompany.size(); i++) {
                if (staffsCompany.get(i).getStaffName().equalsIgnoreCase(searchName)) {
                    System.out.println(staffsCompany.get(i).toString());
                }
            }
        }
    }

    // Mỗi phần tử dùng displayPayroll() để hiển thị thông tin bảng lương của nhân viên
    public static void displayPayroll(List<Staff> staffsCompany) {
        if (staffsCompany.size() == 0) {
            System.out.println("Không tìm thấy thông tin!");
        } else {
            System.out.printf("%-20s%-20s%-10s\n", "Mã nhân viên", "Tên nhân viên", "Lương");
            // Dùng vòng lặp duyệt qua mảng
            for (int i = 0; i < staffsCompany.size(); i++) {
                if (staffsCompany.get(i) instanceof Employee aStaff) {
                    System.out.printf("%-17s%-17s%-20s\n", aStaff.getStaffId(), aStaff.getStaffName(), (int) aStaff.calculateSalary());
                } else if (staffsCompany.get(i) instanceof Manager aStaff) {
                    System.out.printf("%-17s%-17s%-20s\n", aStaff.getStaffId(), aStaff.getStaffName(), (int) aStaff.calculateSalary());
                }
            }
        }
    }
}
