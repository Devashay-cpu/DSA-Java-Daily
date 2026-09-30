import java.util.*;

class LC514_FreedomTrail {

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();

        Map<Character, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(ring.charAt(i),
                    k -> new ArrayList<>()).add(i);
        }

        Map<String, Integer> memo = new HashMap<>();

        return solve(ring, key, 0, 0, positions, memo);
    }

    private int solve(String ring, String key, int index, int current,
                      Map<Character, List<Integer>> positions,
                      Map<String, Integer> memo) {

        if (index == key.length()) {
            return 0;
        }

        String state = index + "," + current;

        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        int n = ring.length();
        int answer = Integer.MAX_VALUE;

        for (int next : positions.get(key.charAt(index))) {

            int distance = Math.abs(next - current);

            int rotate = Math.min(distance, n - distance);

            int steps = rotate + 1
                    + solve(ring, key, index + 1, next, positions, memo);

            answer = Math.min(answer, steps);
        }

        memo.put(state, answer);

        return answer;
    }
}