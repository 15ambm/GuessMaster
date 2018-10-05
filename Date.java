package MainPackage;
import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; //a four digit number.

    public Date( )
    {//this parentheses can be put in the above line.
        month = "January";
        day = 1;
        year = 1000;
    }

    public Date(String string) //compares the format of the input date to the required format and converts it to a string
    							// if it adheres to one of the format options
    {
    	
		if (string.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {//compares to 11/11/1111 format
			String month = string.substring(0, 2);
			String day = string.substring(3, 5);
			String year = string.substring(6, 10);
			int iday = Integer.parseInt(day);
			int imonth = Integer.parseInt(month);
			int iyear = Integer.parseInt(year);
			setDate(imonth,iday,iyear);
		} else if (string.matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) {//another compare, but for 1/11/1111 format
			String month = string.substring(0, 1);
			String day = string.substring(2, 4);
			String year = string.substring(5, 9);
			int iday = Integer.parseInt(day);
			int imonth = Integer.parseInt(month);
			int iyear = Integer.parseInt(year);
			setDate(imonth,iday,iyear);
		} else if (string.matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) {//compares to 11/1/1111 format
			String month = string.substring(0, 2);
			String day = string.substring(3, 4);
			String year = string.substring(5, 9);
			int iday = Integer.parseInt(day);
			int imonth = Integer.parseInt(month);
			int iyear = Integer.parseInt(year);
			Date date = new Date(imonth,iday,iyear);
			setDate(imonth,iday,iyear);
		} else if (string.matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) {//finally, compares to 1/1/1111 format
			String month = string.substring(0, 1);
			String day = string.substring(2, 3);
			String year = string.substring(4, 8);
			int iday = Integer.parseInt(day);
			int imonth = Integer.parseInt(month);
			int iyear = Integer.parseInt(year);
			Date date = new Date(imonth,iday,iyear);
			setDate(imonth,iday,iyear);
		} 	   	
    }
    
    
    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public Date(int year)
    {
        setDate(1, 1, year);
    }
    

    //copy constructor
    public Date(Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             //System.out.println("Fatal Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        } else { //added this to stop program from crashing due to null date
        		// this happened in the case where the input matched the format but was out of the bounds of
        		// the dateOK method. i.e. 13/32/1999 would produce a null date
        	this.month = monthString(99);
            this.day = 99;
            this.year = 99;
            System.out.println("Bad Input");
        }
        
        
    }

    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            //System.out.println("Fatal Error");
            //System.exit(0);
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            //System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            //System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            //System.out.println("Fatal Error");
            this.day = 99;
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
        	
            return 99; //Needed to keep the compiler happy
        }
    }

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
        //value will be shown when debugging
        //a very useful feature for dubugging
        //also useful in println(), which
        //automatically call toString();
    }

    public boolean equals(Date otherDate)
    {
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }	

    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
           // System.out.println("Fatal Error");
            //System.exit(0);
            return "Bad Month"; //to keep the compiler happy
        }
    }
}
