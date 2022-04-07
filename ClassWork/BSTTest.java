public class BSTTest {
    public static void main(String[] args) {
        BST<String> bst = new BST<>();
        bst.add("Kiwi");
        bst.add("Strawberry");
        bst.add("Apple");
        bst.add("Banana");
        bst.add("Orange");
        bst.add("Lemon");
        bst.add("Watermelon");
        bst.inorder();
        bst.remove("Banana");
        System.out.println(bst.contains("Banana"));
        bst.inorder();
        bst.remove("Orange");
        bst.inorder();
        bst.remove("Kiwi");
        bst.inorder();



    }



    
}
