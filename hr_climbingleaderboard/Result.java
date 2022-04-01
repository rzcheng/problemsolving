import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

    List<Integer> placings = new ArrayList<Integer>();
    List<Integer> rankings = new ArrayList<Integer>();
    
    //create a list of all original score rankings

    int rankIndex = 1;
    rankings.add(rankIndex);
    for (int i = 1; i < ranked.size(); i++) {
        if (ranked.get(i).equals(ranked.get(i-1))) {
            rankings.add(rankIndex);
        } else {
            rankIndex++;
            rankings.add(rankIndex);
        }
    }

    rankings.add(rankIndex+1);
    
    //use binary search to find the position of each player score
    //use position to find ranking in rankings list
    //original nested forloop was not accepted due to high time complexity
    
    for (int i = 0; i < player.size(); i++) {
        
        placings.add(rankings.get(binarySearchPosition(player.get(i), ranked)));
    
    }
    
    return placings;
    
    /* 

        for (int i = 0; i < player.size(); i++) {
            int currentPosition = 1;
            
            for (int m = 0; m < ranked.size(); m++) {
                
                if (m > 0 && ranked.get(m) != ranked.get(m-1)){
                currentPosition++;
                }
                
                if (player.get(i) > ranked.get(m)) {
                    list.add(currentPosition);
                    break;
                } else if (player.get(i) == ranked.get(m)){
                    list.add(currentPosition);
                    break;
                } else if (m == ranked.size()-1){
                    list.add(currentPosition + 1);
                } 

            }
        }
        return list;
        
        */
    }
    
    public static int binarySearchPosition(int num, List<Integer> list) {
        
        if (num < list.get(list.size() - 1))
            return list.size();
        else if (num >= list.get(0))
            return 0;

        int testMin = 0;
        int testMax = list.size() - 1;
        while((testMin != testMax-1)) {            

            if (num > list.get((testMin + testMax)/2)) {
                testMax -= (testMax-testMin)/2;
            }
            else if (num < list.get((testMin + testMax)/2)) {
                testMin += (testMax-testMin)/2;
            } else {
                return (testMax+testMin)/2;
            }
            //System.out.println("testmin: " + testMin + " testmax: " + testMax);
        } 
        return testMax;
    } 

}