import java.io.*;
import java.util.*;

class Pattern{

	public static void main(String args[])throws IOException{

		System.out.println("Enter the word");
		DataInputStream input=new DataInputStream(System.in);
		String a=input.readLine();
		char ar[]=a.toCharArray();
		
		for(int i=1;i<=a.length();i++){
			for(int j=a.length()-1;j>=i;j--)
				System.out.print("  ");
			for(int j=1;j<=i;j++)
				if(j>1)
				System.out.print(ar[i-j+1]+" ");
			for(int j=1;j<=i;j++)
				System.out.print(ar[j-1]+" ");
			System.out.println("  ");
		}

	}
}