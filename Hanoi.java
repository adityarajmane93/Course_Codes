import java.io.*;
import java.util.*;

class Hanoi{

	public static void main(String args[])throws IOException{

		DataInputStream input=new DataInputStream(System.in);
		System.out.println("Enter the number of steps");
		int n=Integer.parseInt(input.readLine());
		String ans=hanoi(n,1,3);
		System.out.println(ans);
	}
	public static String hanoi(int nDisks,int f,int t){
			int help;
			String sol1,sol2, intstep, finstep;
			
			if(nDisks==1)
				return f+" -> "+t+"\n";
			else{
				help=6-f-t;
				sol1=hanoi(nDisks-1,f,help);
				intstep=f+" -> "+t+"\n";
				sol2=hanoi(nDisks-1,help,t);
				finstep=sol1+intstep+sol2;
				return finstep;
			}	
		}
}