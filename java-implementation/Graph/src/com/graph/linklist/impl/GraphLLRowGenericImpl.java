package com.graph.linklist.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphLLRowGenericImpl {

	public static void main(String[] args) {
//		GraphLLRG<String> graph = new GraphLLRG<String>(Arrays.asList("A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" ));
//		graph.addEdge("A", "B");
//		graph.addEdge("A", "C");
//		graph.addEdge("B", "D");
//		graph.addEdge("B", "E");
//		graph.addEdge("D", "I");
//		graph.addEdge("E", "H");
//		graph.addEdge("C", "F");
//		graph.addEdge("F", "I");
//		graph.addEdge("C", "G");		
//		graph.addEdge("G", "H");

		GraphLLRG<Integer> graph = new GraphLLRG<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

//		graph.printGraph();
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex " + 0 + " )");
		graph.bfs(0);
		
		System.out.println("Following is Depth First Traversal");
		graph.DFS();
	}
}

class GraphLLRG<T> {

	private int V = 0;
	private List<VertexG<T>> vertexAdjList = new ArrayList<VertexG<T>>();
	private Map<T, Integer> idsMap = new HashMap<T, Integer>();

	GraphLLRG(List<T> vertexs) {
		for (T ver : vertexs) {
			try {
				this.addVertex(ver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void addVertex(T ver) throws Exception {
		if (this.idsMap.get(ver) != null)
			throw new Exception("Vertex is already exist");
		VertexG<T> c = new VertexG<T>(this.V, ver);
		this.vertexAdjList.add(c);
		this.idsMap.put(ver, this.V);
		this.V++;
	}

	void addEdge(T source, T destination) {
		int sourceId = this.getVertexId(source);
		int destinationId = this.getVertexId(destination);
		VertexG<T> sv = this.vertexAdjList.get(sourceId);
		sv.addConnection(new ConnectionG(destinationId));
		VertexG<T> dv = this.vertexAdjList.get(destinationId);
		dv.addConnection(new ConnectionG(sourceId));
	}

	int getVertexId(T id) {
		return this.idsMap.get(id);
	}

	int getTotalVertex() {
		return this.V;
	}

	void printGraph() {
		for (VertexG<T> v : this.vertexAdjList) {
			System.out.println("Adjacency list of vertex " + v.name.toString());
			System.out.print("head");
			this.printAdjArray(v.head);
			System.out.println("\n");
		}
	}

	void printAdjArray(ConnectionG head) {
		if (head == null)
			return;
		System.out.print(" -> " + this.vertexAdjList.get(head.vertexId).name);
		if (head.next == null)
			return;
		printAdjArray(head.next);
	}

	void bfs(T source) {
		boolean visited[] = new boolean[this.V];
		LinkedList<T> queue = new LinkedList<T>();
		visited[this.getVertexId(source)] = true;
		queue.add(source);

		while (queue.size() != 0) {
			source = queue.poll();
			System.out.print(source + " ");

			VertexG<T> v = this.vertexAdjList.get(this.getVertexId(source));

			ConnectionG next = v.head;

			while (next != null) {
				if (!visited[next.vertexId]) {
					visited[next.vertexId] = true;
					queue.add(this.vertexAdjList.get(next.vertexId).name);
				}
				next = next.next;
			}
		}
	}

	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(this.vertexAdjList.get(v).name + " ");
		VertexG<T> ver = this.vertexAdjList.get(v);
		ConnectionG next = ver.head;
		while (next != null) {
			if (!visited[next.vertexId]) {
				DFSUtil(next.vertexId, visited);	
			}
		}
	}

	void DFS() { 
		boolean visited[] = new boolean[V];
		for(Integer i : this.idsMap.values())
			if (visited[i] == false)
				DFSUtil(i, visited);
	}
}

class ConnectionG {

	public int vertexId;
	public ConnectionG next;

	ConnectionG(int vertexId, ConnectionG next) {
		this.vertexId = vertexId;
		this.next = next;
	}

	ConnectionG(int vertexId) {
		this.vertexId = vertexId;
	}
}

class VertexG<T> {

	public int id;
	public T name;
	public ConnectionG head;

	VertexG(int id, T name) {
		this.id = id;
		this.name = name;
	}

	VertexG(int id, T name, ConnectionG head) {
		this.id = id;
		this.name = name;
		this.head = head;
	}

	void addConnection(ConnectionG c) {
		ConnectionG temp = head;
		this.head = c;
		this.head.next = temp;
	}

	void addConnection(int id) {
		ConnectionG temp = head;
		this.head = new ConnectionG(id);
		this.head.next = temp;
	}
}