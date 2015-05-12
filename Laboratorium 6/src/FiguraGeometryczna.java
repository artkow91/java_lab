abstract class FiguraGeometryczna {
	
	private String typ_figury;

	abstract String dajTyp();
	abstract double dajPole();
//	int[] dajIloscParamterow();

	public void dajFigure(String string) {

	}

	public void ustawParametry(double[] param, String opis) {
		typ_figury = opis;
		
	}

}
