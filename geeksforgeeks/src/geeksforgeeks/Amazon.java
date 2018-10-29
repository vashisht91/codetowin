package geeksforgeeks;

/*Given a binary tree and value - sum, find all paths 
in the tree that add up to that sum. Path are all downwards.

        1                                                                                 
     /     \
   3         -1   
 /   \     /   \
2     1   4     5                        
     /   / \     \                    
    1   1   2     6
  
Sum = 5

1,3,1 -> possible solution.
1,-1,5
11,-1,4,

sum   arrayCounter  stack   tracker   paths 
0
*/

public class BinaryTreeSum {
    private int sum=0;
    private int arrayCounter=0;
    private List<String> paths = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        
        
    }
    
    
    public String[] findPaths(BinaryTree tree) {
        Stack stack = new Stack();
        int[] tracker = new int[tree.size()];
        Node currentNode = tree.getRootNode();
         
        traverse(currentNode, stack, tracker);
    }
    
    
    public void traverse(Node node, Stack stack, int[] tracker) {
            stack.push(node.getData());
            sum+=node.getData();
            if(sum==5) {
                String str = "";
                for(int i=0;i<arrayCounter;i++) {
                    str.append(tracker[i]+",");
                }
                path.add(str);
            }
            if(sum + node.getData()<5) {
                tracker[arrayCounter++]=node.getData();
            }
            
            if(node.getLeftNode!=null) {
                traverse(node, stack, tracker);
            }
            if(node.getRightNode!=null) {
                traverse(node, stack, tracker);
            }
            if(node.getLeftNode==null) {
                sum -= stack.pop();
                arrayCounter--;
            }
            if(node.getRightNode==null) {
                sum -= stack.pop();
                arrayCounter--;
            }
        
        } 
        
    }
    
}



public class BinaryTree {
    private Node rootNode;
    
    public BinaryTree(){}
    public BinaryTree(Node node){}
    
    public boolean insert(int data){}
    public boolean delete(int data){}
    public void traverse(){}
    
    class Node {
        private int data;
        private int nextNode;
        
        public Node() {}
        public Node(int data) {}
        
        public getData() {
            return this.data;
        }
        
        public setData(){}
        public getNextNode(){}
        public setNextNode(){}
    }
}
