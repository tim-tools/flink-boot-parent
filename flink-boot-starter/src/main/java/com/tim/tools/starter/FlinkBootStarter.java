package com.tim.tools.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TimWong
 * @date 2020/11/16 11:03:34
 */
public class FlinkBootStarter {

    /**
     * Flink Application Main Method
     *
     * @param args input arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        initInputVariable(args);
        FlinkApplication flinkApplication = initFlinkApplication();
        ApplicationContext applicationContext = SpringApplication.run(flinkApplication.getClass(), args);
        flinkApplication.setBootContext(applicationContext);
        flinkApplication.main(args);
    }

    /**
     * init properties from input arguments
     *
     * @param args arguments
     */
    private static void initInputVariable(String[] args) {
        if (null != args && args.length > 0) {
            Pattern pattern = Pattern.compile("([.\\w\\d]+|\"[.\\w\\d]+\")=([.\\w\\d]+|\"[.\\w\\d\\s]+\")");
            for (String argument : args) {
                Matcher matcher = pattern.matcher(argument);
                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    System.setProperty(key, value);
                }
            }
        }
    }

    /**
     * load Flink Application by java SPI
     *
     * @return FlinkApplication instace
     */
    private static FlinkApplication initFlinkApplication() {
        ServiceLoader<FlinkApplication> flinkApplications = ServiceLoader.load(FlinkApplication.class);
        Iterator<FlinkApplication> iterator = flinkApplications.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new RuntimeException("Please point flink application full class name in META-INF/services/com.tim.tools.starter.FlinkApplication file");
    }
}
