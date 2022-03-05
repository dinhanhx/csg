package tree;

public class TreeAlgorithms {

    public static void preorderTraversal(TreeNode n) {
        if(n == null)
            return;
        System.out.println(n.value+" ");
        preorderTraversal(n.left);
        preorderTraversal(n.right);
    }

    public static void postorderTraversal(TreeNode n) {
        if(n == null)
            return;
        postorderTraversal(n.left);
        postorderTraversal(n.right);
        System.out.println(n.value+" ");
    }

    public static void inorderTraversal(TreeNode n) {
        if(n == null)
            return;
        inorderTraversal(n.left);
        System.out.println(n.value+" ");
        inorderTraversal(n.right);
    }

    public static TreeNode createData() {
        TreeNode a = new TreeNode("PrimitiveObject1");
        TreeNode b = new TreeNode("PrimitiveObject2");
        TreeNode c = new TreeNode("PrimitiveObject3");
        TreeNode d = new TreeNode("PrimitiveObject4");
        TreeNode e = new TreeNode("PrimitiveObject5");
        TreeNode f = new TreeNode("PrimitiveObject6");
        TreeNode g = new TreeNode("PrimitiveObject7");


        return a;
    }

}