package com.linjhon.myspringboot.test;

public class PrivateOverride {
private void f(){
    System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        ((Derived) po).f();
    }
}
