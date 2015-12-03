/*
Flip Game II
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

Hide Company Tags Google
Hide Tags Backtracking
Hide Similar Problems (E) Nim Game (E) Flip Game
*/
public class Solution {
    public boolean canWin(String s) {
        List<String> allSitu  = new ArrayList<String>();
        String tem = "";
        for(int i=0;i<s.length()-1;i++){//0-size-2
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                tem=s.substring(0,i)+"--"+s.substring(i+2,s.length());
                allSitu.add(tem);
            }
        }
        for(String str : allSitu){
            if(!canWin(str)){return true;}
        }
        return false;   
    }   
}