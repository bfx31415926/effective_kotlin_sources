package snippets.myDokka
/**
 * Immutable tree data structure.
 *
 * Class represents an immutable tree with from 1 to
 * an infinite number of elements. In the tree we hold
 * elements on each node, and nodes can have left and
 * right subtrees...
 *
 * @param T the type of elements this tree holds.
 * @property value the value kept in this node of the tree.
 * @property left the left subtree.
 * @property right the right subtree.
 */
class Tree<T>(
    val value: T,
    val left: Tree<T>? = null,
    val right: Tree<T>? = null
) {
    /**
     * Creates a new tree based on the current but with
     * [element] added.
     * @return newly created tree with additional element.
     */
    operator fun plus(element: T): Tree<T> { return this }
}
