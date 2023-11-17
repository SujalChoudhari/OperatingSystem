import java.util.*;

class LRU {
    public static void main(String[] args) {
        int[] pagesDemand = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0 };
        int capacity = 6;

        LinkedList<Integer> pagingTable = new LinkedList<>();

        for (int page : pagesDemand) {
            if (pagingTable.contains(page)) {
                // If the page is already in the pagingTable, move it to the end to indicate it was most recently used.
                pagingTable.remove(Integer.valueOf(page));
                pagingTable.add(page);
                System.out.print("HIT!  ");
            } else {
                System.out.print("FAULT ");
                if (pagingTable.size() >= capacity) {
                    // If the pagingTable is full, remove the least recently used page.
                    pagingTable.removeFirst();
                }
                pagingTable.add(page);
            }
            System.out.print("(" + page + ") -> " + pagingTable);
            System.out.println();
        }
    }
}
