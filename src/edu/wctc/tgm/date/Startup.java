/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.tgm.date;

import java.time.LocalDateTime;

/**
 *
 * @author tmorales3
 */
public class Startup {
    public static void main(String[] args) {
        DateUtilities du = new DateUtilities();
        
        LocalDateTime datea = du.toLocalDateTime("2014 02 14");
        LocalDateTime dateb = du.toLocalDateTime("2014 02 19");
        
        du.timeDifference(datea, dateb);
        
        du.toString(du.yearsAhead(datea, 50, 3, 5));
    }
  
}
