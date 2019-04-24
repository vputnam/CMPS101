public class SLItemList{

   // private inner Item class
   public class SItem{
      String UID;
      int CID;
      SItem next;

      SItem(String x, int y){
         UID = x;
         CID = y;
         next = null;
      }
   }

   // Fields for the SLItemList class
   public SItem head;     // reference to first Item in List
   private int numItems;  // number of pairs in this List

   // SLItemList()
   // constructor for the SLItemList class
   public SLItemList(){
      head = null;
      numItems = 0;
   }

   //ADT operations-------------------------------------------

   private SItem find(String x){
      SItem N = head;
      for(int i=1; i<= numItems; i++){
         if( N.UID.compareTo(x) == 0){
            return N;
         }else{
            N= N.next;
         }
       }
       return null;
   }
 
   // isEmpty()
   // pre: none
   // post: returns true if this SLItemList is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of Items in this SLItemList
   public int size() {
      return numItems;
   }


   // lookup()
   // pre: 1 <= index <= size()
   // post: returns item at position index in this SLItemList
   public SItem lookup(String x){
      SItem temp = find(x);
      if( temp != null){
         return temp;
      }else{
         return null;
      }
   }

   // pushFront()
   // inserts a new (UID, CID) to the SLItemList
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), pairs to the right of the new pair are renumbered
	public void pushFront(String x, int y){
		if(lookup(x) == null){
         if(head == null){
            SItem N = new SItem(x,y);
            head = N;
            head.next = null;
            numItems++;
          }else{
            SItem N = new SItem(x,y);
            N.next = head;
            head = N;
            numItems++;
            }
         }
		/*if(lookup(x)==null){
			// Insert at Head
			SItem N = new SItem(x, y);
			N.next = head;
			head = N;
		}*/
	}
   

   // toString()
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
		StringBuffer sb = new StringBuffer();
		SItem N = head;

		for( ; N!=null; N=N.next){
			//sb.append(N.UID+" "+N.CID+System.getProperty("line.separator"));
			sb.append(N.UID+", ");
		}
		return new String(sb);
   }





}

