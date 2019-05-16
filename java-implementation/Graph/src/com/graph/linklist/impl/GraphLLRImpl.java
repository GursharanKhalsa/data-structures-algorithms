package com.graph.linklist.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphLLRImpl {
	
	public static void main(String[] args) {
		GraphLL graph = new GraphLL(Arrays.asList("A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" ));
//		graph.addEdge("A", "B");
//		graph.addEdge("A", "C");
//		graph.addEdge("B", "D");
//		graph.addEdge("B", "E");
//		graph.addEdge("C", "F");
//		graph.addEdge("C", "G");
//		graph.addEdge("D", "H");
//		graph.addEdge("D", "I");
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("D", "I");
		graph.addEdge("E", "H");
		graph.addEdge("C", "F");
		graph.addEdge("F", "I");
		graph.addEdge("C", "G");		
		graph.addEdge("G", "H");
		graph.printGraph();
	}
}
class GraphLL {
	
	private int V; 
	private List<Vertex> vertexAdjList = new ArrayList<Vertex>();
	private Map<String,Integer> idsMap = new HashMap<String,Integer>();
	
	GraphLL(List<String> vertexs) {
		int v = 0;
		for(String name : vertexs) {
			Vertex c = new Vertex( v , name);
			this.vertexAdjList.add(c);
			this.idsMap.put(name, v);
			v++;
		}
		this.V = v;
	}
	
	void addVertex(String name) throws Exception {
		if( this.idsMap.get(name) != null)
			throw new Exception("Vertex is already exist");
		
		int newV = this.V +1;
		
		Vertex c = new Vertex( newV , name);
		
		this.vertexAdjList.add(c);
		this.idsMap.put(name, newV);
		this.V = newV;	
	}
	
	void addEdge(String source , String destination) {
		int sourceId = this.getVertexId(source);
		int destinationId = this.getVertexId(destination);
		
		Vertex sv = this.vertexAdjList.get(sourceId);
		sv.addConnection(new Connection(destinationId));
		
		Vertex dv = this.vertexAdjList.get(destinationId);
		dv.addConnection(new Connection(sourceId));
	}
	
	int getVertexId(String name) {
		return this.idsMap.get(name);
	}
	
	int getTotalVertex() {
		return this.V;
	}
	
	void printGraph()  {
	  for(Vertex v : this.vertexAdjList) {
		  System.out.println("Adjacency list of vertex "+ v.name); 
		  System.out.print("head"); 
		  this.printAdjArray(v.head);
		  System.out.println("\n"); 
	   } 
	} 
	
	void printAdjArray(Connection head) {
		if(head==null)
			return;
		System.out.print(" -> "+this.vertexAdjList.get(head.vertexId).name);
		if(head.next == null)
			return;
		printAdjArray(head.next);
	}
}
class Connection {
	public int vertexId;
	public Connection next;
	
	Connection(int vertexId , Connection next) {
		this.vertexId = vertexId;
		this.next = next;
	}
	
	Connection(int vertexId) {
		this.vertexId = vertexId;
	}
}
class Vertex {
	public int id;
	public String name;
	public Connection head;
	
	Vertex(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	Vertex(int id, String name, Connection head) {
		this.id = id;
		this.name = name;
		this.head = head;
	}
	
	void addConnection(Connection c) {
		Connection temp = head;
		this.head = c;
		this.head.next = temp;
	}
	
	void addConnection(int id) {
		Connection temp = head;
		this.head = new Connection(id);
		this.head.next = temp;
	}
}