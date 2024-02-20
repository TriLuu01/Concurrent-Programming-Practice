import java.util.concurrent.Semaphore

Semaphore semP = new Semaphore(0)
Semaphore semQ = new Semaphore(0)


Thread.start {//P
    semP.acquire();
    print("A");
    print("S");
    semQ.release()
}


Thread.start {//Q
    print("L");
    semP.release()
    semQ.acquire()
    print("E");
    print("R");
}

println();