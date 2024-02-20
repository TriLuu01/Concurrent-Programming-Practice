import java.util.concurrent.Semaphore
//possible values for x: 0,1,3
Semaphore semQ = new Semaphore(0)

int y=0;
int z=0;
Thread.start {//P
    semQ.acquire()
    int x;
    print(x=y+z);
}


Thread.start {//Q
    y=1;
    semQ.release()
    z=2;
}
println()
//possible values after semaphore: 1,3