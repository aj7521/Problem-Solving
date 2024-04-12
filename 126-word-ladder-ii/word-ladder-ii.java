class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> levelMap = new HashMap<>();
        List<List<String>> results = new LinkedList<>();

        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (beginWord.equals(endWord) || !wordSet.contains(endWord))
            return results;

        queue.offer(beginWord);
        map.put(beginWord, new ArrayList<>());

        int min = Integer.MAX_VALUE;
        int level = 0;

        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            level++;
            for (int i = 0; i < levelCount; i++) {
                String curr = queue.poll();
                if (visited.contains(curr) || min < level)
                    continue;
                visited.add(curr);
                if (endWord.equals(curr)) {
                    min = level;
                    continue;
                }

                for (int j = 0; j < curr.length(); j++) {
                    char[] currArr = curr.toCharArray();
                    for (int k = 'a'; k <= 'z'; k++) {
                        currArr[j] = (char) k;
                        String newWord = new String(currArr);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)
                                && !(levelMap.getOrDefault(newWord, level) < level)) {
                            map.computeIfAbsent(newWord, key -> new ArrayList<>()).add(curr);
                            queue.offer(newWord);
                            levelMap.put(newWord, level);
                        }
                    }
                }

            }
        }

        List<String> curr = new LinkedList<>();
        curr.add(endWord);

        backtrack(endWord, beginWord, map, results, curr);

        return results;
    }

    private void backtrack(String end, String begin, Map<String, List<String>> map, List<List<String>> results,
            List<String> curr) {
        if (end.equals(begin)) {
            results.add(new ArrayList<>(curr));
            return;
        }

        for (String s : map.getOrDefault(end, new ArrayList<>())) {
            curr.addFirst(s);
            backtrack(s, begin, map, results, curr);
            curr.removeFirst();
        }
    }
}