import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Step 1: Sort meetings by time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        // Step 2: Track people who know the secret
        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        int i = 0;
        int m = meetings.length;

        while (i < m) {
            int time = meetings[i][2];

            // Graph for same-time meetings
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleInThisTime = new HashSet<>();

            // Step 3: Collect all meetings at same time
            while (i < m && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                peopleInThisTime.add(x);
                peopleInThisTime.add(y);
                i++;
            }

            // Step 4: BFS only from people who already know secret
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int person : peopleInThisTime) {
                if (secret.contains(person)) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int nei : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        secret.add(nei);
                        queue.offer(nei);
                    }
                }
            }
        }

        return new ArrayList<>(secret);
    }
}
