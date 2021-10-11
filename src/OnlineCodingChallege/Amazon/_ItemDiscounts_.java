package OnlineCodingChallege.Amazon;

import java.util.*;

/**
 * Created by Shuhua Song
 */
/*
There are three type of discount tags:
type-0: no discount, use original price
type-1: price = price-price*discount
type-2: price = price - discount

for example:
products = { {price, tag1, tag2, .........}, {....
discounts = { {tag, type, discount}

products = { {"10", "d0", "d1"},
             {"20", "d1", "EMPTY",
              {"15", "EMPTY", "EMPTY"} }
discounts = { {"d0", "1", "27"},
              {"d1", "2", "5" }

item1: price1 = 10
  d0 --> with discount type 1 : newPrice1 = price1 - price1 * 0.27 = 10 - 2.7 = 7.3 = 7
  d1 --> with discount type 2 : newPrice2 = price1 - 5 = 10 - 5 = 5
  the price to purchase the product is the lowest price from these two is 5
item2 : price2 = 20
  d1 ---> with discount type 2 : newPrice1 = price2 - 5 = 20 - 5 = 15
item3 : price3 = 15
   no any discount
        price = 15
 results = 5 + 15 + 15 = 35

 */
public class _ItemDiscounts_ {

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts){
        Map<String, Integer> idToType = new HashMap<>();
        Map<Integer, Integer> typeToDist = new HashMap<>();
        for(List<String>  disc : discounts){
            String distType = disc.get(0);
            int type = Integer.parseInt(disc.get(1));
            int discount = Integer.parseInt(disc.get(2));
            idToType.put(distType, type);
            typeToDist.put(type, discount);
        }
        int result = 0;
        for(List<String> p : products){
            int oriPrice = Integer.parseInt(p.get(0));
            int lowestPrice = oriPrice;
            for(int i=1; i<p.size(); i++){
                String tag = p.get(i);
                int newPrice = (int)calculateDiscount(oriPrice, tag, idToType, typeToDist);
                lowestPrice = Math.min(lowestPrice, newPrice);
            }
            result += lowestPrice;
        }
        return result;
    }

    public static double calculateDiscount(int oriPrice, String tag, Map<String, Integer> idToType,
                                                                     Map<Integer, Integer> typeToDist){
           if(tag.equals("EMPTY")) return oriPrice;
           double newPrice = 0;
           if(idToType.containsKey(tag)){
               int type = idToType.get(tag);
               if(type==1){
                   newPrice = oriPrice - oriPrice * typeToDist.get(type) * 0.001;
               }else if(type==2){
                   newPrice = oriPrice - typeToDist.get(type);
               }else{
                   newPrice = oriPrice;
               }
           }
           return newPrice;
    }

    public static void main(String[] args) {
        List<List<String>> products = new ArrayList<>();
        List<List<String>> discounts = new ArrayList<>();
        List<String> list1 = Arrays.asList(new String[]{"10", "d0", "d1"});
        List<String> list2 = Arrays.asList(new String[]{"15", "EMPTY", "EMPTY"});
        List<String> list3 = Arrays.asList(new String[]{"20", "d1", "EMPTY"});
        products.add(list1); products.add(list2);
        products.add(list3);

        List<String> list5 = Arrays.asList(new String[]{"d0", "1", "27"});
        List<String> list6 = Arrays.asList(new String[]{"d1", "2", "5"});
        discounts.add(list5); discounts.add(list6);

        int res = findLowestPrice(products, discounts);
        System.out.println("result = " + res);
    }
}
