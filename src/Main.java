
public class Main {

	public static void main(String[] args) throws Exception {
	Skup s =new Skup();
	
	if(s.postoji(5)) s.dodaj(5);
	
	Generator g = new Generator(1, 5);
	
	Bubanj bubanj = new Bubanj(1, 39);
	bubanj.pokreni();
	
	for(int i = 0; i < 7; i++) {
		int br = bubanj.sledeci();
	}
	
	bubanj.zaustavi();
	
	int maxBrListica = 100;
	int minBrNaListicu = 1;
	int maxBrNaLisitcu = 99;
	int brBrojevaNaListicu = 4;
	
	Bingo bingo = new Bingo(maxBrListica, minBrNaListicu, maxBrNaLisitcu, brBrojevaNaListicu);

	
	for(int i = 0; i < 10; i++) {
		Listic l= bingo.noviListic();
		System.out.println(l);
		bingo.dodajListic(l);
	}
	
	bingo.pokreni();
	bingo.join();
	
	System.out.println();
	System.out.println(bingo.dobitni());

	
	
	
	
	
}
	

}
