/*
134. Gas Station  QuestionEditorial Solution  My Submissions
Total Accepted: 65272
Total Submissions: 234691
Difficulty: Medium
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Hide Tags Greedy
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int e=0; int s=gas.length-1; // e=0; s=1;
        int sum=gas[s]-cost[s];
        while(s>e){
            if(sum>=0){
                sum+=gas[e]-cost[e];
                e++;
            }else{
                s--;
                sum+=gas[s]-cost[s];
            }
        }
        if(sum>=0)return s;
        else return -1;
    }
}