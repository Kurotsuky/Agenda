package models;

public class Date 
{
    private int day;
    private int month;
    private int year;
    
    
    public Date() 
    {
        day = 0;
        month = 0;
        year = 0;
    }
    
    public Date(int day, int month, int year) 
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public Date(String day, String month, String year) 
    {
        this.day = Integer.parseInt(day);
        this.month = Integer.parseInt(month);
        this.year = Integer.parseInt(year);
    }
    
    public Date(int[] date) 
    {
        this(date[0], date[1], date[2]);
    }
    
    public Date(String[] date) 
    {
        this(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
    }
    
    
    public int[] get() 
    {
        return new int[] { day, month, year };
    }
    
    @Override
    public String toString() 
    {
        return day + "-" + month + "-" + year;
    }

    public Integer getDay() { return day; }
    public Integer getMonth() { return month; }
    public Integer getYear() { return year; }
}
