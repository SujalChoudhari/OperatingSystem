class One {

    public static int[] available = { 2, 1, 1 };
    public static int[][] allocation = { { 1, 0, 1 }, { 2, 1, 2 }, { 3, 0, 0 }, { 1, 0, 1 } };
    public static int[][] max = { { 2, 1, 1 }, { 5, 4, 4 }, { 3, 1, 1 }, { 1, 1, 1 } };
    public static int[][] need = new int[4][3];

    public static void calculateNeed() {
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < available.length; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
                // System.out.print(need[i][j]);
            }
        }
    }

    public static void work() {
        // Make a Work Matrix (copy Available)
        int[] work = available;
        boolean[] finish = new boolean[max.length];
        for (int i = 0; i < finish.length; i++) {
            finish[i] = false;
        }

        // Find process such that the Need is <= Available
        int theChosenOne = -1;
        int counter = allocation.length;
        System.out.print( "Sequence: ");
        while (counter-- >= 0) {
            for (int i = 0; i < finish.length; i++) {
                if (finish[i] == false
                        && need[i][0] <= work[0]
                        && need[i][1] <= work[1]
                        && need[i][2] <= work[2]) {
                    // Found a valid process
                    for (int j = 0; j < work.length; j++) {
                        work[j] = work[j] + allocation[i][j];
                    }
                    finish[i] = true;
                    System.out.print( "P"+  i + " ");
                }
            }

            // didnt find any Process
            boolean isAllTrue = true;
            for (int k = 0; k < finish.length; k++) {
                if (finish[k] == false) {
                    isAllTrue = false;
                }
            }


            if(isAllTrue) {
                System.out.println("Safe State");
                return;
            }
        }
        System.out.println("\nNot Safe State");
        return ;

    }

    public static void main(String[] args) {

        // Calculate Need Matrix
        calculateNeed();

        work();

    }

}