package letto.offer.tree;

public class AVLDemo {

    public static void main(String[] args) {
        AVLTree avlt=new AVLTree();
        int []arr={10,7,11,6,8,9};
        //循环添加结点到二叉排序树
        for(int tmp:arr){
            avlt.add(new AVLNode(tmp));
        }
        //中序遍历
        avlt.infixOrder();

//        //测试结点的高度
//        System.out.println(avlt.getRoot()+"\t"+avlt.getHeight());
//        for(int tmp:arr){
//            System.out.println(tmp+"  "+avlt.search(tmp).getHeight());
//        }
    }
}


class AVLTree{
    private AVLNode root;

    public AVLTree() {
        super();
        // TODO Auto-generated constructor stub
    }
    public AVLTree(AVLNode root) {
        super();
        this.root = root;
    }
    public AVLNode getRoot() {
        return root;
    }
    public void setRoot(AVLNode root) {
        this.root = root;
    }

    //添加结点的方法
    public void add(AVLNode node){
        if(root==null){
            root=node;
        }
        else{
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root==null){
            System.out.println("该二叉树为空");
        }
        else{
            root.infixOrder();
        }
    }

    //查找结点
    public AVLNode search(int value){
        if(root==null){
            System.out.println("该二叉树为空");
        }
        return root.search(value);
    }

    //树的高度
    public int getHeight(){
        if(root==null){
            return 0;
        }
        return root.getHeight();
    }
}



class AVLNode{
    private int value;
    private AVLNode left;
    private AVLNode right;

    public AVLNode() {
        super();
    }

    public AVLNode(int value) {
        super();
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode [value=" + value + "]";
    }

    /**
     * 向二叉排序树添加结点
     * @param node
     */
    public void add(AVLNode node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.setLeft(node);
            }
            else{
                this.left.add(node);
            }
        }
        else{
            if(this.right==null){
                this.setRight(node);
            }
            else{
                this.right.add(node);
            }
        }

        //当添加完一个结点后，如果：（右子树的高度-左子树的高度）>1，左旋转
        if(this.getRightHeight()-this.getLeftHeight()>1){
            //如果它的右子树的左子树高度大于它的左子树高度，双旋转
            if(this.right!=null&&this.right.getLeftHeight()>this.getLeftHeight()){
                //先对这个结点的右节点进行右旋转
                this.right.rightRotate();
            }
            //再对当前结点进行左旋转即可。
            this.leftRotate();
        }
        //当添加完一个结点后，如果：（左子树的高度-右子树的高度）>1，右旋转
        else if(this.getLeftHeight()-this.getRightHeight()>1){
            //如果它的左子树的右子树高度大于它的右子树高度，双旋转
            if(this.left!=null&&this.left.getRightHeight()>this.getRightHeight()){
                //先对这个结点的左节点进行左旋转
                this.left.leftRotate();
            }
            //再对当前结点进行右旋转即可。
            this.rightRotate();
        }
        else{
            return;
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.getLeft()!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.getRight()!=null){
            this.right.infixOrder();
        }
    }

    //查找要删除结点
    public AVLNode search(int value){
        if(this.value==value){
            return this;
        }
        //左子树查找
        if(value<this.value){
            if(this.left==null){
                return null;
            }
            else{
                return this.left.search(value);
            }
        }
        //右子树查找
        else{
            if(this.right==null){
                return null;
            }
            else{
                return this.right.search(value);
            }
        }
    }

    //求该结点的高度
    public int getHeight(){
        return Math.max(this.left==null?0:this.left.getHeight(),this.right==null?0:this.right.getHeight())+1;    //妙
    }

    //左节点的高度
    public int getLeftHeight(){
        if(this.left==null){
            return 0;
        }
        else{
            return this.left.getHeight();
        }
    }
    //右节点的高度
    public int getRightHeight(){
        if(this.right==null){
            return 0;
        }
        else{
            return this.right.getHeight();
        }
    }

    //左旋
    public void leftRotate(){
        //创建新的左子树
        //创建新的结点，以当前根结点的值
        AVLNode node=new AVLNode(this.value);
        //把新的结点的左子树设置成当前结点的左子树
        node.left=this.left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        node.right=this.right.left;

        //创建新的根结点
        //把当前结点的值替换成右子结点的值
        this.value=this.right.value;

        //（根结点+右子树）
        //把当前结点的右子树设置成当前结点右子树的右子树
        this.right=this.right.right;

        //(根结点+右子树+左子树)
        //把当前结点的左子树(左子结点)设置成新的结点
        this.left=node;
    }

    //右旋
    public void rightRotate(){
        //创建新的右子树
        //创建新的结点，以当前根结点的值
        AVLNode node=new AVLNode(this.value);
        //把新的结点的右子树设置成当前结点的右子树
        node.right=this.right;
        //把新的结点的左子树设置成带你过去结点的左子树的右子树
        node.left=this.left.right;

        //创建新的根结点
        //把当前结点的值替换成右子结点的值
        this.value=this.left.value;

        //（根结点+左子树）
        //把当前结点的左子树设置成当前结点左子树的左子树
        this.left=this.left.left;

        //(根结点+右子树+左子树)
        //把当前结点的左子树(左子结点)设置成新的结点
        this.right=node;
    }
}
