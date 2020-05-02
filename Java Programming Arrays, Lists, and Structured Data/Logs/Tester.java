
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public static void main(String [] args) {
        LogAnalyzer l = new LogAnalyzer();
        l.readFile();
        l. iPsWithMostVisitsOnDay   ("Sep 29");
        // l.printAll();
        // l.countUniqueIPs();
        // l.uniqueIPVisitsOnDay("Sep 30");
        // l.countUniqueIPsInRange(300,399);
        // l.mostNumberVisitsByIP();
        // l.iPsMostVisits();
        // l.iPsForDays();
        // l.dayWithMostIPVisits();
        // l.iPsWithMostVisitsOnDay("Sep 30");
       
    }
}
