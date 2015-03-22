package pagerank_aditya;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class PageRankMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		
		String inline = value.toString();
		String[] a = inline.split(" ");
		int outlink = a.length-2; //(Reduce 1 for the page and 1 for the rank so rest will be outlinks)
		double prank = Double.parseDouble(a[a.length-1]);
		String temp = "";
		for(int i=1; i<a.length-1; i++){
			double rank = prank/outlink;//Calculation of Rank
			String r1 = Double.toString(rank); 
			context.write(new Text(a[i]), new Text(r1)); 
			temp=temp+" "+a[i];
		}
		context.write(new Text(a[0]), new Text(temp));//Sending the Rank to reducer
	}
}