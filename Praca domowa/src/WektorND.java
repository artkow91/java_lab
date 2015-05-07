import java.util.Arrays;

public class WektorND {

	private double[] wektor;

	public WektorND() {
		double[] wektor = { 0, 0, 0 };
		this.wektor = wektor;
	}

	public WektorND(double[] tablica) {
		double[] wektor = new double[tablica.length];
		this.wektor = wektor;
		for (int i = 0; i < wektor.length; i++) {
			this.wektor[i] = tablica[i];
		}
	}

	public int dajWymiar() {
		return this.wektor.length;
	}

	public double dajSkładową(int i) {
		return this.wektor[i];
	}

	public void ustawSkładową(int i, double d) {
		this.wektor[i - 1] = d;

	}

	public static WektorND dajWektorBazowy(int i, int j) {
		double[] wektor = new double[j];
		for (int k = 0; k < j; k++) {
			wektor[k] = 0;
		}
		wektor[i - 1] = 1;
		return new WektorND(wektor);
	}

	public static WektorND dajWektorZerowy(int i) {
		double[] wektor = new double[i];
		for (int j = 0; j < i; j++) {
			wektor[j] = 0;
		}
		return new WektorND(wektor);
	}

	public double dajModuł() {
		double suma = 0;
		for (int i = 0; i < this.wektor.length; i++) {
			suma += Math.pow(this.wektor[i], 2);
		}
		return Math.sqrt(suma);
	}

	public WektorND dodaj(WektorND wektor1) throws WektorException {
		if (this.wektor.length != wektor1.dajWymiar()) {
			throw new WektorException();
		}
		double[] wektor_suma = new double[wektor1.dajWymiar()];
		for (int i = 0; i < this.wektor.length; i++) {
			wektor_suma[i] = this.wektor[i] + wektor1.dajSkładową(i);
		}
		return new WektorND(wektor_suma);
	}

	public WektorND pomnóżSkalar(double s) {
		for (int i = 0; i < this.wektor.length; i++) {
			this.wektor[i] = this.wektor[i] * s;
		}
		return new WektorND(this.wektor);
	}

	public double iloczynSkalarny(WektorND wektor1) throws WektorException {
		if (this.wektor.length != wektor1.dajWymiar()) {
			throw new WektorException();
		}
		double iloczynSkalarny = 0;
		for (int i = 0; i < this.wektor.length; i++) {
			iloczynSkalarny += this.wektor[i] * wektor1.dajSkładową(i);
		}
		return iloczynSkalarny;
	}

	public double kątMiędzyWektorami(WektorND wektor1) throws WektorException {
		if (this.wektor.length != wektor1.dajWymiar()) {
			throw new WektorException();
		}
		double argument = this.iloczynSkalarny(wektor1)
				/ (this.dajModuł() * wektor1.dajModuł());
		if (argument > 1) {
			argument = 1;
		} else if (argument < -1) {
			argument = -1;
		}
		double kątMiędzyWektorami = Math.acos(argument);
		return kątMiędzyWektorami;
	}

	public WektorND znormalizuj() {
		double[] wektor_znormalizowany = new double[this.wektor.length];
		for (int i = 0; i < this.wektor.length; i++) {
			wektor_znormalizowany[i] = this.wektor[i] / this.dajModuł();
		}
		return new WektorND(wektor_znormalizowany);
	}

	public static boolean czyOrtogonalne(WektorND w1, WektorND w2)
			throws WektorException {
		if (w1.iloczynSkalarny(w2) == 0) {
			return true;
		} else
			return false;
	}

	public static boolean czyOrtonormalne(WektorND w1, WektorND w2)
			throws WektorException {
		if (w1.equals(w2)) {
			if (w1.iloczynSkalarny(w2) == 1) {
				return true;
			} else
				return false;
		} else if (w1.iloczynSkalarny(w2) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.wektor);
	}

	@Override
	public boolean equals(Object obj) {
		WektorND wektor = (WektorND) obj;
		if (this.wektor.length == wektor.dajWymiar()) {
			for (int i = 0; i < wektor.dajWymiar(); i++) {
				if (this.wektor[i] != wektor.dajSkładową(i)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}
}
