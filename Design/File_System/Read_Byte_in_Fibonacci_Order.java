/*
Read the byte[] from buffer in fibonacci order
*/
package basic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
class has no parameters; 
fibonacci a = new fibonacci();
fibonacci b = new fibonacci("Hello");
*/
public class FibonacciByte{
	// static means only one instance of a static field exists
	public static void main(String args[]){
		//int number = new Scanner(System.in).nextInt();
		File file = new File("ifile.txt");
		FileInputStream fin = null;
		String ans = "";
		try{
			fin = new FileInputStream(file);
			byte fileContent[] = new byte[(int)file.length()];
			byte fileOutput[] = new byte[(int)file.length()];
			fin.read(fileContent);
			String s = new String(fileContent);
			System.out.println(s);
			
			for(int i=1;i<7;i++){
				//String s = new String(fileContent[i]);
				//fileOutput[i]=fileContent[fibonacciLoop(i)];
				ans=ans+(char)fileContent[fibonacciLoop(i)];
				//System.out.print((char)fileContent[fibonacciLoop(i)]);
				}
			System.out.println(ans);
			fileOutput = ans.getBytes();
			fin.close();
			FileOutputStream fout = new FileOutputStream("ofile.txt");
			
			fout.write(fileOutput);
			fout.close();
						
		}catch(FileNotFoundException e){
			System.out.println("FileNotFoundException"+e);
		}catch(IOException e){
			System.out.println("IOException"+e);
		}		
		for(int i=1;i<15+1;i++){
			System.out.print(fibonacciRecursion(i)+" ");
		}
		System.out.println();
		for(int i=1;i<15+1;i++){
			System.out.print(fibonacciLoop(i)+" ");
		}
		
	}
	//boundary condition
	// recursion
	public static int fibonacciRecursion (int number){
		if(number == 1 || number == 2){return 1;}
		return fibonacciRecursion(number-1)+fibonacciRecursion(number-2);
	}	
	// loop
	public static int fibonacciLoop(int number){
		if(number == 1 || number == 2){
			return 1;
		}
		int f1 = 1;
		int f2 = 1;
		int fl = 0;
		for(int i = 3 ; i < number+1; i++){
			fl = f1+f2;
			f1 = f2;
			f2 = fl;
		}
		return fl;
	}
	
	
}
