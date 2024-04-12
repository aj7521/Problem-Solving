class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        if (!wordDict.contains(endWord)) return results;

        // Create a map to store the path from start to each node
        Map<String, ArrayList<String>> map = new HashMap<>();

        // Use a set to store the words of current level
        Set<String> currentLevel = new HashSet<>();

        // BFS to construct the path graph
        boolean found = false;
        currentLevel.add(beginWord);
        while (!currentLevel.isEmpty() && !found) {
            wordDict.removeAll(currentLevel); // Remove the used word in wordDict
            Set<String> nextLevel = new HashSet<>();
            for (String currentWord : currentLevel) {
                ArrayList<String> nextWords = getNextWords(currentWord, wordDict);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) found = true;
                    map.putIfAbsent(nextWord, new ArrayList<>());
                    map.get(nextWord).add(currentWord);
                    nextLevel.add(nextWord);
                }
            }
            currentLevel = nextLevel;
        }

        // Backtrack to construct paths
        if (found) backtrack(endWord, beginWord, map, new ArrayList<>(), results);

        return results;
    }

    private ArrayList<String> getNextWords(String word, Set<String> wordDict) {
        ArrayList<String> nextWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char originalChar = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (wordDict.contains(newWord)) nextWords.add(newWord);
            }
            sb.setCharAt(i, originalChar);
        }
        return nextWords;
    }

    private void backtrack(String word, String beginWord, Map<String, ArrayList<String>> map, ArrayList<String> temp, List<List<String>> results) {
        temp.add(0, word);
        if (word.equals(beginWord)) {
            results.add(new ArrayList<>(temp));
            temp.remove(0);
            return;
        }
        for (String next : map.get(word)) {
            backtrack(next, beginWord, map, temp, results);
        }
        temp.remove(0);
    }
}