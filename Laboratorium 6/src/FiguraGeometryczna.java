abstract class FiguraGeometryczna {
	
	private String typ_figury;

	abstract String dajTyp();
	abstract double dajPole();

	int[] dajIloscParametrow(){
		int[] i = {1};
		return i;
	}

	public void ustawParametry(double[] param, String opis) {
		typ_figury = opis;
		if ((param.length)==this.dajIloscParametrow()[0]){
			
		}
	}

}
