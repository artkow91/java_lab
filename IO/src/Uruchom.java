import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Uruchom {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader( "plik.txt" );
		FiguryReader figury = new FiguryReader(fr);
		figury.nastepnaFigura();
		
		fr.close();

	}

}
