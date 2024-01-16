package part03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static Collection<Commit> getCommits(String commitLog) {
        ArrayList<Commit> list = new ArrayList<Commit>();
        String username = "";
        String id = "";
        String parent = "";
        String text = "";

        String s = "";
        String idTest = "";
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        int alku = -1;
        int loppu = 0;

        for (var i = 0; i < commitLog.length(); i++) {

            if (i + 1 == commitLog.length()) {
                loppu = i;
                text = commitLog.substring(alku, loppu);
                flag3 = true;
            }

            if (flag4) {
                // find id
                idTest = commitLog.substring(alku + 7, alku + 13);
                if (idTest.length() == idTest.replaceAll("\\s", "").length()) {
                    id = idTest;
                }
                flag4 = false;
            }

            // find 'Commit'
            if (commitLog.charAt(i) == 'C') {
                s = commitLog.substring(i, i + 6);
                String x = commitLog.substring(i, i + 8);
                if (s.equals("Commit") && !x.equals("Commit -")) {
                    flag4 = true;

                    // get full commit text
                    if (alku == -1) {
                        alku = i;
                    } else {
                        loppu = i - 1;
                        text = commitLog.substring(alku, loppu);
                        flag3 = true;
                        alku = i;
                    }
                }
            }

            // find 'by'
            if (i + 2 < commitLog.length()) {
                s = commitLog.substring(i, i + 2);
            }
            if (s.equals("by")) {
                if (Character.isWhitespace(commitLog.charAt(i + 2))) {
                    flag = true;
                    i += 3;
                }
            }
            // iterate until whitespace for username
            if (flag && Character.isWhitespace(commitLog.charAt(i)) == true) {
                flag = false;
                flag2 = true;
            } else if (flag) {
                username += commitLog.charAt(i);
            }

            // find '(Parent: '
            if (flag2) {
                s = commitLog.substring(i + 1, i + 10);
                if (s.equals("(Parent: ")) {
                    i += 10;
                    s = commitLog.substring(i, i + 4);

                    // if None
                    if (s.equals("None")) {
                        parent = "None";
                    } else {
                        parent = commitLog.substring(i, i + 6);
                    }
                    flag2 = false;
                }
            }

            // if full text found
            if (flag3) {
                list.add(new Commit(username, id, parent, text));
                flag3 = false;
                username = "";
            }

        }
        return list;
    }

    public static void printByParent(Collection<Commit> commits) {
        ArrayList<Commit> place = new ArrayList<Commit>();
        boolean flag = false;
        String p = "";
        String id = "";
        ArrayList<String> arr = new ArrayList<String>();

        while (!flag) {

            for (Commit commit : commits) {
                p = commit.getParent();
                Set<String> ids = new HashSet<String>(arr);

                if (p.equals(id) && !ids.contains(commit.getId())) {
                    id = commit.getId();
                    arr.add(id);
                    place.add(commit);
                } else if (p.equals("None") && !ids.contains(commit.getId())) {
                    id = commit.getId();
                    arr.add(id);
                    place.add(commit);
                }
            }

            if (place.size() == commits.size()) {
                flag = true;
            }
        }

        for (Commit commit : place) {
            System.out.println(commit.getText());
        }

    }

    public static void main(String[] args) throws IOException {
        Path logFile = Path.of("pizza-commits.txt");
        String fileContents = Files.readString(logFile, StandardCharsets.UTF_8);

        Collection<Commit> n = getCommits(fileContents);
        printByParent(n);

        // `fileContents` variable should contain the contents of the pizza log file
        // as in the previous parts. You can check the contents by uncommenting the
        // following line:

        // System.out.println(fileContents);

    }
}
