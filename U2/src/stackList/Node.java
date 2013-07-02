package stackList;


class Node implements List
{
     Integer elementData; //data of node
     String elementString;
     Node next; 

     
     public Node (Integer element, Node  tail){ 
          this.elementData = element;
          this.next = tail;
     }     
     
     public Node (String object, Node tail){
         this.elementString = object;
         this.next = tail;
     }
    
     
     @Override
     public Integer getElement(){
          return elementData;
     }
     
     @Override
     public Node getTail(){
          return next;
     }
     
     @Override
     public int getLength(){
    	 int count = 1;
    	 if(next != null){
    		 count += next.getLength();
    	 }
    	 return count;
     }
}
