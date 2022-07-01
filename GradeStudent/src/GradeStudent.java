import java.util.Scanner;

public class GradeStudent {
    // Hàm main() điều khiển luồng chính của chương trình
    public static void main(String[] args) {
        begin();
        Scanner input = new Scanner(System.in);
        double weightMidterm = midterm(input);
        double weightFinal = finalterm(input);
        double weightHomework = homework(input);
        report(weightMidterm, weightFinal, weightHomework);
    }

    // Hàm begin() để hiển thị thông điệp chào mừng
    public static void begin() {
        System.out.println("This program reads exam/homework scores\nand reports your overall course grade.\n");
    }

    public static int totalWeight = 0;
    public static final int maxWeight = 100;

    // Hàm midterm() để nhập và tính toán điểm thi giữa kỳ
    public static double midterm(Scanner input) {
        System.out.println("Midterm:");
        System.out.print("Weight (0-100)? ");
        int weight = input.nextInt();
        totalWeight += weight;

        if (totalWeight >= maxWeight) {
            System.out.print("Error!");
            System.exit(0);
        }

        System.out.print("Score earned? ");
        int score = input.nextInt();
        System.out.print("Were scores shifted (1 = Yes, 2 = No)? ");
        int shift = input.nextInt();

        if (shift == 1) {
            System.out.print("Shift amount? ");
            int amount = input.nextInt();
            score = Math.min(score + amount, maxWeight);
        } else if (shift == 2) {
            score = Math.min(score, maxWeight);
        } else {
            System.out.print("Error!");
            System.exit(0);
        }

        System.out.println("Total points = " + score + " / " + maxWeight);
        double weightScore = (double) score / maxWeight * weight;
        System.out.printf("Weighted score = %.1f", weightScore);
        System.out.println(" / " + weight + "\n");
        return weightScore;
    }

    // Hàm finalterm() để nhập và tính toán điểm thi cuối kỳ
    public static double finalterm(Scanner input) {
        System.out.println("Final:");
        System.out.print("Weight (0-100)? ");
        int weight = input.nextInt();
        totalWeight += weight;

        if (totalWeight >= maxWeight) {
            System.out.print("Error!");
            System.exit(0);
        }

        System.out.print("Score earned? ");
        int score = input.nextInt();
        System.out.print("Were scores shifted (1 = Yes, 2 = No)? ");
        int shift = input.nextInt();

        if (shift == 1) {
            System.out.print("Shift amount? ");
            int amount = input.nextInt();
            score = Math.min(score + amount, maxWeight);
        } else if (shift == 2) {
            score = Math.min(score, maxWeight);
        } else {
            System.out.print("Error!");
            System.exit(0);
        }

        System.out.println("Total points = " + score + " / " + maxWeight);
        double weightScore = (double) score / maxWeight * weight;
        System.out.printf("Weighted score = %.1f", weightScore);
        System.out.println(" / " + weight + "\n");
        return weightScore;
    }

    // Hàm homework() để nhập và tính toán điểm bài tập về nhà
    public static double homework(Scanner input) {
        System.out.println("Homework:");
        System.out.print("Weight (0-100)? ");
        int weight = input.nextInt();
        totalWeight += weight;

        // Trọng số của 3 phần điểm thi phải có tổng chính xác là 100
        if (totalWeight != maxWeight) {
            System.out.print("Error! The sum of the three weights must be exactly 100.");
            System.exit(0);
        }

        System.out.print("Number of assignments? ");
        int numberAsm = input.nextInt();
        int totalPoints = 0;
        int totalAsmMax = 0;

        for (int i = 1; i <= numberAsm; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            int asmScore = input.nextInt();
            int asmMax = input.nextInt();
            totalPoints += asmScore;
            totalAsmMax += asmMax;
        }

        System.out.print("How many sections did you attend? ");
        int sectionAttend = input.nextInt();
        int sectionPoints = Math.min(sectionAttend * 5, 30); // Điểm tối đa của phần Attend là 30
        totalPoints += sectionPoints;
        int totalPointsMax = Math.min(totalAsmMax, 150) + 30; // Điểm tối đa của phần Assignment là 150
        totalPoints = Math.min(totalPoints, totalPointsMax);
        // Tính toán các đầu điểm
        System.out.println("Section points = " + sectionPoints + " / " + 30);
        System.out.println("Total points = " + totalPoints + " / " + totalPointsMax);
        double weightScore = (double) totalPoints / totalPointsMax * weight;
        System.out.printf("Weighted score = %.1f", weightScore);
        System.out.println(" / " + weight + "\n");
        return weightScore;
    }

    // Hàm report() để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng
    public static void report(double weightMidterm, double weightFinal, double weightHomework) {
        double GPA = weightMidterm + weightFinal + weightHomework;
        System.out.printf("Overall percentage = %.1f", GPA);
        System.out.print("\nYour grade will be at least: ");

        if (GPA >= 85) {
            System.out.print("3.0\n<< Perfect! >>");
        } else if (GPA >= 75) {
            System.out.print("2.0\n<< Great! >>");
        } else if (GPA >= 60) {
            System.out.print("0.7\n<< Cool! >>");
        } else {
            System.out.print("0.0\n<< Bad! >>");
        }
    }
}
