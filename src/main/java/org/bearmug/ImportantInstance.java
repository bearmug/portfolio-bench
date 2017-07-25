package org.bearmug;


public class ImportantInstance {

    public int fibonacci(int base) {
        switch (base) {
            case 1:
                return 1;
            case 2:
                return 1;
            default:
                return fibonacci(base - 1) + fibonacci(base - 2);
        }
    }
}
