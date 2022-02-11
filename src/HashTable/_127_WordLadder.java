package HashTable;

/**
 * Created by Shuhua Song
 */
public class _127_WordLadder {


    /*  Time = O(M^2 * N),  O(M^2) = generate neighbors, N = number of words in wordList
        Space = O(M*N)
     //Sigle Direction trace the from beginWord to endWord
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord) || beginWord.equals(endWord)) return 0;
        //remove the word in the wordSet once we have seen this word
        wordSet.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 0;
        while(!q.isEmpty()){
            //get the sice to ensure traverse the entire level
            int size = q.size();
            steps++;
            for(int i=0; i<size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return steps;
                List<String> neighbors = getAllWords(word);
                for(String neig : neighbors){
                    if(wordSet.contains(neig)){
                        wordSet.remove(neig);
                        q.add(neig);
                    }
                }
            }
        }
        return 0;
    }

    //repeated string concatenation is expensive
    //to conver char array is more efficient
    private List<String> getAllWords(String w){
        List<String> results = new ArrayList<>();
        char[] chs = w.toCharArray();
        for(int i=0; i<chs.length; i++){
            char temp = chs[i];
            for(char c='a'; c<='z'; c++){
                if(chs[i]==c) continue;
                chs[i] = c;
                String word = new String(chs);
                results.add(word);
            }
            //change back
            chs[i] = temp;
        }
        return results;
    }
     */
}

/*
"hit"
"cog"
["hot","dot","dog","lot","log","cog"]

           dot--->dog
          /           \
hit-->hot               \
          \ lot-----------> log -----> cog

 */