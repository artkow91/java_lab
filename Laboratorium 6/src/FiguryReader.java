import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class FiguryReader {
	private String tekst = "";

	public FiguryReader(Reader str_znakow) throws IOException {
		BufferedReader br = new BufferedReader(str_znakow);
		String lin;
		while ((lin = br.readLine()) != null) {
			tekst += lin;
			tekst += "\n";
		}
	}

	public FiguraGeometryczna nastepnaFigura() throws IOException {
		BufferedReader reader = new BufferedReader(new StringReader(tekst));
		String linia_bierzac = reader.readLine();
		String linia_bierzaca = reader.readLine();
		String[] pojedyncza_linia = linia_bierzaca.split("\t"); // podzial_pojedynczej_lini_na_czesci

		String[] parametry_liczbowe = pojedyncza_linia[2].split(","); // zamiana_str_na_tablice_double
		double[] param = new double[parametry_liczbowe.length];
		for (int i = 0; i < parametry_liczbowe.length; i++)
			param[i] = Double.parseDouble(parametry_liczbowe[i]);

		String typ_figury = pojedyncza_linia[0];

		FiguraGeometryczna f = FabrykaFigurGeometrycznych.dajFigure(typ_figury);

		String opis_figury = pojedyncza_linia[1];
		double parametr_figury = Double.parseDouble(pojedyncza_linia[2]);
		System.out.println(parametr_figury);

		 f.ustawParametry(param, opis_figury);

		 return f;
	}

	public static String odczytajPierwszaLinieZPlikuTryWith()
			throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("plik.txt"))) {
			return br.readLine();
		}
	}

	@Override
	public String toString() {
		return this.tekst;
	}

}
