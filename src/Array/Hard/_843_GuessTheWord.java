package Array.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Shuhua Song
 */
public class _843_GuessTheWord {
    interface Master {
      public int guess(String word);
    }
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for(String w : wordlist) list.add(w);

        Random rand = new Random();

        for(int i=0; i<10; i++){
            int idx = rand.nextInt(list.size());
            //System.out.println(idx);
            String guessWord = list.get(idx);
            int k = master.guess(guessWord);
            if(k==6) return;

            List<String> temp = new ArrayList<>();
            for(String w : list){
                if(w.equals(guessWord)) continue;
                if(similar(w, guessWord) == k){
                    temp.add(w);
                }
            }
            list = temp;
        }
    }

    private int similar(String a, String b){
        int count = 0;
        for(int i=0; i<6; i++){
            if(a.charAt(i)==b.charAt(i)){
                count++;
            }
        }
        return count;
    }
}

/*
Intuition
Take a word from wordlist and guess it.
Get the matches of this word
Update our wordlist and keep only the same matches to our guess.

This process is straight forward.
However, the key point is, which word should we guess from all of the wordlist?



Prepare
For example we guess "aaaaaa" and get matches x = 3,
we keep the words with exactly 3 a .

Also we need to know the matches between two words,
so a helper function match as following will be useful.
 */
