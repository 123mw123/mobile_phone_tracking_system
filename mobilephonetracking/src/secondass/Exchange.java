package secondass;
import java.util.LinkedList;
public class Exchange {
	 LinkedList<Integer> exchangelist= new LinkedList<Integer>();//stores identifiers of all children of particular exchange.
	 LinkedList<Exchange> exchange=new LinkedList<Exchange>();//stores all exchanges except 0;
	 Myset el=new Myset();;//stores all identifiers of exchanges.
	LinkedList base;//stores all mobile phones of each base station.
	LinkedList<Exchange> children;//Stores all children of each exchanges
	
int e;


public Exchange(int number) {
	 base=new LinkedList();
	
	children=new LinkedList<Exchange>();
	e=number;
 

}

public Exchange(LinkedList<Integer> list){
	
	exchangelist=list;
	
}



    public  void addChild(Exchange child)
    {
    exchangelist.add(child.e);
       el.push(child.e);
       exchange.add(child);
       children.add(child);
  
      
    }
   
  
public Exchange  parent(){
	int k;
for( k=0;k<exchange.size();k++)
{
	if (exchange.get(k).exchangelist.contains(e))
		break;
}
 return exchange.get(k);
	
}
public int numChildren(){
	
return  exchangelist.size();
}
public int child(int i){
	return     (int) exchangelist.get(i);
}

public void residentSet(Exchange a){

	for(int i=0;i<a.exchangelist.size();i++){
		if(children.get(i).exchangelist.isEmpty())
			for(int j=0;j<children.get(i).base.size();j++)
		base.add(children.get(i).base.get(j));
		else 
			residentSet(children.get(i) );
	
	}
	
}

}
