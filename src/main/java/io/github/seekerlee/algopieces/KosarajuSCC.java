package io.github.seekerlee.algopieces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User: seeker
 * Date: 7/31/13
 * Time: 9:51 PM
 */
public class KosarajuSCC {

    class DirectedGraph {
        private Map all = new HashMap<Integer, Integer>(400000);
        Map<Object,ArrayList<Object>> multiMap = new HashMap<Object,ArrayList<Object>>();
        public DirectedGraph(String fileName) throws IOException {

            InputStream in = KragerMinCut.class.getClassLoader().getResourceAsStream(fileName); //"SCC.txt"
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while( (line = br.readLine()) != null) {
                Scanner sc = new Scanner(line);
                int x = sc.nextInt();
                int y = sc.nextInt();
                Edges.put(x, y);
            }
        }
    }
    class Node {
        private boolean itr1 = false;
        private boolean itr2 = false;
        public final int id;
        public Node(int id) {
            this.id = id;
        }
    }
}
