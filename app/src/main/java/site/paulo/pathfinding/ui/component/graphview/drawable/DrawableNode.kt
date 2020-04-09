package site.paulo.pathfinding.ui.component.graphview.drawable

import android.graphics.RectF
import site.paulo.pathfinding.data.model.Node

class DrawableNode (val id: Int, var centerX: Float, var centerY: Float) {

    lateinit var rect: RectF
    val node: Node
    var connectedTo: HashMap<Int, DrawableNode> = HashMap()

    companion object {
        const val DIAMETER = 100f
        const val RADIUS = DIAMETER / 2
    }

    init {
        rect = RectF(
            centerX - RADIUS,
            centerY - RADIUS,
            centerX + RADIUS,
            centerY + RADIUS)
        node = Node(id.toString(), Pair(centerX.toInt(), centerY.toInt()))
    }

    fun updatePosition(x: Float, y: Float) {
        centerX = x;
        centerY = y
        rect.left = centerX - RADIUS
        rect.top = centerY - RADIUS
        rect.right = centerX + RADIUS
        rect.bottom = centerY + RADIUS
    }
}