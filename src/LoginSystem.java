import java.io.Console;
import java.util.Scanner;

public class LoginSystem {
    // Hardcoded credentials (in real life, NEVER do this!)
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console(); // To handle masked password input
        int attempts = 0;
        boolean isLoggedIn = false;

        // Allow up to 3 attempts
        while (attempts < 3 && !isLoggedIn) {
            System.out.println("Login Attempt " + (attempts + 1) + " of 3");

            // Read username
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            String password;
            if (console != null) {
                // Read password with masking (*)
                char[] passwordChars = console.readPassword("Enter password: ");
                password = new String(passwordChars);
            } else {
                // Fallback (e.g., if running inside IDE)
                System.out.print("Enter password (masking unavailable): ");
                password = scanner.nextLine();
            }

            // Check credentials
            if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                System.out.println("\n✅ Login successful! Welcome, " + username + ".");
                isLoggedIn = true;
            } else {
                System.out.println("❌ Incorrect username or password. Try again.\n");
                attempts++;
            }
        }

        if (!isLoggedIn) {
            System.out.println("🚫 Access denied. You have used all 3 attempts.");
        }

        scanner.close();
    }
}
