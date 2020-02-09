package site.paulo.shortestpath.data.model

class Node(val name: String, val position: Pair<Int, Int>) : Comparable<Node> {
    var edges: HashMap<String, Edge> = HashMap()
    /**
     * Shortest distance from S to V
     */
    var shortestPath = Double.POSITIVE_INFINITY
    /**
     * Connection to previous node of the shortest distance
     */
    var previous: Edge? = null

    fun connect(nodeToConnect: Node, weight: Double = 1.0) {
        val edge = Edge(this, nodeToConnect, weight)
        this.edges[nodeToConnect.name] = edge
        nodeToConnect.edges[this.name] = edge
    }

    fun disconnect(nodeToDisconnect: Node) {
        this.edges[nodeToDisconnect.name]?.connected = false
    }

    fun getAdjacentNodes(): ArrayList<Node> {
        val nodes = ArrayList<Node>()
        for (edge in edges.values) {
            nodes.add(edge.getOpposite(this))
        }

        return nodes
    }

    override fun compareTo(other: Node): Int {
        if (this.shortestPath > other.shortestPath) return 1
        if (this.shortestPath < other.shortestPath) return -1
        return 0
    }
}