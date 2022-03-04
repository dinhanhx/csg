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
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");

        a.left = b;
        a.right = g;
        b.left = c;
        b.right = d;
        c.left = e;
        e.right = f;

        return a;
    }

}