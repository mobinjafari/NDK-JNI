package org.lotka.ndk_hello_world;

public class IntWrapper {

    public int value;

    public IntWrapper(int value) {
        setInt(value);
    }

    public int getInt() {
        return value;
    }

    public void setInt(int value) {
        this.value = value;
    }
}