public class Main {
    public static void main(String[] args) {
        Plain list1 = new Plain();
        list1.access("A");
        list1.access("C");
        list1.access("B");
        list1.access("C");
        list1.access("D");
        list1.access("A");
        list1.access("D");
        list1.access("A");
        list1.access("C");
        list1.access("A");
        list1.access("C");
        list1.access("C");
        list1.access("E");
        list1.access("E");
        list1.printAll();

        System.out.println("Move to Front");
        MoveToFront list2 = new MoveToFront();
        list2.access("A");
        list2.printAll();
        list2.access("C");
        list2.printAll();
        list2.access("B");
        list2.printAll();
        list2.access("C");
        list2.printAll();
        list2.access("D");
        list2.printAll();
        list2.access("A");
        list2.printAll();
        list2.access("D");
        list2.printAll();
        list2.access("A");
        list2.printAll();
        list2.access("C");
        list2.printAll();
        list2.access("A");
        list2.printAll();
        list2.access("C");
        list2.printAll();
        list2.access("C");
        list2.printAll();
        list2.access("E");
        list2.printAll();
        list2.access("E");
        list2.printAll();

        System.out.println("Tranpose");
        Tranpose list3 = new Tranpose();
        list3.access("A");
        list3.printAll();
        list3.access("C");
        list3.printAll();
        list3.access("B");
        list3.printAll();
        list3.access("C");
        list3.printAll();
        list3.access("D");
        list3.printAll();
        list3.access("A");
        list3.printAll();
        list3.access("D");
        list3.printAll();
        list3.access("A");
        list3.printAll();
        list3.access("C");
        list3.printAll();
        list3.access("A");
        list3.printAll();
        list3.access("C");
        list3.printAll();
        list3.access("C");
        list3.printAll();
        list3.access("E");
        list3.printAll();
        list3.access("E");
        list3.printAll();
    }
}