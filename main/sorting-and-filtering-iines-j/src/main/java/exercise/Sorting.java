package exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.time.Instant;

import model.Post;
import model.User;

public class Sorting {

    /**
     * Returns a new List with the Post objects in the given list sorted by their
     * publishedAt date in ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param posts list of posts to sort
     * @return a new list of posts sorted by their published date in ascending order
     */
    public static List<Post> sortPostsByPublishedDate(List<Post> posts) {
        /*
         * The purpose of this exercise is to implement the sorting logic yourself.
         * Therefore, you are not allowed to use existing implementations of sorting
         * algorithms.
         *
         * Note that the `publishedAt` values can be compared by using the
         * alphabetical ordering of the string values. You can also convert the string
         * values to other data types, for example, to objects in the java.time package.
         */

        Post[] arr = posts.toArray(new Post[posts.size()]);

        // first sort, indexes at 0 and end of array
        quickSort(arr, 0, arr.length - 1);
        List<Post> list = Arrays.asList(arr);
        return list;
    }

    // followed Quicksort by Coding with John
    // https://www.youtube.com/watch?v=h8eyY7dIiN4
    private static void quickSort(Post[] arr, int low, int high) {
        // if subarray is only 1 element long
        if (low >= high) {
            return;
        }

        char[] pivot = arr[high].publishedAt().toCharArray();
        int left = low;
        int right = high;

        // until pointers meet
        while (left < right) {
            // while left pointer is equal or less than pivot & pointers haven't met
            while (Arrays.compare(arr[left].publishedAt().toCharArray(), pivot) <= 0 && left < right) {
                left++;
            }
            // while right pointer is equal or greater than pivot & pointers haven't met
            while (Arrays.compare(arr[right].publishedAt().toCharArray(), pivot) >= 0 && left < right) {
                right--;
            }
            // swapsies - then repeat
            swapsies(arr, left, right);
        }
        // once pointers meet, swap pivot with left pointer value
        swapsies(arr, left, high);
        // partitioned!

        // recursive sort, left
        quickSort(arr, low, left - 1);
        // recursive sort, right
        quickSort(arr, left + 1, high);
    }

    private static void swapsies(Post[] arr, int i1, int i2) {
        Post temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Returns a new list with the given users sorted by their registration date in
     * ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param users list of users to sort
     * @return a new list of users sorted by their registration date
     */
    public static List<User> sortUsersByRegistrationDate(List<User> users) {
        /*
         * Note that each User can have different data types for `registeredAt` field:
         * - numeric (seconds since epoch), for example "1632225600"
         * - string (ISO 8601), for example "2021-09-21T12:00:00Z"
         *
         * This time a simple alphabetical ordering of the string values is not enough.
         */

        ArrayList<User> list = new ArrayList<User>();
        ArrayList<User> sortList = new ArrayList<User>();

        for (User user : users) {

            String date = user.registeredAt();

            // epoch or ISO
            try {
                long epoch = Long.parseLong(date);
                Instant i = Instant.ofEpochSecond(epoch);
                date = i.toString();

                System.out.println(date + user.firstName());
            } catch (NumberFormatException e) {
            }

            list.add(new User(user.id(), user.firstName(), user.lastName(), user.username(), date));
        }

        list.sort(Comparator.comparing(o -> o.registeredAt()));

        for (int i = 0; i < list.size(); i++) {

            for (User user : users) {
                if (list.get(i).firstName() == user.firstName()) {
                    sortList.add(i, new User(user.id(), user.firstName(), user.lastName(), user.username(),
                            user.registeredAt()));
                    break;
                }
            }
        }

        return sortList;
    }

}
