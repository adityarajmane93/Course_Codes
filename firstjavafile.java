import java.io.*;
import java.util.*;

class firstjavafile{
    public static void main (String args[])throws IOException{
        System.out.println("Enter your name :");
        DataInputStream input=new DataInputStream(System.in);
        String in=input.readLine();
        System.out.println("HELLO !!! How are you "+in);
    }
}