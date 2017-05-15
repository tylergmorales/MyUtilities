/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.tgm.date;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * <P>
 * Change History:
 *
 * (C) 2017 - Tyler G. Morales
 *
 * This code is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <P>
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * @author Tyler G. Morales
 * (<a href="mailto:tyler.gmorales17@gmail.com">tylergmorales17@gmail.com</a>)
 * @version 1.00
 */
public class DateUtilities {
    
    /**
     * Accepts a LocalDateTime object and outputs a string according to dates properties
     */
    public void toString(LocalDateTime date){
        if(date != null)
        {
            System.out.println("The year is " + date.getYear());
            System.out.println("The month is " + date.getMonth());
            System.out.println("The day is " + date.getDayOfMonth());
        }
        else {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }
    /**
     * Accepts a certain format of String and outputs appropriate LocalDateTime object
     * @param s - A string to parse
     * @return LocalDateTime object that is according to what the string was
     */
    public LocalDateTime toLocalDateTime(String s){
        //string entered must be "yyyy mm dd"
        LocalDateTime date = LocalDateTime.now();
        if (s != null)
        {
            try {
                date = date.withYear(Integer.parseInt(s.substring(0, 4)));
                date = date.withMonth(Integer.parseInt(s.substring(5, 7)));
                date = date.withDayOfMonth(Integer.parseInt(s.substring(8, 10)));
                return date;
            } catch(Exception e) {
                System.out.println("String was entered incorrectly. Format must be 'yyyy mm dd'.");
                date = null;
            }
        } else {
            throw new IllegalArgumentException("String can't be null.");
        }
        return date;
        
    }
    /**
     * Accepts 2 LocalDateTime objects and returns hours
     * @param timea
     * @param timeb
     * @return double
     * The difference between the two LocalDateTime objects in hours and minutes
     * 
     */
    public double timeDifferenceHoursAndMinutes(LocalDateTime timea, LocalDateTime timeb) {
        if (timea != null || timeb != null){
            Duration diff = Duration.between(timea, timeb);
            //converts the duration object into a double representing hours and minutes
            return (diff.toHours() + (((Double.parseDouble((Long.toString(diff.getSeconds()))) % 3600) / 60) / 60));
            
        } else {
            throw new IllegalArgumentException("Times can't be null");
        }

    }
    /**
     * Accepts a long to calculate how many years ahead of todays date you want, and outputs the appropriate future LocalDateTime object 
     * @param timea - pass a starting time
     * @param yearsAhead - pass how many years ahead you want
     * @param monthsAhead - ""     ""    months     ""
     * @param daysAhead -   ""     ""    days       ""
     * @return appropriate LocalDateTime object in the future
     * @throws IllegalArgument exception if yearsAhead is less than 0
     */
    public LocalDateTime yearsAhead(LocalDateTime timea, long yearsAhead, long monthsAhead, long daysAhead) {
        if(timea != null || yearsAhead > 0)
        {
            LocalDateTime time = null;
            time = timea.plusYears(yearsAhead).plusMonths(monthsAhead).plusDays(daysAhead);
            return time;
        } else {
            throw new IllegalArgumentException("Arguments can not be null or less than 0");
        }

    }
    
    public LocalDateTime hoursAhead(LocalDateTime timea, double hours) {
        if(timea != null)
        {
            double calcHours = Math.floor(hours);
            double calcMin = 60 * (hours - (double)(Math.floor(hours)));
            LocalDateTime time = timea.plusHours((long) calcHours); 
            time = time.plusMinutes((long) calcMin);
            return time;
        } else {
            throw new IllegalArgumentException("Arguments can not be null or less than 0");
        }

    }
    
        public final double generateRandomDoubleBetween1And24(){
            
            double start = 1;
            double end = 24;
            double random = new Random().nextDouble();
            double results = start + (random * (end - start));
            return results;
        }
        
        
}
