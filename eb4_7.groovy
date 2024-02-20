import java.util.concurrent.Semaphore

Semaphore mutex = new Semaphore(0)

Thread.start{//A
    opA;
    mutex.release()
}
Thread.start{//B
    opB;
    mutex.release()
}
Thread.start{//C
    mutex.acquire(2)
    opC;
}