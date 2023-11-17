package DiskScheduling;

import java.util.Scanner;

public class FCFS {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter size ");
        int size = sc.nextInt();
        int[] tracks = new int[size];

        System.out.println("Enter tracks:");
        for (int i = 0; i < size; i++) {
            tracks[i] = sc.nextInt();
        }
        int iphead = 50;
        int seek_count = 0;
        System.out.println("Head: " + iphead);
        for (int k = 0; k < size; k++) {
            int dist = Math.abs(iphead - tracks[k]);
            seek_count += dist;
            iphead = tracks[k];
            System.out.println("Track: " + tracks[k] + "\n\t\tCurrent Seek Count:" + seek_count);

        }

        System.out.println("Total Seek Count:" + seek_count);

    }
}
