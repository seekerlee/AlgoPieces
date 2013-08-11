package io.github.seekerlee.algopieces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: seeker
 * Date: 8/11/13
 * Time: 4:30 PM
 */
public class DijkstraShortest {

    public static void main(String[] aaasd) throws IOException {
        InputStream in = KragerMinCut.class.getClassLoader().getResourceAsStream("dijkstraData.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        Node[] allNode = new Node[200];
        for(int i = 0; i < 200; i++) {
            allNode[i] = new Node(i);
        }
        while( (line = br.readLine()) != null ) {
            Scanner sc = new Scanner(line);
            int thisNodeId = sc.nextInt(); //node id
            Node thisNode = allNode[thisNodeId - 1];
            // edges:
            List<Edge> outEdge = new ArrayList<Edge>();
            while(sc.hasNext()) {
                String[] pa = sc.next().split(",");
                int nextId = Integer.valueOf(pa[0]);
                int nextDis = Integer.valueOf(pa[1]);
                outEdge.add(new Edge(thisNode, allNode[nextId - 1], nextDis));
            }
            thisNode.setOutEdge(outEdge);
        }
        // real job:
        List<Node> exploredNode = new ArrayList<Node>();
        allNode[0].setDistance(0);
        exploredNode.add(allNode[0]);
        doDij(exploredNode);
    }

    private static void doDij(List<Node> exploredNode) {
        //if(exploredNode.size() >= 200) return;
        Edge shortestE = null;
        // find shortest
        for(Node n : exploredNode) {
            List<Edge> outE = n.getOutEdge();
            for(Edge e : outE) {
                if(!e.desNode.isExplored()){
                    if(shortestE == null) {
                        shortestE = e;
                    } else {
                        if((e.thisNode.getDistance() + e.distance) < (shortestE.thisNode.getDistance() + shortestE.distance)) {
                            shortestE = e;
                        }
                    }
                }
            }
        }
        if(shortestE == null) return;
        shortestE.desNode.setDistance(shortestE.thisNode.getDistance() + shortestE.distance);
        exploredNode.add(shortestE.desNode);
        doDij(exploredNode);
    }
}

class Node {
    public final int id;
    private int distance = 1000000;
    private List<Edge> outEdge = new ArrayList<Edge>();
    private boolean explored = false;

    Node(int id) {
        this.id = id;
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        this.distance = distance;
        this.explored = true;
        if(id == 6 || id == 36 || id == 58 || id == 81 || id == 98 || id == 114 || id == 132 || id == 164 || id == 187 || id == 196) {
            System.out.println("shortest for id:" + (id + 1) + ": " + distance);
        }

    }

    List<Edge> getOutEdge() {
        return outEdge;
    }

    void setOutEdge(List<Edge> outEdge) {
        this.outEdge = outEdge;
    }

    boolean isExplored() {
        return explored;
    }
}
class Edge {
    public final Node thisNode;
    public final Node desNode;
    public final int distance;

    Edge(Node thisNode, Node desNode, int distance) {
        this.thisNode = thisNode;
        this.desNode = desNode;
        this.distance = distance;
    }
}
class Graph {

}