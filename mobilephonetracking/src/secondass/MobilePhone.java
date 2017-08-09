package secondass;

public class MobilePhone{
	public int m;
	boolean phone;
 Myset ms=new Myset();//stores all mobile identifiers
	
	public MobilePhone(int number){
		
		m=number;
		phone =true;
		if(!ms.list.contains(m)){
			ms.push(m);
	
		}
		

			
	}
	
	public int number()
	{
		return m;
	}
	
	
			
	public Boolean status(){
		return phone;
	
}
	
	public void switchOn(){
		phone=true;
	}
	public void switchoff(){
		phone=false;
		
	}
	Exchange me;

	public Exchange location(){
	
	for(int k=1;k<=me.exchange.size();k++){
		me=new Exchange(k);
		if(me.el.list.contains(m))
			break;
	}
	
return me;
	}
	
	
}
