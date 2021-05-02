public class Main {
    public class SinglyLinkedList<E>
    {
        private class Node<E>
        {
            private E name;
            private int score;
            private Node<E> next;
            public Node(E name, int score, Node<E> next)
            {
                this.name = name;
                this.score = score;
                this.next = next;
            }
            public E getName() {return name;}
            public int getScore() {return score;}
            public Node<E> getNext() {return next;}

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
        public SinglyLinkedList() {}
        public int getSize() {return size;}
        public boolean isEmpty() {return size == 0;}
        public void addLast(E name,int score)
        {
            Node<E> newest = new Node<>(name,score);
            if(isEmpty())
            {
                head = newest;
                tail = head;
            }
            else
            {
                tail.setNext(newest);
                tail = newest;
                size++;
            }

        }
        public void addNewscore(E name,int score)
        {
            if(isEmpty())
            {
                head = new Node<>(name,score,head);
                tail = head;
                size++;
            }
            else
            {
                int newScore = score;
                int nativeScore = head.getScore();
                int maximumScore = tail.getScore();
                SinglyLinkedList detachedlist = new SinglyLinkedList<>();
                for(int i=1;i<=size;i++);
                {
                    if(newScore>=maximumScore);
                    {
                        addLast(name,score);
                        break;
                    }
                    else if(newScore>=nativeScore)
                    {
                        detachedlist.addLast(head.getName(),head.getScore());
                        head = head.getNext();
                        nativeScore = head.getScore();
                    }
                    else
                    {
                        head = new Node<>(name,score,head);
                        break;
                    }
                }
                detachedlist.tail.setNext(head);
                head = detachedlist.head;
                if(size > 10)
                {
                    head = head.getNext();
                    size--;
                }
            }

        }
    }
}
