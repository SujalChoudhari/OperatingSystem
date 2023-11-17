import java.util.LinkedList;

class FIFO {
    public static void main(String[] args) {
        int[] pagesDemand = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0 };

        LinkedList<Integer> pagingTable = new LinkedList<Integer>();

        for (int page : pagesDemand) {

            // Check if in table
            boolean hit = false;
            for (int i = 0; i < pagingTable.size(); i++) {
                if (pagingTable.contains(page)) {
                    System.out.print("HIT!  ");
                    hit = true;
                    break;
                }
            }

            if (!hit) {
                System.out.print("FAULT ");
                if (!pagingTable.isEmpty() && pagingTable.size() >= 3)
                    pagingTable.removeFirst();
                pagingTable.add(page);
            }

            System.out.print("(" + page + ") -> " + pagingTable);
            System.out.println();

        }
    }
}