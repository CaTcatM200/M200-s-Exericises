public class BinaryTree {

    public interface List<E> {
        int size();
        boolean isEmpty();
        E get(int i) throws IndexOutOfBoundsException;
        E set(int i,E e) throws IndexOutOfBoundsException;
        void add(int i,E e) throws IndexOutOfBoundsException;
        E remove(int i) throws IndexOutOfBoundsException;
    }

    public class ArrayBaseBinaryTree<E> implements List<E> {
        private int cpacity;
        private E[] data;
        private int size = 0;
        public ArrayBaseBinaryTree(int cpacity) {
            this.cpacity = cpacity;
            data = (E[]) new Object[cpacity];
        }

        protected void checkIndex(int i,int n) throws IndexOutOfBoundsException {
            if(i < 0||i >= n){
                throw new IndexOutOfBoundsException();
            }
        }

        protected void checkNull(int i) throws IllegalArgumentException {
            if(data[i] == null){
                throw new IllegalArgumentException();
            }
        }

        protected void attachIterator(E[] target,int i,int j) throws IndexOutOfBoundsException {
            checkIndex(i, target.length);
            checkIndex(j,cpacity);
            if(leftPosition(i) >= target.length){
                return;
            }
            if(target[leftPosition(i)] != null){
                addleft(j,target[leftPosition(i)]);
                attachIterator(target,leftPosition(i),leftPosition(j));
            }
            if(rightPosition(i) >= target.length){
                return;
            }
            if (target[rightPosition(i)] != null){
                addRight(j,target[rightPosition(i)]);
                attachIterator(target,rightPosition(i),rightPosition(j));
            }
            return;
        }

        protected int leftPosition(int i) {
            return i*2+1;
        }

        protected int rightPosition(int i) {
            return i*2+2;
        }

        protected int parentPosition(int i) throws IllegalArgumentException {
            if(i <= 0) throw new IllegalArgumentException();
            if(data[(i-1)/2] != null){
                return (i-1)/2;
            }else if(data[(i-2)/2] != null) {
                return (i-2)/2;
            }
            return 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E get(int i) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            return data[i];
        }

        public E set(int i, E e) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            data[i] = e;
            return e;
        }

        public void add(int i, E e) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            data[i] = e;
            size++;
        }

        public void addRoot(E e) {
            data[0] = e;
            size++;
        }

        public void addleft(int i, E e) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            add(leftPosition(i),e);
        }

        public void addRight(int i,E e) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            add(rightPosition(i),e);
        }

        public boolean haveLeftChild(int i) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            if(data[leftPosition(i)] == null) return false;
            return true;
        }

        public boolean haveRightChild(int i) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            if(data[rightPosition(i)] == null) return false;
            return true;
        }

        public boolean haveParent(int i) throws IndexOutOfBoundsException {
            checkIndex(i,cpacity);
            checkNull(i);
            if(data[parentPosition(i)] == null) return false;
            return true;
        }

        public E remove(int i) throws IndexOutOfBoundsException,IllegalArgumentException {
            checkIndex(i,cpacity);
            checkNull(i);
            E temp = data[i];
            if(haveLeftChild(i) && haveRightChild(i)){
                throw new IllegalArgumentException();
            }
            if(data[leftPosition(i)] != null){
                data[i] = data[leftPosition(i)];
                data[leftPosition(i)] = null;
            }else if(data[rightPosition(i)] != null){
                data[i] = data[rightPosition(i)];
                data[rightPosition(i)] = null;
            }else{
                data[i] = null;
            }
            size--;
            return temp;
        }

        public void attach(int i,E[] tree1,E[] tree2) throws IndexOutOfBoundsException,IllegalArgumentException {
            checkIndex(i,cpacity);
            checkNull(i);
            if(haveLeftChild(i) || haveRightChild(i)) throw new IllegalArgumentException();
            addleft(i,tree1[0]);
            addRight(i,tree2[0]);
            attachIterator(tree1,0,leftPosition(i));
            attachIterator(tree2,0,rightPosition(i));
        }
    }
}
