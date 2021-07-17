class Foo {
    Semaphore first;
    Semaphore second;
    Semaphore third;
    public Foo() {
        this.first = new Semaphore(1);
        this.second = new Semaphore(1);
        this.third = new Semaphore(1);
        try{
            second.acquire();
            third.acquire();
        }catch(InterruptedException e){}
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        first.acquire();
        printFirst.run();
        first.release();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        second.release();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();
        third.release();
    }
}