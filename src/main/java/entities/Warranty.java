package entities;

public final class Warranty {
    private final static int MAXDURATIONINMONTHS = 24;

    static{
        System.out.println("The standard warranty has been created.");
    }

    public Warranty() {
    }

    public static int getMAXDURATIONINMONTHS() {
        return MAXDURATIONINMONTHS;
    }

    public final void showWarranty(){
        System.out.println("The warranty duration is " + getMAXDURATIONINMONTHS() + " months.");
    }

    public static void checkWarranty(){
        if (getMAXDURATIONINMONTHS() != 0){
            System.out.println("The warranty is available");
        }
        else{
            System.out.println("The warranty is not available");
        }
    }
}
