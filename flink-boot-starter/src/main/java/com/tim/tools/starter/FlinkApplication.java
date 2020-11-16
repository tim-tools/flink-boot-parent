package com.tim.tools.starter;

import org.springframework.context.ApplicationContext;

/**
 * @author TimWong
 * @date 2020/11/16 11:02:38
 */
public interface FlinkApplication {

    void main(String[] args) throws Exception;

    void setBootContext(ApplicationContext applicationContext);
}
