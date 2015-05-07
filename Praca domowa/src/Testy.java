import static org.junit.Assert.*;

import org.junit.Test;

public class Testy {

	@Test
	public void test_konstruktor_bezparametrowy_trójelementowy() {
		WektorND wektor = new WektorND();
		assertEquals(0.0, wektor.dajSkładową(0), 1e-5);
		assertEquals(0.0, wektor.dajSkładową(1), 1e-5);
		assertEquals(0.0, wektor.dajSkładową(2), 1e-5);
		assertEquals(3, wektor.dajWymiar());
	}

	@Test
	public void test_konstruktor_arg_tablica() {
		double[] tablica = { 1, 1 };
		WektorND wektor = new WektorND(tablica);
		assertEquals("[1.0, 1.0]", wektor.toString());
	}

	@Test
	public void test_dajWymiar() {
		double[] tablica1 = { 1, 1 };
		double[] tablica2 = { 2, 2, 2 };
		double[] tablica3 = { 1, 2, 3, 4, 5 };
		WektorND wektor1 = new WektorND(tablica1);
		WektorND wektor2 = new WektorND(tablica2);
		WektorND wektor3 = new WektorND(tablica3);
		assertEquals(2, wektor1.dajWymiar());
		assertEquals(3, wektor2.dajWymiar());
		assertEquals(5, wektor3.dajWymiar());
	}

	@Test
	public void test_pobrać_zmienić_składowe() {
		double[] tablica = { 1, 2 };
		WektorND wektor = new WektorND(tablica);
		wektor.ustawSkładową(1, 1.5);
		assertEquals(1.5, wektor.dajSkładową(0), 1e-5);
		assertEquals("[1.5, 2.0]", wektor.toString());

	}

	@Test
	public void test_dajWektorBazowy() {
		WektorND wektor = WektorND.dajWektorBazowy(3, 5);
		assertEquals("[0.0, 0.0, 1.0, 0.0, 0.0]", wektor.toString());
	}

	@Test
	public void test_dajWektorZerowy() {
		WektorND wektor = WektorND.dajWektorZerowy(4);
		assertEquals(4, wektor.dajWymiar());
		for (int i = 0; i < 4; i++) {
			assertEquals(0.0, wektor.dajSkładową(i), 1e-5);
		}
	}

	@Test
	public void test_dajModuł() {
		double[] tablica = { 2, 3, 6 };
		WektorND wektor = new WektorND(tablica);
		assertEquals(7, wektor.dajModuł(), 1e-5);
	}

	@Test
	public void test_equals() {
		double[] tablica = { 1, 1 };
		double[] tablica1 = { 1, 2 };
		double[] tablica2 = { 1, 1, 1 };
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica);
		WektorND wektor2 = new WektorND(tablica1);
		WektorND wektor3 = new WektorND(tablica2);
		assertEquals(true, wektor.equals(wektor1));
		assertEquals(false, wektor1.equals(wektor2));
		assertEquals(false, wektor1.equals(wektor3));
	}

	@Test
	public void test_dodaj() throws WektorException {
		double[] tablica = { 1, 1 };
		double[] tablica1 = { 1, 2 };
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		WektorND wektor2 = wektor.dodaj(wektor1);
		assertEquals("[2.0, 3.0]", wektor2.toString());
	}

	@Test
	public void test_pomnóżSkalar() {
		double[] tablica = { 1, 1 };
		double[] tablica1 = { 1, 2, 3 };
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		wektor = wektor.pomnóżSkalar(3);
		wektor1 = wektor1.pomnóżSkalar(5);
		assertEquals(3, wektor.dajSkładową(0), 1e-5);
		assertEquals(5, wektor1.dajSkładową(0), 1e-5);
		assertEquals(10, wektor1.dajSkładową(1), 1e-5);
		assertEquals(15, wektor1.dajSkładową(2), 1e-5);
	}

	@Test
	public void test_iloczynSkalarny() throws WektorException {
		double[] tablica = { 1, 2 };
		double[] tablica1 = { 2, 3 };
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		assertEquals(8, wektor.iloczynSkalarny(wektor1), 1e-5);
		assertEquals(8, wektor1.iloczynSkalarny(wektor), 1e-5);
	}

	@Test
	public void test_kątMiędzyWektorami() throws Exception {
		double[] tablica = { 1, 10 };
		double[] tablica1 = { 2, 1 };
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		assertEquals(1.00748, wektor.kątMiędzyWektorami(wektor1), 1e-5);
		assertEquals(1.00748, wektor1.kątMiędzyWektorami(wektor), 1e-5);
	}
	@Test
	public void test_znormalizuj() {
		double[] tablica = {1,2};
		WektorND wektor = new WektorND(tablica);
		wektor = wektor.znormalizuj();
		assertEquals(1.0, wektor.dajModuł(), 1e-5);
		assertEquals(0.44721, wektor.dajSkładową(0), 1e-5);
	}
	@Test
	public void czyOrtogonalne() throws WektorException {
		double[] tablica = {1,0};
		double[] tablica1 = {0,1};
		double[] tablica2 = {1,1};
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		WektorND wektor2 = new WektorND(tablica2);
		assertEquals(true, WektorND.czyOrtogonalne(wektor,wektor1));
		assertEquals(false, WektorND.czyOrtogonalne(wektor,wektor2));
	}
	@Test
	public void czyOrtonormalne() throws Exception {
		double[] tablica = {1,0};
		double[] tablica1 = {0,1};
		double[] tablica2 = {1,1};
		WektorND wektor = new WektorND(tablica);
		WektorND wektor1 = new WektorND(tablica1);
		WektorND wektor2 = new WektorND(tablica2);
		assertEquals(true, WektorND.czyOrtonormalne(wektor,wektor1));
		assertEquals(false, WektorND.czyOrtonormalne(wektor,wektor2));
	}
}
