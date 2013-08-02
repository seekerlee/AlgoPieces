package io.github.seekerlee.algopieces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * User: seeker
 * Date: 7/31/13
 * Time: 9:51 PM
 */
public class KosarajuSCC {
    private int round1Number = 0;
    private Stack<DirectedGraph.Node> nodeStack = new Stack<DirectedGraph.Node>();
    private DirectedGraph dg;
    private int sccCount = 0;

    public KosarajuSCC() {
        try {
            dg = new DirectedGraph("SCC.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doSCC(DirectedGraph.Node n) {
        n.explored1(); // mark as explored
        for ( DirectedGraph.Node nextNode : n.getNextNodes() ) {
            if (nextNode.isExplored1()) continue;
            doSCC(nextNode);
        }
        nodeStack.push(n);
        //round1Number ++;
        //n.setFvalue( round1Number );
        //System.out.println( "Node " + n.id + "'s f value is " + round1Number );
    }

    public int doSCC2(DirectedGraph.Node n, int count) {
        n.explored2();
        count ++;
        for ( DirectedGraph.Node prevNode : n.getPrevNodes() ) {
            if (prevNode.isExplored2()) continue;
            int sonCount = doSCC2(prevNode, 0);
            count = count + sonCount;
        }
        return count;
    }

    public void round1() {
        Map<Integer, DirectedGraph.Node> nodeMap = dg.getNodeMap();
        for (DirectedGraph.Node n : nodeMap.values()) {
            if( n.isExplored1() ) continue;
            doSCC(n);
        }
    }

    public void round2() {
        while(nodeStack.size() > 0) {
            DirectedGraph.Node n = nodeStack.pop();
            if(!n.isExplored2()) {
                int count = doSCC2(n, 0);
                if(count > 100) {
                    System.out.println(count);
                }
            }
        }
    }

    public static void main(String[] ads) {
        System.out.println( new Date() + " -Init begin." );
        KosarajuSCC kscc= new KosarajuSCC();
        System.out.println( new Date() + " -Init done." );
        System.out.println( new Date() + " -Round 1 begin." );
        kscc.round1();
        System.out.println( new Date() + " -Round 1 done." );
        System.out.println( new Date() + " -Round 2 begin." );
        kscc.round2();
        System.out.println( new Date() + " -Round 2 done." );
    }
}
class DirectedGraph {
    private final Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

    public DirectedGraph(String fileName) throws IOException {

        InputStream in = KragerMinCut.class.getClassLoader().getResourceAsStream(fileName); //"SCC.txt"
        BufferedReader br = new BufferedReader(new InputStreamReader(in), 2097152); // 2mb
        String line;
        while( (line = br.readLine()) != null ) {
            Scanner sc = new Scanner(line);
            int thisNodeId = sc.nextInt(); //node id
            int nextNodeId = sc.nextInt(); //next node id
            Node thisNode;
            Node nextNode;
            // init thisNode
            if( nodeMap.containsKey(thisNodeId) ) {
                thisNode = nodeMap.get(thisNodeId);
            } else {
                thisNode = new Node(thisNodeId);
                this.nodeMap.put(thisNodeId, thisNode);
            }
            // init nextNode
            if( nodeMap.containsKey(nextNodeId) ) {
                nextNode = nodeMap.get(nextNodeId);
            } else {
                nextNode = new Node(nextNodeId);
                nodeMap.put(nextNodeId, nextNode);
            }
            thisNode.addNextNode(nextNode);
            nextNode.addPrevNode(thisNode);
        }
    }
    public class Node {
        private boolean explored1 = false;
        private boolean explored2 = false;
        public final int id;
        private int fvalue;
        private final List<Node> nextNodes = new ArrayList<Node>(5);
        private final List<Node> prevNodes = new ArrayList<Node>(5);

        public Node(int id) {
            this.id = id;
        }

        List<Node> getNextNodes() {
            return nextNodes;
        }

        public List<Node> getPrevNodes() {
            return prevNodes;
        }

        public void addNextNode(Node n) {
            this.nextNodes.add(n);
        }

        public void addPrevNode(Node n) {
            this.prevNodes.add(n);
        }

        int getFvalue() {
            return fvalue;
        }

        void setFvalue(int fvalue) {
            this.fvalue = fvalue;
        }

        public boolean isExplored1() {
            return explored1;
        }

        public void explored1() {
            this.explored1 = true;
        }

        public boolean isExplored2() {
            return explored2;
        }

        public void explored2() {
            this.explored2 = true;
        }
    }

    public Map<Integer, Node> getNodeMap() {
        return nodeMap;
    }
}