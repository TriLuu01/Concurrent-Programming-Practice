import java.util.concurrent.Semaphore
Semaphore allowDecrement= new Semaphore(1)
Semaphore allowCalculation = new Semaphore(0)

int n2=0
int n=50
P = Thread.start{
    while (n>0){
        allowDecrement.acquire()
        n=n-1
        allowCalculation.release()
    }
    allowCalculation.release()
}
Thread.start{
    while(true){
        allowCalculation.acquire()
        n2=n2+2*n+1;
        if (n==0) break
        allowDecrement.release()
    }
}
P.join()
print(n2)