public class Exercise24_03 {
    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();
        list.add("America");
        list.add(0, "Canada");
        list.add("Russia");
        list.add("France");
        list.add(2, "Germany");
        list.add(5, "Norway");
        list.add(0, "Poland");

        System.out.println(list);

        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);

        System.out.println(list);

        java.util.ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
    }
}