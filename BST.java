public class BST<T> {


    class BSTNode{

        Comparable data;

        BSTNode left;

        BSTNode right;


        public BSTNode(Comparable data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    private BSTNode root;

    public BST(){
        root = null;
    }

    public void print(){
        print(root);
    }

    //print node
    private void print(BSTNode node){

        if(node != null){
            print(node.left);

            System.out.println(node.data); //prints data so grader can check alphabetical order

            print(node.right);
        }
    }


    public boolean find(Comparable value){
        return find(root, value);
    }


    //find node
    private boolean find(BSTNode node, Comparable value){
        if(node==null){
            return false;
        }
        if(node.data.compareTo(value) == 0){
            return true;
        }
        else if(node.data.compareTo(value) > 0){
            return find(node.left,value);
        }
        else{
            return find(node.right,value);
        }
    }
    public void insert(Comparable value){
        root = insert(root, value);
    }

    //insert node
    private BSTNode insert(BSTNode node, Comparable value){
        if(node==null){
            BSTNode newNode = new BSTNode(value);
            return newNode;
        }
        else if(node.data.compareTo(value) < 0){
            node.right = insert(node.right, value);
        }
        else{
            node.left = insert(node.left, value);
        }
        return node;
    }

    public void delete(Comparable value){
        root = delete(root, value);
    }




    //delete node
    private BSTNode delete(BSTNode node, Comparable value){
        if(node == null){

            return null;
        }

        if(node.data.compareTo(value) == 0){
            if(node.left == null){

                return node.right;
            }
            else if(node.right == null){

                return node.left;
            }

            else {
                if(node.right.left == null){

                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                }
                else{
                    node.data = removeMin(node.right);
                    return node;
                }
            }
        }
        else if(node.data.compareTo(value)<0){
            node.right = delete(node.left, value);
        }
        else{
            delete(node.left,value);
        }
        return node;
    }

    Comparable removeMin(BSTNode node){

        if(node.left.left == null){

            Comparable min = node.left.data;
            node.left = node.left.right;
            return min;
        }
        else{
            return removeMin(node.left);
        }
    }



}