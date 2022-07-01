import java.util.*;

public class LuckyNumber {
    // Hàm main() điều khiển luồng chính của chương trình
    public static void main(String[] args) {
        play();
    }

    // Tạo ra các biến để lưu các thông số
    public static int luckyNumber, guessNumber, guessCount, totalGames = 0, totalGuess = 0, bestGame = 0;
    public static double guessAvg;

    // Hàm play() để thực hiện trò chơi
    public static void play() {
        guessCount = 0;
        totalGames ++;
        // Dùng hàm random() để sinh ra số ngẫu nhiên
        Random lucky = new Random();
        final int max = 100;
        luckyNumber = lucky.nextInt(max + 1);
        // Kiểm tra độ chênh để đưa ra thông báo phù hợp cho người chơi
        System.out.printf("I'm thinking of a number between 0 and %d...\n", max);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Your guess? ");
            guessNumber = input.nextInt();
            guessCount ++;

            // Dùng lệnh if để kiểm tra xem số người dùng nhập vào có trùng với số lucky hay không
            if (guessNumber > luckyNumber) {
                System.out.println("It's lower.");
            } else if (guessNumber < luckyNumber) {
                System.out.println("It's higher.");
            } else {
                System.out.printf("You got it right in %d guesses!\n", guessCount);
                break;
            }
        }

        totalGuess += guessCount;
        guessAvg = (double) totalGuess / totalGames;

        if (totalGames == 1) {
            bestGame = guessCount;
        }

        if (bestGame > guessCount) {
            bestGame = guessCount;
        }

        System.out.print("Do you want to play again? ");
        String str = input.next();

        // Dùng lệnh do-while để thực hiện phần đưa ra các lượt chơi
        do {
            if (str.matches("y|Y|yes|YES|Yes")) {
                System.out.println();
                play();
            } else {
                System.out.println();
                report();
                System.exit(0);
            }
        } while (str.matches("y|Y|yes|YES|Yes"));
    }

    // Hàm report() để hiển thị báo cáo
    public static void report() {
        System.out.println("Overall results:");
        System.out.printf("Total games = %d\n", totalGames);
        System.out.printf("Total guesses = %d\n", totalGuess);
        System.out.printf("Guesses / game = %.1f\n", guessAvg);
        System.out.printf("Best game = %d", bestGame);
    }
}
