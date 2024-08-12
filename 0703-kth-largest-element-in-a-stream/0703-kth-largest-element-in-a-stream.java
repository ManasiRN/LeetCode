class KthLargest {

private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll(); 
        }
    }
    
    public int add(int val) {
        pq.offer(val); 
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
    public static void main(String[] args) {
        // Define k and the initial array
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        // Create an instance of KthLargest
        KthLargest kthLargest = new KthLargest(k, nums);

        // Test the add method and print the results
        System.out.println(kthLargest.add(3));  // Expected output: 4
        System.out.println(kthLargest.add(5));  // Expected output: 5
        System.out.println(kthLargest.add(10)); // Expected output: 5
        System.out.println(kthLargest.add(9));  // Expected output: 8
        System.out.println(kthLargest.add(4));  // Expected output: 8
    }
} 


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */