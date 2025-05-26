// Elgin Baylor
// May 26, 2025
// CS 142 - M8A2B

/**
 * Represents a node in the questioning-answer tree for a guessing game.
 * A node can be either:
 * - a leaf node represents a thing, and contains its name, or
 * - a non-leaf node represents a question and has child nodes (thing or question nodes) for yes and no answers.
 */
public class TreeNode {
    public String data;       // Question or a Name of a thing
    // The children, non-null only if this is a question node
    public TreeNode yesChild; // where to go if the user answers "yes"
    public TreeNode noChild;  // where to go if the user answers "no"

    //Constructor for a leaf node, which is just a name
    public TreeNode(String data) {
        this.data = data;
    }

    // Constructor for a non-leaf node:
    //  a question and paths for "yes" and "no" answers
    public TreeNode(String data, TreeNode yesChild, TreeNode noChild) {
        this.data = data;
        this.yesChild = yesChild;
        this.noChild = noChild;
    }

    // This node is a question node if it does not have both yes and no children.
    // (it is a question node if either yesChild or noChild is not null)
    public boolean isQuestion() {
        return (yesChild != null || noChild != null );

    }
}
