class Solution {
    public int dayOfYear(String date) {
        // Extract year, month, and day from the YYYY-MM-DD string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        // Days in each month for a standard non-leap year
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Check if the current year is a leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonths[1] = 29;
        }
        
        // Sum up all the days of the fully completed months
        int dayCount = 0;
        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonths[i];
        }
        
        // Add the days of the current month
        dayCount += day;
        
        return dayCount;
    }
}
