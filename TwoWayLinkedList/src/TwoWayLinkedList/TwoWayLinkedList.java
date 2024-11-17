	import java.util.ListIterator;
	import java.util.NoSuchElementException;

	public class TwoWayLinkedList<E> implements MyList<E> {
	    private Node<E> head, tail;
	    private int size = 0;

	    public TwoWayLinkedList() {
	    }

	    @Override
	    public void add(E e) {
	        if (tail == null) {
	            head = tail = new Node<>(e);
	        } else {
	            Node<E> newNode = new Node<>(e);
	            tail.next = newNode;
	            newNode.previous = tail;
	            tail = newNode;
	        }
	        size++;
	    }

	    @Override
	    public void add(int index, E element) {
	        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
	        if (index == 0) {
	            Node<E> newNode = new Node<>(element);
	            if (head == null) {
	                head = tail = newNode;
	            } else {
	                newNode.next = head;
	                head.previous = newNode;
	                head = newNode;
	            }
	        } else if (index == size) {
	            add(element);
	        } else {
	            Node<E> current = head;
	            for (int i = 0; i < index; i++) {
	                current = current.next;
	            }
	            Node<E> newNode = new Node<>(element);
	            newNode.next = current;
	            newNode.previous = current.previous;
	            current.previous.next = newNode;
	            current.previous = newNode;
	        }
	        size++;
	    }

	    @Override
	    public E remove(int index) {
	        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	        Node<E> current;
	        if (index == 0) {
	            current = head;
	            head = head.next;
	            if (head != null) head.previous = null;
	        } else if (index == size - 1) {
	            current = tail;
	            tail = tail.previous;
	            if (tail != null) tail.next = null;
	        } else {
	            current = head;
	            for (int i = 0; i < index; i++) {
	                current = current.next;
	            }
	            current.previous.next = current.next;
	            current.next.previous = current.previous;
	        }
	        size--;
	        return current.element;
	    }

	    @Override
	    public E get(int index) {
	        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	        Node<E> current = head;
	        for (int i = 0; i < index; i++) {
	            current = current.next;
	        }
	        return current.element;
	    }

	    @Override
	    public int size() {
	        return size;
	    }

	    public ListIterator<E> listIterator() {
	        return new TwoWayLinkedListIterator();
	    }

	    public ListIterator<E> listIterator(int index) {
	        return new TwoWayLinkedListIterator(index);
	    }

	    private class TwoWayLinkedListIterator implements ListIterator<E> {
	        private Node<E> current = head;
	        private int index = 0;

	        public TwoWayLinkedListIterator() {
	        }

	        public TwoWayLinkedListIterator(int index) {
	            if (index < 0 || index > size) throw new IndexOutOfBoundsException();
	            for (int i = 0; i < index; i++) {
	                current = current.next;
	            }
	            this.index = index;
	        }

	        @Override
	        public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public E next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            E element = current.element;
	            current = current.next;
	            index++;
	            return element;
	        }

	        @Override
	        public boolean hasPrevious() {
	            return current != null && current.previous != null;
	        }

	        @Override
	        public E previous() {
	            if (!hasPrevious()) throw new NoSuchElementException();
	            current = current.previous;
	            index--;
	            return current.element;
	        }

	        @Override
	        public int nextIndex() {
	            return index;
	        }

	        @Override
	        public int previousIndex() {
	            return index - 1;
	        }

	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException("Remove not implemented.");
	        }

	        @Override
	        public void set(E e) {
	            throw new UnsupportedOperationException("Set not implemented.");
	        }

	        @Override
	        public void add(E e) {
	            throw new UnsupportedOperationException("Add not implemented.");
	        }
	    }
	}

	
	
	
}
