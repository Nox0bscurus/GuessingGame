// Elgin Baylor
// May 26, 2025
// CS 142 - M8A2B
// This took me a few hours, but was fun doing the polishing with the sleep. Its such more detailed than python's sleep(4)

/*

======REFLECTION QUESTIONS======
The Recursive Insight: Why is recursion is a natural fit (or isn’t) for traversing a tree structure. How does each recursive call correspond to moving through the tree?
ANSWER: I think its a good fit due to tree structures being recursive to begin with. Each recursive branches into yes or
no's for only that node. This continues throughout the tree.


Single Responsibility: The playOneRound( ) method traverses the tree, manages a game, AND modifies it when learning. Would it be better to separate these responsibilities into two or three methods? Why or why not?
ANSWER: No, although a good principle to follow, keeping designed this way introduces easier logic to follow. I think
the alternative would make for messier lines of code or classes when it could be perfect just how it is.


Tree Growth: After playing 20 rounds where the computer guessed wrong each time, what's the maximum depth the tree could have? What's the minimum? Explain your reasoning.
ANSWER: Max would be 20, min would be 5. If the tree grows straight, such as constantly saying yes, the max depth would be 20. But if the tree were to grow more balanced (not all yes's)
then the tree would have 5. Depth would depend on how much the ansers are split up.


Aha! Moment: Describe one moment during this assignment when something "clicked" for you about recursion, trees, or the combination of both
ANSWER: I think the moment would be realizing how those intuitive guessing games are built finally. I grew up playing those so
now being able to understand the magic behind the enjoyment is kinda mind blwoing.

 */
public class GuessingGame {
    public static void main(String[] args) {

        System.out.println("Welcome! To the Guessing Game!");
        // Added more dramatic pause
        try {
        Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("I am your Host: Phoebe Von Hainsworth, El's cat!");
        // Added more dramatic pause
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Now....let us *mrow* ahem, let us begin..." );
        // Added more dramatic pause
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Created tree with 3 structures
        TreeNode root = new TreeNode("Is it bigger than a breadbox?");
        root.yesChild = new TreeNode("Ant");
        root.noChild = new TreeNode("Mouse");

        // Loop to play more rounds at the end.
        do {
            playOneRound(root);
        } while (UserInput.askYesNo("Again?"));
    }
        // start of the game
        private static void playOneRound(TreeNode currentNode) {
            // Asking the questions
            if (currentNode.isQuestion()) {
                boolean answer = UserInput.askYesNo(currentNode.data);
                // if yes
                if (answer) {
                    playOneRound(currentNode.yesChild);
                // otherwise
                } else {
                    playOneRound(currentNode.noChild);
                }
            } else {
                // Come to a conclusion guess.
                boolean correct = UserInput.askYesNo("Are you thinking of " + currentNode.data + "?");
                if (correct) {
                    System.out.println("Noice");
                } else {
                    System.out.println("I need to learn about this!");

                    // Updated else block
                    String newItem = UserInput.getLine("What was you thinking of?");
                    // Asks for question
                    String newQuesion = UserInput.getLine(
                            "Please give me a yes/no question to distinguish a " + newItem + " from a " + currentNode.data + ":");
                    // Learns from question
                    boolean answerForNewItem = UserInput.askYesNo("For a " + newItem + ", what is the answer to: " + newQuesion);
                    String oldGuess = currentNode.data;

                    // Leaf into question node
                    currentNode.data = newQuesion;
                    if (answerForNewItem) {
                        currentNode.yesChild = new TreeNode(newItem);
                        currentNode.noChild = new TreeNode(oldGuess);
                    } else {
                        currentNode.yesChild = new TreeNode(oldGuess);
                        currentNode.noChild = new TreeNode(newItem);
                    }
                    System.out.println("Thanks! I'll remember that");
            }
        }
    }
}
