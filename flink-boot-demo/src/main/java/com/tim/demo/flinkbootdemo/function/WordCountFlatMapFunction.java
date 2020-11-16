package com.tim.demo.flinkbootdemo.function;

import com.tim.demo.flinkbootdemo.properties.TestProperties;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author TimWong
 * @date 2020/11/13 00:18:50
 */
@Component
public class WordCountFlatMapFunction implements FlatMapFunction<String, Tuple2<String, Integer>> {

    private static final Logger LOG = LoggerFactory.getLogger(WordCountFlatMapFunction.class);

    @Value("${test.name}")
    private String name;

    @Autowired
    private TestProperties testProperties;

    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
        for (String word : value.split("\\s")) {
            collector.collect(Tuple2.of(word, 1));
        }
        LOG.info("name ----> {}", this.name);
        LOG.info("items length:{}", this.testProperties.getItems().size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
