package io.github.seekerlee.algopieces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * User: seeker
 * Date: 7/24/13
 * Time: 9:54 PM
 */
public class KragerMinCut {

    private Graph g;

    public class Graph {
        private Random Rand = new Random();
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
        private Edge selectEdge() {
            return edges.get(Rand.nextInt(edges.size()));
        }
        private void contractEdge(final Edge e) {
            final int ev1 = e.getV1();
            final int ev2 = e.getV2();
            //replace.ev1 <- ev2
            for(Edge et : edges) {
                if(et.getV1() == ev2) {
                    et.setV1(ev1);
                }
                if(et.getV2() == ev2) {
                    et.setV2(ev1);
                }
            }
            //remove self points.
            Iterator<Edge> itr = edges.iterator();
            while (itr.hasNext()) {
                Edge et = itr.next();
                if(et.getV1() == et.getV2()) {
                    itr.remove();
                }
            }
        }
        public int getEdgesCount() {
            return edges.size() / 2;
        }
        public void doAlgo() {
            for(int i = 0; i < 198; i++) {
                this.contractEdge(this.selectEdge());
                //System.out.println(i);// + "--" +this);
            }
        }
    }
    public class Edge {
        private int v1;
        private int v2;
        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        public String toString() {
            return "(" + v1 + "," + v2 + ")";
        }

        public int getV1() {
            return v1;
        }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public int getV2() {
            return v2;
        }

        public void setV2(int v2) {
            this.v2 = v2;
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
                g.addEdge(new Edge(x, y));
            }
        }
    }
    public static void main(String[] ads) throws IOException {
        int min = 99999;
        for(int i = 0; i < 100; i++) {
            KragerMinCut kmc = new KragerMinCut();
            //System.out.println(kmc.g);
            kmc.g.doAlgo();
            //System.out.println(kmc.g);
            //System.out.println(kmc.g.getEdgesCount());
            if (kmc.g.getEdgesCount() < min) {
                min = kmc.g.getEdgesCount();
            }
        }
        System.out.println(min);
    }

}
