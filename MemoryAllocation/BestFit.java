import java.util.Scanner;

class BestFit {

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
        int blocks = sc.nextInt();
        int blockSize[] = new int[blocks];
        int allocated[] = new int[blocks];

        System.out.println("Enter sizes of blocks:");
        for (int i = 0; i < blocks; i++) {
            blockSize[i] = sc.nextInt();
            allocated[i] = -1;
        }

        for (int i = 0; i < processes; i++) {
            int bestIndex = -1;
            for (int j = 0; j < blocks; j++) {
                if (blockSize[j] >= processSize[i] && (bestIndex == -1 || blockSize[j] - processSize[i] < blockSize[bestIndex] - processSize[i]) && allocated[j] == -1) {
                    bestIndex = j;
                }
            }
            if (bestIndex != -1) {
                blockAllocated[i] = bestIndex;
                allocated[bestIndex] = i;
            }
        }

        System.out.println("Process No | Process Size | Block No");
        for (int i = 0; i < processSize.length; i++) {
            if (blockAllocated[i] != -1)
                System.out.printf(" %10d| %12d| %8d\n", i + 1, processSize[i], blockAllocated[i] + 1);
            else
                System.out.printf(" %10d| %12d| %s\n", i + 1, processSize[i], "NOT ALLOCATED");
        }

    }
}
