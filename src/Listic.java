public class Listic {
private static int sledID = 0;
private int id = sledID++;
private int brojevi[], n;
public Listic(int n){
 brojevi = new int[n];}
public void dodaj(int i){
 brojevi[n++] = i;}


public String toString(){
StringBuilder sb =
 new StringBuilder("["+id+"]");
for(int i=0;i<n;i++) {
if(i>0) sb.append(", ");
 sb.append(brojevi[i]);
}return sb.toString();
}
public int uSkupu(Skup s){
int i = 0;
for(int br:brojevi) if(s.postoji(br)) i++;
return i;
	}
	
	

}
