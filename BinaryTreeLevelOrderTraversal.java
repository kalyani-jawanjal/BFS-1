import java.util.ArrayList;
import java.util.List;

//Time - O(n), Space - O(h), Approach - DFS- Recursive
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
