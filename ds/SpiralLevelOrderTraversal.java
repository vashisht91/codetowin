package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


 
class Solution3 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Stack<TreeNode> sEven = new Stack<>();
        Stack<TreeNode> sOdd = new Stack<>();
        
        if(root == null)
            return res;
        
        sOdd.push(root);
        while(!sOdd.isEmpty() && !sEven.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            TreeNode curr = null;
            while(!sOdd.isEmpty()) {
                curr = sOdd.pop();
                if(curr.left != null){
                    sEven.push(curr.left);
                }
                if(curr.right!= null){
                    sEven.push(curr.right);
                }
                subList.add(curr.val);
            }
            
            System.out.println("sublist Odd : "+ subList);
            
            res.add(subList);
            
            System.out.println(" Res : "+ res);
            subList =  new ArrayList<>();            
            while(!sEven.isEmpty()){
                curr = sEven.pop();
                if(curr.right!= null){
                    sOdd.push(curr.right);
                }
                if(curr.left != null){
                    sOdd.push(curr.left);
                }
                subList.add(curr.val);
            }
            System.out.println("sublist Even : "+ subList);
            res.add(subList);
            
            System.out.println("Res: "+ res);
        }
        
        return res;
        
    }
}

public class SpiralLevelOrderTraversal {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            TreeNode ret = new Solution().sortedArrayToBST(nums);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}