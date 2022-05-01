package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _1360_NumberOfDaysBetweenTwoDates {
    private int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(numDaysFromNow(date1)-numDaysFromNow(date2));
    }

    private int numDaysFromNow(String date){
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        int res = day;
        for(int i=1971; i<year; i++){
            res += (isLeapYear(i) ? 366 : 365);
        }
        for(int m=0; m<month-1; m++){
            res += monthDays[m];
        }
        if(month>2 && isLeapYear(year))  res += 1;
        return res;
    }

    private boolean isLeapYear(int year){
        if(year%400==0 || year%100!=0 && year%4==0) return true;
        return false;
    }
}
