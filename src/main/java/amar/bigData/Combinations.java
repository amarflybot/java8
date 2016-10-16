package amar.bigData;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * Created by amarendra on 09/08/16.
 */
public class Combinations {

    // Inherit Mapper class, our input and output will be all text
    public static class MyMap extends Mapper<LongWritable, Text, Text, Text> {
        // Empty string to write as values against keys by default
        private Text term = new Text();

        // Mapping function to map all words to key-value pairs
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // Convert all text to a string
            String str = value.toString();
            // Tokenizer to break text into words, separated by space
            StringTokenizer tokenizer = new StringTokenizer(str, " ");
            // Write a key-value pair against each term to context (job)
            while (tokenizer.hasMoreTokens()) {
                term.set(tokenizer.nextToken());
                // If length of the term exceeds 20 characters, skip it, because
                // processing strings of greater lengths may not be possible
                if (term.getLength() > 20)
                    continue;
                // Initially, pass term as both key and value
                context.write(term, term);
            }
        }
    }

    // Inherit Reducer class, this will be executed on multiple nodes and write
    // output to text file
    public static class MyReduce extends Reducer<Text, Text, Text, Text> {
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            // Sorted collection to store set of combinations
            SortedSet<String> list = new TreeSet<String>();
            // Iterate for each key
            for (Text text : values) {
                // Find out all combinations of a string
                String str = text.toString();
                int length = str.length();
                // The number of combinations is 2^(n-1)
                int total = ((Double) Math.pow(2, length)).intValue() - 1;
                for (int i = 0; i < total; i++) {
                    String tmp = "";
                    char[] charArray = new StringBuilder(
                            Integer.toBinaryString(i)).reverse().toString()
                            .toCharArray();
                    for (int j = 0; j < charArray.length; j++) {
                        if (charArray[j] == '1') {
                            tmp += str.charAt(j);
                        }
                    }
                    list.add(tmp);
                }
                list.add(str);
            }
            // Write term as key and its combinations to output
            context.write(key, new Text(Arrays.toString(list.toArray())));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        // Initiate MapReduce job, named combinations
        Job job = new Job(conf, "combinations");
        // Our keys in output will be text
        job.setOutputKeyClass(Text.class);
        // Our values in output will be text
        job.setOutputValueClass(Text.class);
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        // Fetch input/output paths from arguments
        FileInputFormat.addInputPath(job, new Path(args[0]));
        // Create a time stamped directory inside input directory for output
        FileOutputFormat.setOutputPath(job,
                new Path(args[0] + String.valueOf(new Date().getTime())));
        job.waitForCompletion(true);
    }
}