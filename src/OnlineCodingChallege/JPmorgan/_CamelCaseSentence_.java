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
input ????????????line ?????????line????????????string??????????????? input??????????????????????????????
output???????????????line????????????string??? ??????line??????????????????????????? ??????????????????????????????????????? ???????????????line??????????????????????????????????????????????????????line??????????????????????????? ??????output??????????????????????????????

input ???
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
