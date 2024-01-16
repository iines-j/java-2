package part03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class PostalCodesMain {

    /**
     * Implement your logic in this method. You can also add your own methods and
     * classes if needed.
     *
     * Your program should handle displaying postal codes and postal district names
     * in both directions. For example, if the user enters "00100", the program
     * should print "Helsinki". If the user enters "Helsinki" as their input, the
     * program should print "00100" along with all other postal codes for
     * Helsinki.
     *
     * The program should not handle partial matches. For example, if the user
     * enters "001", the program should not display any results. However, the
     * program should be case-insensitive. For example, the program should display
     * "00100" whether the user enters "helsinki" or "HELSINKI".
     */
    public static void main(String[] args) {
        /*
         * This map contains data that is read from the JSON file. You don't need to
         * inspect the file handling in this exercise, but you can if you want to.
         *
         * The keys in the map are postal codes and the values are postal district
         * names.
         */
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Mitä etsitään (esim. 00100 tai Helsinki)? ");
        String answer = scanner.nextLine(); // answer may be a postal code or a postal district name
        scanner.close();

        if (answer != null && answer.matches("[0-9.]+")) {
            boolean flag = false;
            String toim = "";

            for (Map.Entry<String, String> entry : postalCodes.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(answer)) {
                    toim = entry.getValue();
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Toimipaikka: " + toim);
            } else {
                System.out.println("Postinumeroa ei löytynyt.");
            }

        } else {
            ArrayList<String> nrot = new ArrayList<String>();
            for (Map.Entry<String, String> entry : postalCodes.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(answer)) {
                    nrot.add(entry.getKey());
                }
            }

            if (nrot.isEmpty() == true) {
                System.out.println("Postinumeroita ei löytynyt.");
            } else {
                Collections.sort(nrot);
                String joined = String.join(", ", nrot);
                System.out.println("Postinumerot: " + joined);
            }

        }
    }

}
