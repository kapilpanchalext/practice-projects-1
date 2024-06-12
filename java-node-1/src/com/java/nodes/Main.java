package com.java.nodes;

public class Main {

	public static void main(String[] args) {
//		LinkedList linkedList = new LinkedList();
//
//	    // Adding nodes to the linked list
//	    linkedList.append(1);
//	    linkedList.append(2);
//	    linkedList.append(3);
//
//	    // Displaying the linked list
//	    System.err.println("Linked List: ");
//	    linkedList.display();
//		 Create a node and set data
//        Node myNode = new Node(42);
//        SomeData someData = new SomeData();
//        someData.setName("Name");
//        someData.setAge(12);
//        
//        Node someDataNode = new Node(someData);
//        
//        someDataNode.setData();
//
//        // Retrieve and print the data
//        int retrievedData = myNode.getData();
//        System.err.println("Retrieved Data: " + retrievedData);
//
//        // Set new data
//        myNode.setData(99);
//
//        // Retrieve and print the updated data
//        int updatedData = myNode.getData();
//        System.err.println("Updated Data: " + updatedData);
		
		SomeData someData = new SomeData();
	    	someData.setName("Name1");
	    	someData.setAge(12);
	  	
	    SomeData someData1 = new SomeData();
	      	someData1.setName("Name2");
	      	someData1.setAge(11);

		Node myNode1 = new Node(someData);
		Node myNode2 = new Node(someData1);
		myNode1.setNext(myNode2);
		System.err.println("Updated Data: " + myNode1);
		System.err.println("Updated Data: " + myNode1.getNext().getData());
	}
}
