import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public void test() {
//        PriorityQueue<Customer> queue = new PriorityQueue<>(CustomerCompare);

        Customer customer1 = new Customer(2, "C");
        Customer customer2 = new Customer(4, "A");
        Customer customer3 = new Customer(3, "B");
//        queue.add(customer1);
    }

    class Customer {
        private int id;
        private String level;
        public Customer (int id, String level) {
            this.id = id;
            this.level = level;
        }

        public int getId() {
            return id;
        }
        public String getLevel() {
            return level;
        }
    }

    class CustomerCompare implements Comparator<Customer> {

        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getId() == o2.getId() ? o1.getLevel().compareTo(o2.getLevel()) : o1.getId() - o2.getId();
        }

    }

}
