class FooBar {
    private int n;
    Semaphore sem = new Semaphore(1);
    Semaphore sem2 = new Semaphore(1);
    public FooBar(int n) {
        this.n = n;
        try{
            sem2.acquire();
        }
        catch(InterruptedException e){
            System.out.println("hi");
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            sem.acquire();
        	printFoo.run();
            sem2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        //sem.acquire();
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            sem2.acquire();
        	printBar.run();
            sem.release();
        }
        
    }
}