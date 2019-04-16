
public class Skup {
private class Elem{
int broj; Elem sled;
Elem(int i){
broj = i;
if(prvi==null) prvi = this;
 else posl.sled = this;
posl = this;}
}
private Elem prvi, posl;
public boolean dodaj(int i){
if(postoji(i)) return false;
new Elem(i);return true;
}
public boolean postoji(int i){
Elem pom = prvi;
while(pom!=null)
if(pom.broj == i) return true;
else pom = pom.sled;
return false;
}
public void prazni(){prvi = posl = null;}
public String toString(){
if(prvi == null) return "";
StringBuilder sb =
 new StringBuilder(prvi.broj);
Elem pom = prvi;
while(pom!=null) {
sb.append(",").append(pom.broj);
pom = pom.sled;
}return sb.toString();
}
}

	
	

