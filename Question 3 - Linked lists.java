/* Question 3 - Linked lists */

    public class IntNode {
        private int _value;
        private IntNode _next;
        public IntNode(int val, IntNode n) {
            _value = val;
            _next = n;
        }
        public int getValue() {
            return _value;
        }
        public IntNode getNext() {
            return _next;
        }
        public void setValue(int v) {
            _value = v;
        }
        public void setNext(IntNode node) {
            _next = node;
        }
    }

    public class TwoIntLists {
        private IntNode _listA, _listB;
        public TwoIntLists (IntNode first, IntNode second) {
            _listA = first;
            _listB = second;
        }
    }

    public class IntList {
        private IntNode _head;

        public IntList( ) {
            _head = null;
        }
        public IntList (IntNode node) {
            _head = node;
        }
        public TwoIntLists split(){
            IntNode a; // scanning pointers
            IntNode b;
            IntNode temp = _head.getNext(); // highest diff pointer
            IntNode a_list = new IntNode(0, null); // actual lists
            IntNode b_list = new IntNode(0, null);
            IntNode a_head = a_list;
            IntNode b_head = null;
            IntNode a_link = null;
            IntNode b_link = b_head;
            IntNode b_prev = _head;

            int diff = 0;
            a = _head;
            b = _head.getNext();

            a_head.setValue(_head.getValue());
            a_head.setNext(_head.getNext());

            while(b.getNext() != null){
                if(Math.abs((b.getValue() - a.getValue())) >= diff){
                    diff = Math.abs(b.getValue() - a.getValue());
                    temp = b;
                    b = b.getNext();
                    b_prev = b_prev.getNext();
                }
                else{
                    b = b.getNext();
                    b_prev = b_prev.getNext();
                }

            }
            if(b.getNext() == null){
                if(Math.abs((b.getValue() - a.getValue())) >= diff) {
                    diff = Math.abs(b.getValue() - a.getValue());
                    temp = b;
                }

                if(b_head == null) { // if the list wasn't created yet..
                    b_list.setValue(temp.getValue());
                    b_list.setNext(null);
                    b_head = b_list;

                }
                else{
                    b_list.setValue(temp.getValue());
                    b_link.setNext(b_list);
                    b_link = b_list; // advance after linking the nodes.
                    }

                //add a to a_list, advance pointer a
                if(a_link == null){
                    a_link = _head.getNext(); // if its the first time, link the first nodes.
                    a_head.setNext(a_link);}
                else{
                    a_link.setValue(a.getValue());
                    a_link.setNext(a.getNext());
                    a = a.getNext();
                }

                // remove the b node
                b_prev.setNext(null);

                // set b to a.getNext if not null
                if(a.getNext() != null){
                    b = a.getNext();
                    b_prev = a;
                    temp = b;
                    diff = Math.abs(b.getValue() - a.getValue());
                }
                else{
                    if(a.getNext().getNext() != null) // if theres a gap in the list, assign b to nearest non null node.
                        b = a.getNext().getNext();
                        b_prev = null;
                }
            }
            return TwoIntLists(a_head, b_head);
        }
    }
