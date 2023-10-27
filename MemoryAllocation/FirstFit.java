import java.util.Scanner;
import java.util.Vector;

class FirstFit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Processes:");
        int processes = sc.nextInt();
        int processSize[] = new int[processes];
        int blockAllocated[] = new int[processes];

        System.out.println("Enter sizes of processes:");
        for (int i = 0; i < processes; i++) {
            processSize[i] = sc.nextInt();
            blockAllocated[i] = -1;
        }

        System.out.println("Enter the number of Blocks:");
        int blockes = sc.nextInt();
        int blockSize[] = new int[blockes];
        int allocated[] = new int[blockes];

        System.out.println("Enter sizes of blocks:");
        for (int i = 0; i < blockes; i++) {
            blockSize[i] = (sc.nextInt());
            allocated[i] = -1;
        }

        for (int i = 0; i < processSize.length; i++) {
            for (int j = 0; j < blockSize.length; j++) {
                if (processSize[i] < blockSize[j] && allocated[j] == -1) {
                    allocated[j] = i;
                    blockAllocated[i] = j;
                    break;
                }
            }
        }

        System.out.println("Process No | Process Size | Block No");
        for (int i = 0; i < blockAllocated.length; i++) {
            if (blockAllocated[i] != -1)
                System.out.printf(" %10d| %12d| %8d\n", i + 1, processSize[i], blockAllocated[i] + 1);
            else
                System.out.printf(" %10d| %12d| %s\n", i + 1, processSize[i], "NOT ALLOCATED");
        }

    }
}