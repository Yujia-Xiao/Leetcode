/*
Unique Word Abbreviation
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
Hide Company Tags Google
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum III - Data structure design
*/
public class ValidWordAbbr {

    private Map<String,List<String>> dicmap = new HashMap<String,List<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++){
            String str = dictionary[i];
            String abb = str.charAt(0)+String.valueOf(str.length())+str.charAt(str.length()-1);
            if(dicmap.containsKey(abb)){dicmap.get(abb).add(str);}
            else{
                List<String> mlist = new ArrayList<String>();
                mlist.add(str);
                dicmap.put(abb,mlist);
            }
        }
    }

    public boolean isUnique(String word) {
        String abb = word.charAt(0)+String.valueOf(word.length())+word.charAt(word.length()-1);
        
        if(dicmap.containsKey(abb)){
            if(dicmap.get(abb).size()>1){return false;}
            else{
                if(dicmap.get(abb).get(0).equals(word)){return true;}
                else {return false;}
            }
        }
        else{return true;}
    }
}
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");