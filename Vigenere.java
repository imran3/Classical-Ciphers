import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Vigenere{
	public static void main(String[] args)
	{
		printVigenereMap();
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Insert your message: ");
			String plain = input.readLine();
			System.out.print("Choose your key: ");
			String key = input.readLine();
			key = key.toUpperCase();
			String cipher = encrypt(plain, key);
			System.out.print("\nEncrypted message\n"+cipher+"\n");
			plain = decrypt(cipher, key);
			System.out.println("The message is\n"+plain+"\n");
		}catch(IOException ioe){}

	}
	public static String encrypt(String message, String key){
		String cipher = "";
		message = message.toUpperCase();
		for(int i=0, j=0; i<message.length(); i++){
			char c = message.charAt(i);
			if(c<'A' || c>'Z') continue;
            cipher += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j%key.length();
		}
		return cipher;
	}
	public static String decrypt(String cipher, String key){
		String message = "";
		for(int i=0, j=0; i<cipher.length(); i++){
			char c = cipher.charAt(i);
			message += (char)((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j%key.length();
		}
		return message;
	}
	public static void printVigenereMap(){
		System.out.println("This cipher use this matrix to encrypt and decrypt");
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++)
				System.out.print((char)(((i+j)%26)+'A') +" ");
			System.out.print("\n");
		}
	}
}