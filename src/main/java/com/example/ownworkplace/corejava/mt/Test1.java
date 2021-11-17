package com.example.ownworkplace.corejava.mt;

public class Test  implements  Runnable{
    Demo d = new Demo();
    @Override
    public void run() {
        System.out.println(" Demo Thread");
        d.abc();
        d.xyz();

    }
}
