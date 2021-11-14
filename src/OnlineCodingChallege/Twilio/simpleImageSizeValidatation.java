package OnlineCodingChallege.Twilio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shuhua Song
 */
public class simpleImageSizeValidatation {
    public static List<List<String>> imageSizeValid(List<List<String>> imageURLs, String maxSize){
         List<List<String>> results = new ArrayList<>();
         String maxNum = "", maxUnit = "";
         if(maxSize.equals("none")){
             maxNum = "1";
             maxUnit = "MB";
         }else{
             maxNum = maxSize.substring(0, maxSize.length()-2);
             maxUnit = maxSize.substring(maxSize.length()-2, maxSize.length());
         }
         int  numZero = 0;
         if(maxUnit.equals("KB")) {
             numZero = 3;
         }else if(maxUnit.equals("MB")){
             numZero = 6;
         }else if(maxUnit.equals("GB")){
             numZero = 9;
         }
         for(List<String> imageURL : imageURLs){
             List<String> currRes = new ArrayList<>();
             currRes.add(imageURL.get(0));
             String imageSize = imageURL.get(1);
             if(imageSize.length() < numZero){
                 currRes.add(1, "TRUE");
             }else{
                 String  imageNum = imageSize.substring(0, imageSize.length()-numZero) + "." +
                                    imageSize.substring(imageSize.length()-numZero);
                 double currSize = Double.parseDouble(imageNum);
                 double maxNumDigit = Double.parseDouble(maxNum);
                 if(currSize <= maxNumDigit){
                     currRes.add(1, "TRUE");
                 }else{
                     currRes.add(1, "FALSE");
                 }
             }
             results.add(currRes);
         }
         return results;
    }

    public static void main(String[] args) {
        List<List<String>> imageURLs = new ArrayList<>();
        List<String> url1 = new ArrayList<>();
        url1.add("www.google.com/search?q=image");
        url1.add("32000000");
        imageURLs.add(url1);
        String size = "40MB";

        List<List<String>> results = imageSizeValid(imageURLs, size);
        for(List<String> list : results){
            System.out.println(list.toString());
        }
    }
}
