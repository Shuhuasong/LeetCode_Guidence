package OnlineCodingChallege.JPmorgan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
 1. Java String toLowerCase(), convert all character in a string into lower case
      String s1 = "JAVAPOINT Hello stRing";
      String newSt = s1.toLowerCase();
      //newSt = "javapoint hello string"

 2.
    String line = null;


 */
public class _CamelCaseSentence_ {
    //str = "OnetWOthrEe fouRfiVe SixseVEn"
    //str =  oneTwoThree  fourFive  sixSeven
    private static String convert(List<String> list){
        StringBuilder sb = new StringBuilder();
       for(int i=0; i<list.size(); i++) {
           String s = list.get(i).trim();
           if(!s.isEmpty()){
               char[] chs = s.toCharArray();
              // chs[0] = Character.toUpperCase(s.charAt(0));
               if(i==0 || list.get(i-1).equals(" ")){
                   chs[0] = Character.toLowerCase(s.charAt(0));
               }else{
                   chs[0] = Character.toUpperCase(s.charAt(0));
               }
               for(int j=1; j<chs.length; j++){
                   chs[j] = Character.toLowerCase(chs[j]);
               }
               sb.append(new String(chs));
           }else{
               sb.append(" ");
           }
       }
       return sb.toString();
    }

    public static void main(String[] args) throws IOException {
     /*
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String line = null;
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            list.add(line);
        }
         String str = "I get intern at geeksforgeeks";
        System.out.println(convert(str)); */

     /*   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = new ArrayList<>();
        String line = null, prev = null;
        while((line = br.readLine()) != null){
            if(line.trim().equals("")){
                input.add(" ");
            }else{
                input.add(line);
            }

        } */
        String str = "OnetWOthrEe fouRfiVe SixseVEn";
        String[] news = new String[]{"One", "tWO", "thrEe", " " , "fouR", "fiVe", " " ,"Six", "seVEn"};
        List<String> list = Arrays.asList(news);
        System.out.println(convert(list));
    }
}

/*
input 就是一堆line 每一个line都有一个string或者空的， input大小写其实不用在意。
output就是把这些line合成一个string， 如果line是空的话就加空格。 空格后面的首个字母都是小写 之后每一个line只要前面不是空格首字母就要大写，这个line剩下的字母都小写。 最后output的第一个字母永远小写

input ：
One
tWO
thrEe

fouR
fiVe

Six
seVEn

output:
oneTwoThree  fourFive  sixSeven

 */
