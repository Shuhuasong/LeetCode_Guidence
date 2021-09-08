package OnlineCodingChallege.JPmorgan;

import java.io.IOException;

/**
 * Created by Shuhua Song
 */

/*
You are given a number N and pattern. The pattern consists of lowercase latin letters
and one operation "+" or "-". The challege is to split the number and evaluate it
according to this pattern
eg.
 1232 ab+cd --> a:1, b:2, c:3, d:2 ---> 12 + 32 ----> 44
 case1: 3413289830   a-bcdefghij ----> -413289827
 case2: 776  a+bc ----> 83

 */
public class numberAndPatter {

    public static long numberPattern(long num, String pattern){
        String numSt = Long.toString(num);
        String[] strs = pattern.split("[+|-]");
        for(String s : strs){
            System.out.println(s);
        }

        int lenNums1 = strs[0].length();
        int lenNums2 = strs[1].length();
        long nums1 = Long.parseLong(numSt.substring(0, lenNums1));
        long nums2 = Long.parseLong(numSt.substring(lenNums1));
        System.out.println(nums1 + " " + nums2);
        long res = 0;
        if(pattern.charAt(lenNums1)=='-'){
            res =  (nums1-nums2);
        }else{
            res = (nums1+nums2);
        }
       return res;
    }

    public static void main(String[] args) throws IOException {

        long num = 3413289830L;
        String pattern = "a-bcdefghij";
        System.out.println(numberPattern(num, pattern));

       /* List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }

        System.out.println(list);
        scanner.close(); */

      /*  List<String> tokens = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st != null && st.hasMoreElements()) {
                tokens.add(st.nextToken());
            }

            System.out.println(tokens);
        }
        catch (IOException e) {
            System.out.println(e);
        }
         */

      /*   InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
         BufferedReader in = new BufferedReader(reader);
         String line = "";
         while((line = in.readLine()) != null){
             System.out.println(line);
         } */
      }
 }

