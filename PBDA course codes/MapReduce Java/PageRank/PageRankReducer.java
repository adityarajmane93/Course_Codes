package pagerank_aditya;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class PageRankReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		String tot=" ";
		String inlink="";
		String[] narr= {};
		double sum = 0;
		for (Text value : values) {
			tot = value.toString(); 
			narr = tot.split(" "); 
			if(narr.length == 1){
				double temp = Double.parseDouble(narr[0]); 
				sum = sum+temp;//Reducer Operation
			}
			else{
				tot = tot.trim();
				inlink = tot;
			}
		}
		context.write(key, new Text(inlink + " " + sum));
	}
}