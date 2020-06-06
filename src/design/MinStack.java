package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	/*
	getMin: global var? need to remember its previous min -> need a data structure
	two stack
	*/
	    /** initialize your data structure here. */
	    private Deque<Integer> mainStack = new ArrayDeque<>();
	    private Deque<Integer> minTracker = new ArrayDeque<>();
	    
	    public MinStack() {
	        ;
	    }
	    
	    public void push(int x) {
	        this.mainStack.addLast(x);
	        if (this.minTracker.size() == 0 || x < this.minTracker.peekLast()){
	            this.minTracker.addLast(x);
	        }else{
	            this.minTracker.addLast(this.minTracker.peekLast());
	        }
	    }
	    
	    public void pop() {
	        if (this.mainStack.size() <= 0){
	            return;
	        }
	        this.mainStack.pollLast();
	        this.minTracker.pollLast();
	    }
	    
	    public int top() {
	        return this.mainStack.peekLast();
	    }
	    
	    public int getMin() {
	        return this.minTracker.peekLast();
	    }
}
