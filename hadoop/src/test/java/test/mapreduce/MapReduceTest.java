package test.mapreduce;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.junit.Test;

import java.io.File;

public class MapReduceTest {
    @Test
    public void run() throws Exception {
        new File("result").delete();
        int exitCode = ToolRunner.run(new WordCount(), new String[]{});
        System.out.println(exitCode);
    }

    private class WordCount extends Configured implements Tool {
        public int run(String[] args) throws Exception {
            Job job = new Job();
            job.setJarByClass(WordCount.class);
            job.setJobName("WordCounter");

            FileInputFormat.addInputPath(job, new Path("file1.txt"));
            FileOutputFormat.setOutputPath(job, new Path("result"));

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            job.setOutputFormatClass(TextOutputFormat.class);

            job.setMapperClass(MapClass.class);
            job.setReducerClass(ReduceClass.class);

            int returnValue = job.waitForCompletion(true) ? 0 : 1;

            if (job.isSuccessful()) {
                System.out.println("Job was successful");
            } else if (!job.isSuccessful()) {
                System.out.println("Job was not successful");
            }

            return returnValue;
        }


    }
}
