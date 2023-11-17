package DiskScheduling;

import java.util.LinkedList;
import java.util.Scanner;

public class SSTF {
    static Scanner sc = new Scanner(System.in);

    static int getSSTF(LinkedList<Integer> tracks, int search) {
        int min_dist = Integer.MAX_VALUE;
        int min_value = 0;
        for (int i = 0; i < tracks.size(); i++) {
            int temp = Math.abs(search - tracks.get(i));
            if (temp < min_dist) {
                min_dist = temp;
                min_value = tracks.get(i);
            }
        }
        if (!tracks.isEmpty())
            tracks.remove(tracks.indexOf(min_value));
        return min_value;
    }

    public static void main(String[] args) {
        System.out.println("Enter size ");
        int size = sc.nextInt();
        LinkedList<Integer> tracks = new LinkedList<Integer>();

        System.out.println("Enter tracks:");
        for (int i = 0; i < size; i++) {
            tracks.add(sc.nextInt());
        }
        int iphead = 50;
        System.out.println("Head: " + iphead);
        int seek_count = 0;

        tracks.add(iphead);
        int next_track = getSSTF(tracks, iphead);
        for (int k = 0; k < size; k++) {

            next_track = getSSTF(tracks, next_track);

            int dist = Math.abs(iphead - next_track);
            seek_count += dist;
            iphead = next_track;
            System.out.println("Track: " + next_track + "\n\t\tCurrent Seek Count:" + seek_count);

        }

        System.out.println("Total Seek Count:" + seek_count);

    }
}
