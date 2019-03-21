public class sLinkedList
{
    Node head;
    private int size = 0;//keep track of size
    private int[] arr;

    public void insertTail(int data)
    {
        //create new node
        Node node = new Node();
        //set its data
        node.data = data;

        //set: last node will always point to null
        node.next = null;

        //set the node as head if list is empty
        if (head == null)
        {
            head = node;
            size++;
        }

        //insert to tail if not empty
        else{
            Node n = head;
            //traverse from head, to tail
            while (n.next!=null)
            {
                n = n.next;
            }
            //if found the last node that has next == null,
            //set its next to the new created node
            n.next = node;
            size++;
        }
    }
    /**
     *Optional Method
     * Insert
     */
    public void insertHead(int data)
    {
        //create new node
        Node node = new Node();
        //set its data
        node.data = data;
        //first set the next of the newly created node to the current head
        node.next = head;
        //then set the new node as head
        head = node;
        size++;
    }

    public void printList()
    {
        Node node = head;

        while (node.next!=null)
        {
            System.out.println(node.data);
            node = node.next;
        }
        //print the last node's data
        System.out.println(node.data);
    }

    /**
     *Optional Method
     * Insertion for middle
     */
    public void insert(int Index, int data){
        int ctr = 0;
        Node n = head;
        //first, find the insertion point
        while(n.next!=null)
        {
            //Find the previous node of the target Index
            if (ctr+1==Index)//if found
            {
                //create new node
                Node node = new Node();
                //set its data
                node.data = data;

                /**
                 * The new node has a previous and next
                 */
                node.next = n.next;//set the reference of the new node
                n.next = node;//set the reference of the previous node to the new node
                size++;
                return;
            }
            n=n.next;
            ctr++;
        }
    }

    public void printSize(){
        System.out.println(size);
    }

    public int[] sortedList(int[] unsortedArray)
    {
        arr = new int[size];

        int ctr = 0;
        Node node = head;
        //migrate list contents to arr
        while (node.next!=null)
        {
            arr[ctr]=node.data;
            ctr++;
            node = node.next;
        }
            arr[ctr] = node.data;

        //sort arr
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        unsortedArray = arr;
        return unsortedArray;
    }

    public void printSortedList(){
        for (int ctr = 0; ctr<arr.length;ctr++)
        {
            System.out.println(arr[ctr]);
        }
    }
}
