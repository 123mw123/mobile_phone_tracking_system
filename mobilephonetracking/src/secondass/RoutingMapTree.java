package secondass;


import java.util.LinkedList;
public class RoutingMapTree {
	
LinkedList<Exchange> u=new LinkedList<Exchange>();//stores all exchanges

Myset rs=new Myset();
public Exchange r;

public   RoutingMapTree(){
	 r = new Exchange(0);
	
	 
}

public Boolean containsNode(Exchange a){
return r.exchange.contains(a);
}
public void addexchange(int a,int b){
	int j=110;
	int k=110;

	  for(int i=0;i<u.size();i++){
	  while(u.get(i).e==a){
		 j=i;
		
		 break;
		 
	 }
	
	 
	
	 while(u.get(i).e==b){
		 k=i;
		 break;
	 }
	
 }

u.get(j).addChild(u.get(k));





}
 
public void switchOn(MobilePhone a, Exchange b){
	int b1=0;
	if(rs.IsMember(b.e)){
	for(int i=0;i<u.size();i++){
		while(u.get(i).e==b.e){
			b1=i;
			break;
		}
	}
u.get(b1).base.add(a.m);
	}
	else
	System.out.println(b.e+" exchange doesn't exists");

}
public void switchOff(MobilePhone a){
	int j=0;
	for(int i=0;i<u.size();i++){
		if(u.get(i).base.contains(a.m)){
			u.get(i).base.removeFirstOccurrence(a.m);
			j=1;
		}
	}
	if(j==0)
		System.out.println(a.m+" doesn't exists");
	
	a.phone=false;
}


public void queryNthChild(Exchange a,int b){
	
	
	int q=0;
	for(int i=0;i<u.size();i++){
		while(u.get(i).e==a.e){
			q=i;
			break;
		}
	}
	try{
	
	System.out.println(u.get(q).exchangelist.get(b));
	}
	catch(java.lang.IndexOutOfBoundsException en){
	
	System.out.println(b+" child doesn't exist for exchange "+a.e);
	}
	
	
}
public LinkedList QueryExchangeSet(Exchange b){
LinkedList L=new LinkedList();//stores Mobile phone set of each exchange.
	int q=0;
	for(int i=0;i<u.size();i++)
		while(u.get(i).e==b.e){
			q=i;
			break;
		}
	if(u.get(q).exchangelist.size()==0)	
L.add(u.get(q).e);
	else
		for(int i=0;i<u.get(q).children.size();i++)
		L.addAll(QueryExchangeSet(u.get(q).children.get(i)));
	

	return L;	
}
public LinkedList QueryMobilePhoneSet(Exchange b){
LinkedList L=new LinkedList();//stores Mobile phone set of each exchange.
	int q=0;
	for(int i=0;i<u.size();i++)
		while(u.get(i).e==b.e){
			q=i;
			break;
		}
	if(u.get(q).exchangelist.size()==0)	
L= u.get(q).base;
	else
		for(int i=0;i<u.get(q).children.size();i++)
		L.addAll(QueryMobilePhoneSet(u.get(q).children.get(i)));
	

	return L;	
}
public void queryMobilePhoneSet(Exchange b){

	int q=0;
	for(int i=0;i<u.size();i++)
		while(u.get(i).e==b.e){
			q=i;
			break;
		}
System.out.println(QueryMobilePhoneSet(u.get(q)));

}
public Exchange findPhone(MobilePhone m){
	int c=0;
	for(int i=0;i<u.size();i++){
		if(u.get(i).base.contains(m.m)){
		c=i;	
		break;
		}	
		}
	return u.get(c);
}
public void queryFindPhone(MobilePhone m){
	int j=0;
	for(int i=0;i<u.size();i++){
		if(u.get(i).base.contains(m.m)){
	System.out.println(findPhone(m).e);
		j=1;
		}
	}
		if(j==0)
			System.out.println(m.m+ " doesn't exist");
			
}
public Exchange Router(Exchange a,Exchange b){
	int f=111;
	for(int i=0;i<u.size();i++){
		int j;
		
		if(QueryExchangeSet(u.get(i)).contains(a.e) && QueryExchangeSet(u.get(i)).contains(b.e)){
			
			j=QueryExchangeSet(u.get(i)).size();
			f=i;
			for(int k=0;k<u.size();k++){
if(QueryExchangeSet(u.get(k)).contains(a.e) && QueryExchangeSet(u.get(k)).contains(b.e) && QueryExchangeSet(u.get(k)).size()<j ){
				j=QueryExchangeSet(u.get(k)).size();
				f=k;
				}
			}
			
		}
	}
	return u.get(f);
	
}

public void queryLowestRouter(Exchange a,Exchange b){
	
	
	
	
	try{
	System.out.println(Router(a,b).e);
	}
	catch(java.lang.IndexOutOfBoundsException en){
		System.out.println("given exchanges doesnot exists or not base stations");
	}
}
public LinkedList routeCall(MobilePhone a, MobilePhone b){
LinkedList L=new LinkedList();

LinkedList L1=new LinkedList ();
LinkedList L2=new LinkedList ();
int j=0;
int d=0;
int z=0;

	
if(findPhone(a).e==findPhone(b).e){
	L2.add(findPhone(a).e);}
	else if(findPhone(a).e!=findPhone(b).e){
		
		j=QueryMobilePhoneSet(Router(findPhone(a),findPhone(b))).size();
		for(int i=0;i<j;i++){
			L2.add(i,999999);
			L1.add(i,999999);
		}
		for(int i=0;i<u.size();i++){
		if(j>=QueryMobilePhoneSet(u.get(i)).size()&&QueryMobilePhoneSet(u.get(i)).contains(a.m)){
			
			d=QueryMobilePhoneSet(u.get(i)).size()-1;
			
				L2.add(d, u.get(i).e);
		
		}
			
}
		for(int i=0;i<u.size();i++){
			if(j>QueryMobilePhoneSet(u.get(i)).size()&&QueryMobilePhoneSet(u.get(i)).contains(b.m)){
				
				L1.add(j-(QueryMobilePhoneSet(u.get(i)).size()),u.get(i).e);
				
			}
				
			}
		}

L2.addAll(L1);

for(int i=0;i<L2.size();i++){
	if((int)L2.get(i)!=999999){
	
		L.add(L2.get(i));
	}
	}

return L;
}
public void queryFindCallPath(MobilePhone m1,MobilePhone m2)	{
	int j=0;
	int k=0;
	for(int i=0;i<u.size();i++){
		if(u.get(i).base.contains(m1.m)){
	
		j=1;
		}
		
	}
	for(int i=0;i<u.size();i++){
		if(u.get(i).base.contains(m2.m)){
	
		k=1;
		}
		
	}
	
		if(j==1 && k==1)
			
	System.out.println(routeCall(m1,m2));
		else if(j==0 && k==0)
			System.out.println(m1.m+","+m2.m+" doesn't exist");
		else	if(j==0)
			System.out.println(m1.m+" doesn't exist");
		else if(k==0)
			System.out.println(m2.m+" doesn't exist");
}

public void movePhone(MobilePhone a, Exchange b){
	
	int k=0;
	int j=0;
	
	for(int i=0;i<u.size();i++){
		while(u.get(i).base.contains(a.m))
		{
			u.get(i).base.removeFirstOccurrence(a.m);
			j=1;
			break;
		}
	while(u.get(i).e==b.e){
		k=i;
		
		break;
	}
	
	}
	if(j==1)
	u.get(k).base.add(a.m);
	else if(j==0)
		System.out.println(a.m+" number doesnot exists ");

}
public void performAction(String actionMessage) {
		
	String A[]=actionMessage.split("\\W+");
	if (A[0].equals("addExchange"))
	{
		Exchange g=new Exchange(Integer.parseInt(A[1]));
	
	
	if(!rs.list.contains(g.e))
	u.add(g);
	rs.push(g.e);

		Exchange h=new Exchange(Integer.parseInt(A[2]));
	
	if(!rs.list.contains(h.e))
	u.add(h);
rs.push(h.e);

	
	addexchange(Integer.parseInt(A[1]),Integer.parseInt(A[2]));

	}
	
	if(A[0].equals("switchOnMobile")){
		MobilePhone a = new MobilePhone(Integer.parseInt(A[1]));
		
		Exchange b= new Exchange(Integer.parseInt(A[2]));
	
	
		switchOn(a,b);
	}
	if(A[0].equals("switchOffMobile")){
		MobilePhone a = new MobilePhone(Integer.parseInt(A[1]));
		switchOff(a);
	}
	
if(A[0].equals("queryMobilePhoneSet"))
{
	int b=191181;
	for(int i=0;i<u.size();i++){
	while(u.get(i).e==Integer.parseInt(A[1]))
	{
		b=i;
		break;
	}

	
}
	try{
	queryMobilePhoneSet(u.get(b));
}
	catch( java.lang.IndexOutOfBoundsException en){
		System.out.println(Integer.parseInt(A[1])+" exchange doesnot exists");
	}
}
if(A[0].equals("queryNthChild"))
{
Exchange a= new Exchange(Integer.parseInt(A[1]));
int b=191181;
	for(int i=0;i<u.size();i++){
	while(u.get(i).e==Integer.parseInt(A[1]))
	{
		b=i;
		break;
	}
	

}
try{
queryNthChild(u.get(b),Integer.parseInt(A[2]));
}	
catch(java.lang.IndexOutOfBoundsException en){
	System.out.println(Integer.parseInt(A[1])+" exchange doesnot exists ");
}
}
if(A[0].equals("findPhone")){
	MobilePhone m=new MobilePhone(Integer.parseInt(A[1]));
			queryFindPhone(m)	;	
}
if(A[0].equals("lowestRouter")){
	Exchange e1=new Exchange(Integer.parseInt(A[1]));
	Exchange e2=new Exchange(Integer.parseInt(A[2]));
	
	queryLowestRouter(e1,e2);
}
if(A[0].equals("movePhone")){
	int b=191111;
	MobilePhone m=new MobilePhone(Integer.parseInt(A[1]));
	Exchange e=new Exchange(Integer.parseInt(A[2]));
	for(int i=0;i<u.size();i++){
		while(u.get(i).e==Integer.parseInt(A[2])){
			if(u.get(i).exchangelist.isEmpty())
			b=i;
			break;
		}
	}
try{		
	movePhone(m,u.get(b));
}
catch(java.lang.IndexOutOfBoundsException en){
	int j=0;
	for(int i=0;i<u.size();i++){
		while(u.get(i).e==Integer.parseInt(A[2])){
		j=1;
		break;
		}
	}
	if(j==1)
	System.out.println(Integer.parseInt(A[2])+" not a base station");
	if(j==0)
		System.out.println( Integer.parseInt(A[2])+" exchange doesn't exists");
	
		
}
	
}
if(A[0].equals("findCallPath")){
	MobilePhone m1=new MobilePhone(Integer.parseInt(A[1]));
	MobilePhone m2=new MobilePhone(Integer.parseInt(A[2]));
	queryFindCallPath(m1,m2);
	
}
}
}