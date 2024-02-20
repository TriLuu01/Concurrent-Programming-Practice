import java.util.concurrent.Semaphore

Semaphore semQ = new Semaphore(0)
Semaphore semR = new Semaphore(0)
Semaphore semOK = new Semaphore(0)
Thread.start {//P
    print("R");
    semQ.release()
    semOK.acquire()
    print("OK");
}


Thread.start {//Q
    semQ.acquire()
    print("I");
    semR.release()
    semOK.acquire()
    print("OK");
}

Thread.start{//R
    semR.acquire()
    print("O");
    semOK.release(2)//use release twice to ensure it is atomic because it might release just one thread and continue
    print("OK");
}
