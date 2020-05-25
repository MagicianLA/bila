package com.bila.demo.structure.tree.binary;

import lombok.Data;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/05/22
 * @Modify By:
 */
@Data
public class TreeNode<T> {
    /**
     * 节点数据
     */
    private T value;
    /**
     * 数的深度
     */
    private int deep;
    /**
     * 节点数
     */
    private int nodeCount;
    /**
     * 左孩子树
     */
    private TreeNode<T> left;
    /**
     * 右孩子树
     */
    private TreeNode<T> right;
    /**
     * 父节点
     */
    private TreeNode<T> parent;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
