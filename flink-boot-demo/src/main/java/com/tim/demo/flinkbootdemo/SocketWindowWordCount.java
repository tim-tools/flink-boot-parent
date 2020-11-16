package com.tim.demo.flinkbootdemo;

import com.tim.demo.flinkbootdemo.function.WordCountFlatMapFunction;
import com.tim.tools.starter.FlinkApplication;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SocketWindowWordCount implements FlinkApplication {

    private ApplicationContext applicationContext;

    @Override
    public void main(String[] args) throws Exception {

        // get bean from context
        WordCountFlatMapFunction wordCountFlatMapFunction = applicationContext.getBean(WordCountFlatMapFunction.class);

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> inputSocket = env.socketTextStream("localhost", 9000, "\n");
        DataStream<Tuple2<String, Integer>> wordCounts = inputSocket
                .flatMap(wordCountFlatMapFunction);
        DataStream<Tuple2<String, Integer>> windowCounts = wordCounts
                .keyBy(0)
                .timeWindow(Time.seconds(5))
                .sum(1);
        windowCounts.print().setParallelism(1);
        env.execute("Socket Window WordCount");
    }

    @Override
    public void setBootContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
