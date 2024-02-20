import java.util.concurrent.Semaphore

Semaphore semF = new Semaphore(0)
Semaphore semC = new Semaphore(0)


Thread.start {//P


    print("A");
    semF.release()
    print("B");
    semC.acquire()
    print("C");

}


Thread.start {//Q
    print("E");
    semF.acquire();
    print("F");
    semC.release()
    print("G");
}

println();