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
 * Date: 7/24/13
 * Time: 9:54 PM
 */
public class KragerMinCut {

    private Graph g;

    public class Graph {
        private List<Edge> edges = new ArrayList<Edge>(50);
        public void addEdge(Edge e) {
            this.edges.add(e);
        }
        public String toString() {
            String s = "";
            for(Edge e : edges) {
                s += (e + ",");
            }
            return s;
        }
    }
    public class Edge {
        int v1;
        int v2;
        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        public String toString() {
            return "(" + v1 + "," + v2 + ")";
        }
    }
    public KragerMinCut() throws IOException {
        g = new Graph();
        InputStream in = KragerMinCut.class.getClassLoader().getResourceAsStream("kargerMinCut.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while( (line = br.readLine()) != null) {
            Scanner sc = new Scanner(line);
            int x = sc.nextInt();
            while(sc.hasNext()) {
                int y = sc.nextInt();
                if(x < y) g.addEdge(new Edge(x, y));
            }
        }
    }
    public static void main(String[] ads) throws IOException {
        System.out.println(new KragerMinCut().g);
    }

}
