package com.tim.tools.starter;


public interface FlinkApplication {

    void main(String[] args) throws Exception;

    default void setBootContext(FlinkBootContext bootContext) {
    }
}
