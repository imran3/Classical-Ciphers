import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;
public class Caesar{
	public static void main(String[] args){
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Insert your message: ");
			String plain = in.readLine().toUpperCase();	
			System.out.print("Amount of shift: ");
			int shift = Integer.parseInt(in.readLine())%26+'A';

			String cipher = encrypt(plain, shift);
			System.out.print("Encryped message is: "+cipher+"\n");

			plain = decrypt(cipher, shift);
			System.out.print("The message is: "+plain+"\n");
		}
		catch(IOException ioe){System.out.println("Invalid message!");}
		catch(NumberFormatException nfe){System.out.println("Invalid shift amount! I need an integer number!");}
	}
	public static String encrypt(String message, int shift){
		String cipher = "";
		for(int i=0; i<message.length(); i++){
			char c = message.charAt(i);
			if(c<'A' || c>'Z') continue; 
            cipher += (char)((c+shift)%26+'A');
		}
		return cipher;
	}
	public static String decrypt(String cipher, int shift){
		return encrypt(cipher, 26-shift);
	}
}