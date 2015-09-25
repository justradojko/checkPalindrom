import java.io.*;

public class Palindrom {
	private String text = "";
	
	private void loadText(){
		try{
			FileReader fr = new FileReader(new File("palindrom.txt"));
			BufferedReader br = new BufferedReader(fr);
	
			int numberOfLines = Integer.parseInt(br.readLine());
			for (int i = 0; i < numberOfLines ; i++) {
				text = text + " " + br.readLine();
			}
			br.close();
		} catch (Exception c){ c.printStackTrace(); }
	}
	
	private boolean checkIfPalindrom(){
		int firstChar = 0;
		int lastChar = text.length() - 1;
		
		
		while(firstChar < lastChar){
			while( !Character.isAlphabetic(text.charAt(firstChar)) && firstChar < lastChar ){
				firstChar++;
			}
			
			while( !Character.isAlphabetic(text.charAt(lastChar)) && firstChar < lastChar ){
				lastChar--;
			}
			if (Character.toUpperCase(text.charAt(firstChar)) != Character.toUpperCase(text.charAt(lastChar))) {
				return false;
			} 
			firstChar++;
			lastChar--;
		}
		return true;
	}
	
	public void go(){
		this.loadText();
		if (this.checkIfPalindrom()) {
			System.out.println("Palindrom");
		} else {
			System.out.println("Not palindrom");
		}
		
	}
	
	public static void main (String[] args){
		Palindrom pal = new Palindrom();
		pal.go();
	} 
}
