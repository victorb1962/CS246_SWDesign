package nsalogin;

import java.util.Scanner;
import static nsalogin.NSALoginController.hashUserPassword;
import static nsalogin.NSALoginController.verifyPassword;
import static nsalogin.NSALoginController.verifyPasswordLen;

public class Test {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws WeakPasswordException {
        Test test = new Test();
        Boolean prompt = true;

        System.out.println("Enter a password: ");
        String inpPassword = test.scanner.nextLine();

        User user = new User(inpPassword);

        // Verify password is at least eight characters and at least one digit
        while (prompt) {
            prompt = false;

            try {
                verifyPasswordLen(user);

            } catch (WeakPasswordException e) {
                System.out.println(e.getMessage() + "\n");
                prompt = true;
                System.out.println("Enter a password: ");
                String tstPassword = test.scanner.nextLine();

                user.setPassword(tstPassword);
            }
        }

        System.out.println("Values BEFORE: Password: " + user.getPassword() +
                ", Salt: " + user.getSalt() + ", Hash: " + user.getHashedPassword());

            try {
                hashUserPassword(user);
                // Check password again to test the hash.
                System.out.println("Values AFTER:  Password: " + user.getPassword() +
                        ", Salt: " + user.getSalt() + ", Hash: " + user.getHashedPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("Enter a password: ");
        String testPassword = test.scanner.nextLine();
        user.setPassword(testPassword);

        try {
            if (verifyPassword(user)) {
                System.out.println("Correct Password");
            } else {
                System.out.println("Password mis-match, Try Again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
