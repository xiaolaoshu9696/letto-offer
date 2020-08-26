package letto.offer.tree;

import sun.util.locale.provider.AvailableLanguageTags;

public class avl {
    class AVLNode {
        int data;
        int depth;
        int balance;
        AVLNode parent;
        AVLNode left;
        AVLNode right;

        public AVLNode(int data) {
            this.data = data;
            depth = 1;
            balance = 0;
            left = null;
            right = null;
        }
    }

    public void insert(AVLNode root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new AVLNode(data);
                root.left.parent = root;
            }
        }
        else {
            if (root.right!=null){
                insert(root.right, data);
            }else {
                root.right = new AVLNode(data);
                root.right.parent = root;
            }
        }
        root.balance = calcBalance(root);
        if (root.balance>=2){
            if (root.left.balance==-1){
                left_rotate(root.left);
            }
            right_rotate(root);
        }
        if (root.balance<=-2){
            if (root.right.balance==1){
                right_rotate(root.right);
            }
            left_rotate(root);
        }
        root.balance = calcBalance(root);
        root.depth = calcDepth(root);
    }
    //右旋
    public void right_rotate(AVLNode p){
        //一次旋转涉及到的节点包括祖父，父亲，右儿子
        AVLNode pParent = p.parent;
        AVLNode pLeftSon = p.left;
        AVLNode pRightGrandSon = pLeftSon.right;
        //左子变父
        pLeftSon.parent = pParent;
        if (pParent!=null){
            if (p==pParent.left){
                pParent.left = pLeftSon;
            }else if (p==pParent.right){
                pParent.right = pLeftSon;
            }
        }
        pLeftSon.right = p;
        p.parent = pLeftSon;
        //右孙变左孙
        p.left = pRightGrandSon;
        if (pRightGrandSon!=null){
            pRightGrandSon.parent = p;
        }
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);
        pLeftSon.depth = calcDepth(pLeftSon);
        pLeftSon.balance = calcBalance(pLeftSon);

    }

    public void left_rotate(AVLNode p){
        AVLNode pParent = p.parent;
        AVLNode pRightSon = p.right;
        AVLNode pLeftGrandSon = pRightSon.left;
        //右子变父
        pRightSon.parent = pParent;
        if (pParent!=null){
            if (p==pParent.right){
                pParent.right = pRightSon;
            }
            if (p==pParent.left){
                pParent.left = pRightSon;
            }
        }
        pRightSon.left = p;
        p.parent = pRightSon;
        //左孙变右孙
        p.right = pLeftGrandSon;
        if (pLeftGrandSon!=null){
            pLeftGrandSon.parent = p;
        }
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);
        pRightSon.depth = calcDepth(pRightSon);
        pRightSon.balance = calcBalance(pRightSon);


    }

    public int calcBalance(AVLNode p){
        int left_depth;
        int right_depht;
        if (p.left!=null){
            left_depth = p.left.depth;
        }else left_depth = 0;
        if (p.right!=null){
            right_depht = p.right.depth;
        }else right_depht = 0;
        return left_depth-right_depht;
    }
    public int calcDepth(AVLNode p){
        int depth = 0;
        if (p.left!=null){
            depth = p.left.depth;
        }
        if (p.right!=null && depth<p.right.depth){
            depth = p.right.depth;
        }
        depth++;
        return depth;
    }


    }
