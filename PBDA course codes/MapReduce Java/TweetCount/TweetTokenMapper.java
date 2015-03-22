import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;

public class TweetTokenMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line=value.toString();
		String tokens[]={"hackathon","dec","chicago","java"};
		String tok="";
		
		for(int i=0;i<tokens.length;i++){
			tok=tokens[i].trim().toLowerCase();
			
			if(line.toLowerCase().contains(tok)){
				context.write(new Text(tok), new IntWritable(1));
			}else{}
			
				context.write(new Text(tok), new IntWritable(0));
		}
	}
}
