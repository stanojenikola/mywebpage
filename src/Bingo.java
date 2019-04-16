
public class Bingo extends Thread{

	public Bubanj bubanj;
	public Generator generator;
	public Listic[] listici;
	public int brojeva, n;
	public Listic listic;
	public boolean uToku = false;
	public Skup skup = new Skup();
	
	public Bingo(int nn, int min, int max, int brojeva) {
		listici = new Listic[nn];
		generator = new Generator(min, max);
		bubanj = new Bubanj(min, max);
		this.brojeva = brojeva;
	}
	//git
	//git 2r
	//git 3
	public synchronized Listic noviListic() throws Exception {
		
		if(uToku) throw new Exception();
		
		Listic listi = new Listic(brojeva);
		for(int i=0; i < brojeva; i++) {
			listi.dodaj(generator.sledeci());
		}
		return listi;
	}
	
	public synchronized void dodajListic(Listic l) throws Exception {
		if(uToku) throw new Exception();
		listici[n++] = l;
	}
	
	
	public synchronized void pokreni() {
		uToku = true; start();
	}
	
	public int max() {
		int m = 0;
		for(Listic l : listici) {
			if(l == null) continue;
			int lm = l.uSkupu(skup);
			if(lm > m) m = lm;
		}
		return m;
	}
	
	public Listic dobitni() {
		for(Listic l : listici) {
			if(l.uSkupu(skup) == brojeva)  return l;
		}
		return null;
	}	
	
	public void run() {
		bubanj.pokreni();
		System.out.println("pocinje");
		
		while(!interrupted()) {
				int br;
				try {
					br = bubanj.sledeci();
					skup.dodaj(br);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int m = max();
				
				if(m == brojeva) uToku = false;
				bubanj.zaustavi();
				break;
		}
		
		if(uToku) {
			bubanj.zaustavi(); uToku = false;
		}
	}	
		
}
	
	
	
	
	

