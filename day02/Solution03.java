package day02;


import javax.swing.tree.TreeNode;

/**
 * 572. 另一棵树的子树
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */

class Solution03 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        else{
            return isSubtree(root.left,subRoot)||
                    isSubtree(root.right,subRoot);}
    }
    boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}
