package secondass;

import java.util.LinkedList;




interface Sets{
	
	
	LinkedList list=new LinkedList();
	LinkedList listo=new LinkedList();
	LinkedList inter=new LinkedList();
	
	

	   
public class Node 
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
	
 
	   
	public LinkedList  getUnion(Node head1, Node head);
	
	 
	public LinkedList  getIntersection(Node head1, Node head2);
	
	 
	public  void push(int new_data);
	  
	public Boolean IsEmpty();
	public void Insert(Object o);


	public Boolean IsMember(Object o);
	public void Delete(Object o);
}
public class Myset implements Sets {
	
	
    
	public LinkedList  getUnion(Node head1, Node head2)
  {
	
      Node t1 = head1, t2 = head2;

      while (t1 != null)
      {
       this.list.push(t1.data);
    	
          t1 = t1.next;
      
      }

      // insert those elements of list2 that are not present
     while (t2 != null)
      {
          
           this.list.push(t2.data);
        	  //push(t2.data);
          t2 = t2.next;
          
         
      }
		
		
		return list;
  }	
	public LinkedList  getIntersection(Node head1, Node head2){
		 
	       Node t1 = head1;
	       Node t2= head2;
	    
	       
	        // Traverse list1 and search each element of it in list2.
	        // If the element is present in list 2, then insert the
	        // element to result
	        while (t1 != null)
	     
	            
	        { this.listo.push(t1.data);
	            t1 = t1.next;
	        }
	        
	        while (t2 != null){
	        	this.listo.push(t2.data);
	            t2 = t2.next;
	        }
	      
	        return inter;
	}
	
	public  void push(int a){
		
	
	if(this.listo.contains(a))
		this.inter.add(a);
	this.listo.add(a);
		
		if(!this.list.contains(a))
			this.list.add(a);
			

		}
		
	      
 
 
	            

public Boolean IsEmpty() {
return this.list.isEmpty();
			
		}
		public Boolean IsMember(Object o){
			return this.list.contains(o);
		}
		public void Insert(Object o){
			this.list.add(o);
		}
		public void Delete(Object o){
			this.list.remove(o);
		}
		public  Myset Union(Myset a)	{
	
			
			
		return a;
			
		
	}
	

		
	}