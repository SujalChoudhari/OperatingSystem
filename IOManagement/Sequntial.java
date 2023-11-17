package IOManagement;

import java.util.Random;
import java.util.Scanner;

public class Sequntial {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("FILE MANAGEMENT");

        System.out.println("Enter no of Files: ");
        int number = sc.nextInt();
        int[] memRequired = new int[number];
        int[] fileStart = new int[number];
        boolean[] flags = new boolean[100];

        System.out.println("Enter file sizes: ");
        for (int i = 0; i < number; i++) {
            memRequired[i] = sc.nextInt();
            flags[i] = false;
        }

        Random rd = new Random();


        for (int j = 0; j < number; j++) {
            int perfect_match = 0;
            while (perfect_match == 0) {
                int rdIndex = rd.nextInt(100);
                for (int i = 0; i < memRequired[j]; i++) {
                    if (flags[Math.min(99, rdIndex + i)] == true) {
                        perfect_match = 0;
                        break;
                    } else {
                        perfect_match = 1;
                    }
                }
                if (perfect_match == 1) {
                    for (int k = 0; k < memRequired[j]; k++) {
                        flags[rdIndex + k] = true;
                        break;
                    }
                    fileStart[j] = rdIndex;
                    break;
                }
            }

        }

        System.out.println("FILE NO | SIZE | START POINT |");
        for (int i = 0; i < number; i++) {
            System.out.printf("%7d | %4d | %11d |\n", i + 1, memRequired[i], fileStart[i]);
        }

    }
}
