package part02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Contributors {

    /**
     * Returns the contributors from the given commit log. See the previous exercise
     * or the readme file for more information about the format of the commit log.
     *
     * The returned collection must not contain duplicates. The order of the
     * contributors in the returned collection is not important. If the given commit
     * log is empty, the method should return an empty collection.
     *
     * For example, for the commit log in the readme file, this method should return
     * the following usernames in any order:
     *
     * ["EagerElla", "LoopyLou", "NewbieNate", "ProgPete"]
     *
     * @param commitLog a multi-line string containing the log of commits
     * @return a collection of contributor usernames from the commit log
     */
    public static Collection<String> getContributors(String commitLog) {
        // Like in the previous exercise, you need to return an instance of some class
        // that implements the Collection interface. The choice is yours.

        ArrayList<String> list = new ArrayList<String>();

        String id = "";
        boolean flag = false;

        for (var i = 0; i < commitLog.length(); i++) {
            String s = "";

            if (i + 2 < commitLog.length()) {
                s = commitLog.substring(i, i + 2);
            }

            if (s.equals("by")) {
                if (Character.isWhitespace(commitLog.charAt(i + 2))) {
                    flag = true;
                    i += 3;
                }
            }

            if (flag && Character.isWhitespace(commitLog.charAt(i)) == true) {
                if (list.contains(id) == false) {
                    list.add(id);
                }
                id = "";
                flag = false;
            } else if (flag) {
                id += commitLog.charAt(i);
            }

        }

        return list;

    }

    /**
     * This method groups the commit ids by contributor. The format of the input is
     * the same as in the previous exercises. The output of this method is a map
     * where the keys are the usernames of the contributors in the log and the keys
     * are collections of commit ids that belong to the specific contributor.
     * The order of the usernames and ids in the returned map is not important.
     *
     * For example, for the commit log in the readme file, this method should return
     * a map containing the following usernames and ids in any order:
     *
     * {
     * "EagerElla": ["4f2a1d", "8h5k2y"],
     * "LoopyLou": ["e6c5b2", "j7i2k9"],
     * "NewbieNate": ["7b9f1e", "1d9g4z", "o1z6x9"],
     * "ProgPete": ["a3d8e7", "m3n5p8"]
     * }
     *
     * @param commitLog a multi-line string containing the log of commits
     * @return a map containing the commit ids grouped by contributor
     */
    public static Map<String, Collection<String>> groupCommitIdsByContributors(String commitLog) {
        Collection<String> names = getContributors(commitLog);
        Map<String, Collection<String>> m = new HashMap<String, Collection<String>>();

        String id = "";

        for (String name : names) {
            ArrayList<String> list = new ArrayList<String>();
            int x = commitLog.indexOf(name);

            id = commitLog.substring(x - 10, x - 4);
            list.add(id);

            while (x >= 0) {
                x = commitLog.indexOf(name, x + 1);
                if (x >= 0) {
                    id = commitLog.substring(x - 10, x - 4);
                    list.add(id);
                }
            }

            m.put(name, list);
        }

        return m;
    }

    public static void main(String[] args) {
        String commits = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by SpeedySamantha (Parent: r3f4g5)
                Reverted turbocharging
                Sleep(-1) actually did not turn back time
                """;

        System.out.println(groupCommitIdsByContributors(commits));
    }

}
