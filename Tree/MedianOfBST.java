package Tree;

import java.util.ArrayList;
import java.util.List;

public class MedianOfBST {
    static List<Float> list;
    
    MedianOfBST() {
        list = new ArrayList<Float>();
    }
    
    public static float findMedian(Node root)
    {
        if(root==null) return 0.0f;
        findMedian(root.left);
        list.add(Float.valueOf(root.data));
        findMedian(root.right);
        
        return median();
    }
    public static float median(){
        int size = list.size();
        if(size%2 != 0) return list.get(size/2);
        else{
            float a = list.get(size/2);
            float b = list.get((size/2) -1);
            return (a+b)/2;
        }
    }
}
