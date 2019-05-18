import java.util.*;

public class Main {

    public static void main(String[] args) {


        System.out.println(topKFrequent(new int[]{5,2,5,3,5,3,1,1,3},2));

    }


        public static List<Integer> topKFrequent(int[] nums, int k) {

            PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> (a - b) > 0 ? 1 : (a - b) < 0 ? -1 : 0 );

            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();

            for (int m : nums) {
                map.put(m, map.getOrDefault(m, 0) + 1 );
            }

            for (int i : map.values()) {
                pq.add(i);
                if (pq.size() > k) {
                    pq.remove();
                }
            }

            while (pq.size() != 0) {
                Integer v = pq.poll();
                int item = map.keySet()
                        .stream()
                        .filter(key -> v.equals(map.get(key)))
                        .findFirst()
                        .get();

                list.add(item);
                map.remove(item);

            }

            return list;

        }

}
