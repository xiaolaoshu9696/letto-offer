package letto.offer.leetcode.bfs;

import java.util.*;

public class leetcode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }
    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans){
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        boolean isFound = false;
        path.add(beginWord);
        queue.offer(path);
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0 ;j<size;j++){
                List<String> p= queue.poll();
                //路径最后一个单词
                String temp = p.get(p.size()-1);
                List<String> nextWords = findword(temp, dict);
                for(String nextWord:nextWords){
                    if (!visited.contains(nextWord)){
                        if (nextWord.equals(endWord)){
                            isFound = true;
                            p.add(nextWord);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size()-1);
                        }
                        p.add(nextWord);
                        queue.offer(new ArrayList<>(p));
                        p.remove(p.size()-1);
                        subVisited.add(nextWord);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound){
                break;
            }
        }
    }


    private static List<String> findword(String word, Set<String> wordset){
        List<String> res = new ArrayList<String>();
        char[] w1 = word.toCharArray();
        for(String s:wordset){
            char[] w2 = s.toCharArray();
            int diifent = 0;
            for(int j = 0; j<w1.length; j++){
                if(w1[j]!=w2[j]) diifent++;
                if (diifent>=2) break;
            }
            if(diifent==1) res.add(String.valueOf(w2));
        }

        return res;

    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
