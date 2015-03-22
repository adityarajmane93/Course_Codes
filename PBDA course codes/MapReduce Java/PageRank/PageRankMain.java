package pagerank_aditya;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class PageRankMain {
	public static void main(String[] args) throws Exception {
		if (args.length != 6) {
			System.err.println("Check your Input Parameters"); //check the input args
			System.exit(-1);
		}
		Job job = new Job(); 
		
		for(int i=0;i<6;i=i+2){
				job.setJarByClass(PageRankMain.class); 
				job.setJobName("Page Rank");
				FileInputFormat.addInputPath(job, new Path(args[i]));
				FileOutputFormat.setOutputPath(job, new Path(args[i+2]));
				job.setMapperClass(PageRankMapper.class); 
				job.setReducerClass(PageRankReducer.class);
				job.setOutputKeyClass(Text.class);
				job.setOutputValueClass(Text.class);
		}
		int a =job.waitForCompletion(true)? 0:1;
		System.exit(a);
	}
}