/*
how many string can be printed in a given screen?
The String will go to next line if one line cannot hold an entire string.
*/
public class ScreenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//given screen N*M
		//given string
		//return the number of the string
		ScreenString ss = new ScreenString();
		String s = "Hello, this is Samantha!hdfcouwh soncsiond scdnos";
		int N=20;int M=4;
		System.out.println(ss.NumOfString(s, N, M));
	}
	
	public int NumOfString(String s, int N, int M){
		int ans = 0; int n = 0; int m = 0;
		//s="Hello, My name is Yujia Xiao."
		//"Hello, My name is Yu|jia Xiao." -> "Hello, My name is   /Yujia Xiao."		
		//N-0=N;n is the starting position 
		int StartOfRemainString = 0;
		String remind = null;
		boolean Flg = true;
		while(m<M){ //m=0;n=0
			n=0;//update;
			// reminder first;
			Flg=true;
			
			if(remind!=null){
				if(remind.length()<=N){ans++;Flg=true;}
				else{
					StartOfRemainString = NumOfStirngAndRemain(N-n,s);
					remind = s.substring(StartOfRemainString);
					Flg=false;
				}
			}
			
			while((n<N) && (Flg==true)){//N=6; n=0, N-n=6 ,0-5;length=3 -> 0+3=3
				if(s.length()<=N-n){
					ans++;
					n=n+s.length();
					remind = null;
				} //n is the starting point			
				else{
					StartOfRemainString = NumOfStirngAndRemain(N-n,s);
					remind = s.substring(StartOfRemainString);
					break;
				}
			}			
			m++; // next line
		}		
		return ans;
	}
	
	public int NumOfStirngAndRemain(int lineSpace, String s){
		if(lineSpace<1)return 0;
		int ans = 0; //start position of the remain s
		char regex = ' '; int regexint = (int)regex;
		//"Hello, this is some."
		if(s.charAt(lineSpace-1)==' ' || s.charAt(lineSpace)==' '){
			ans = lineSpace;
		}
		else{
			//String temS = s.substring(0,lineSpace);
			ans = s.lastIndexOf(regexint,lineSpace)+1;
		}
		return ans;
	};

}
