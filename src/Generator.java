import java.util.Random;

public class Generator {
private int min, max, br;
private Skup s = new Skup();
public Generator(int min, int max){
this.max = max;this.min = min;
}
public int sledeci()throws GreskaGenerisanje{
if(br==max-min+1)
throw new GreskaGenerisanje();
Random r = new Random();
while(true){
int b = r.nextInt(max-min+1) + min;
if(s.postoji(b)) continue;
s.dodaj(b);br++;return b;}
}
public void obrisiIstorju(){
 br = 0; s.prazni(); }
}
