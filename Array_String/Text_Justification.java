

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<String>();
        if(words==null || words.length==0)return ans;
        int i = 0;int LineLen = 0;int preS=0; 
        while(i<words.length){
            List<String> LineList = new LinkedList<String>();
            while(LineLen<=maxWidth){
                System.out.println("sd  "+i+" "+preS);
                if(i>preS){LineList.add(words[i-1]);System.out.println(i+"   +");}
                if(i==words.length)break;
                if(LineList.size()!=0)LineLen++;
                LineLen+=words[i].length();
                i++;
                System.out.println("st  "+i+" "+preS+" "+LineLen+" "+maxWidth);
            }
            i--;
            for(String str:LineList)System.out.println(str+" ");
            System.out.println("p");
            preS=i;
            LineLen=0;
            ans.add(helper(LineList,maxWidth));
        }
        return ans;
    }
    public String helper(List<String> LineList,int maxWidth){//{""},0
        
        String ans = ""; 
        int divide = LineList.size()-1;
        if(LineList.size()==1)divide=1;//divide=1
        int spaceNum = maxWidth;//0
        for(String temStr: LineList)spaceNum-=temStr.length();
        int spaceMin=spaceNum/divide;//0
        int StartMin = LineList.size();//1
        int spaceMax = spaceMin;//0
        if((spaceNum % divide) !=0){
            spaceMax++;
            StartMin+=spaceNum % divide;
        }
        int i=0;
        for(;i<divide;i++){//i=0,0
            ans+=LineList.get(i);
            for(int j=0;j<spaceMax;j++)ans+=" ";
        }
        for(;i<LineList.size()-1;i++){
            ans+=LineList.get(i);
            for(int j=0;j<spaceMin;j++)ans+=" ";
        }
        if(i<LineList.size())ans+=LineList.get(i);
        return ans;
    }
}