/*
Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
Hide Company Tags LinkedIn
Hide Tags Hash Table Bit Manipulation
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> data = new HashSet<String>();
        HashSet<String> ans = new HashSet<String>();

        for (int i=9;i<s.length();i++){
            String sTem=s.substring(i-9,i+1);
            if(data.contains(sTem)){
                if(!ans.contains(sTem))ans.add(sTem);
            }
            else data.add(sTem);
        }
        List<String>  =new ArrayList<String>(ans);
        return list;
    }
}