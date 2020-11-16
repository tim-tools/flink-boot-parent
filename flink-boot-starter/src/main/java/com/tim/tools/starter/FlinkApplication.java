package com.tim.tools.starter;


/**
 * @author TimWong
 * @date 2020/11/16 11:02:38
 */
public interface FlinkApplication {

    void main(String[] args) throws Exception;

    default void setBootContext(FlinkBootContext bootContext) {
    }
}
