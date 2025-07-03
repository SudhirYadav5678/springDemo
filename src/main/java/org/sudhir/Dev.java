package org.sudhir;

public class Dev {

    private Computer comp;

    public Dev(){
        System.out.println("This is Dev");
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void Build(){
        System.out.println("Hello Build");
        comp.compile();
    }
}
