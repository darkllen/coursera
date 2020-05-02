
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList();
     }
        
     public void readFile() {
         FileResource f = new FileResource();
         for (String l: f.lines()) records.add(WebLogParser.parseEntry(l));
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public void countUniqueIPs(){
         HashSet<String> set = new HashSet();
         for (LogEntry le : records) {
             set.add(le.getIpAddress());
         }        
         System.out.println(set.size());
        }
        
     public void printAllHigherThanNum(int num){
         for (LogEntry le : records) {
             if (le.getStatusCode()>num)
              System.out.println(le.getStatusCode());
         }        
        
        }
     
     public void uniqueIPVisitsOnDay(String someday){
         HashSet<String> set = new HashSet();
         for (LogEntry le : records) {
             String d = le.getAccessTime().toString().substring(4, 10);
             if (d.equals(someday))
              set.add(le.getIpAddress());
         }
         System.out.println(set);
     }
     
     public void countUniqueIPsInRange (int low, int high){
            HashSet<String> set = new HashSet();
            for (LogEntry le : records) {
             
             if (le.getStatusCode()>= low && le.getStatusCode()<= high)
              set.add(le.getIpAddress());
         }           
         System.out.println(set.size());
        }
        
     public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> map = new HashMap();
         for (LogEntry le : records) {
             map.putIfAbsent(le.getIpAddress(),0);
             map.replace(le.getIpAddress(), map.get(le.getIpAddress())+1);
            }
         return map;
        }
        
     public void mostNumberVisitsByIP(){
         HashMap<String, Integer> map = new HashMap();
         int max = 0;
         for (LogEntry le : records) {
             map.putIfAbsent(le.getIpAddress(),0);
             map.replace(le.getIpAddress(), map.get(le.getIpAddress())+1);
             if (max < map.get(le.getIpAddress())) max = map.get(le.getIpAddress());
            }

         System.out.println(max);
        }
        
     public void iPsMostVisits(){
         HashMap<String, Integer> map = new HashMap();
           int max = 0;
         for (LogEntry le : records) {
             map.putIfAbsent(le.getIpAddress(),0);
             map.replace(le.getIpAddress(), map.get(le.getIpAddress())+1);
              if (max < map.get(le.getIpAddress())) max = map.get(le.getIpAddress());
            }
            
         for (Map.Entry m: map.entrySet()){
                if ((int)m.getValue() == max) System.out.println(m.getKey());
            }
        }
        
     public void iPsForDays(){
         HashMap<String, HashSet<String>> map = new HashMap();
         
         for (LogEntry le : records) {
             map.putIfAbsent(le.getAccessTime().toString().substring(4, 10), new HashSet());
             map.get(le.getAccessTime().toString().substring(4, 10)).add(le.getIpAddress());
            }
             System.out.println(map);
        }
       
     public void dayWithMostIPVisits(){
         HashMap<String, HashSet<String>> map = new HashMap();
         int max = 0;
         String day = "";
         for (LogEntry le : records) {
             map.putIfAbsent(le.getAccessTime().toString().substring(4, 10), new HashSet());
             map.get(le.getAccessTime().toString().substring(4, 10)).add(le.getIpAddress());
             if (max < map.get(le.getAccessTime().toString().substring(4, 10)).size()) {
                max = map.get(le.getAccessTime().toString().substring(4, 10)).size();
                day = le.getAccessTime().toString().substring(4, 10);
                }
            }
            
         System.out.println(day); 
        }
        
     public void iPsWithMostVisitsOnDay(String someday){
         HashSet<String> ips;
          HashMap<String, HashSet<String>> map = new HashMap();
         
         for (LogEntry le : records) {
             map.putIfAbsent(le.getAccessTime().toString().substring(4, 10), new HashSet());
             map.get(le.getAccessTime().toString().substring(4, 10)).add(le.getIpAddress());
            }
            
          HashMap<String, Integer> v = new HashMap();
         for (LogEntry le : records) {
             if (le.getAccessTime().toString().substring(4, 10).equals(someday)){
             v.putIfAbsent(le.getIpAddress(),0);
             v.replace(le.getIpAddress(), v.get(le.getIpAddress())+1);}
            }
         
         int max = 0;
         for (String ip: map.get(someday)){
            if (max < v.get(ip)) max = v.get(ip);
            }
            
         for (String ip: map.get(someday)){
            if (max == v.get(ip)) System.out.println(ip);
            }
        }
}
