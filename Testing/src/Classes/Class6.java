package Classes;
import java.util.Comparator;

	public class Class6 implements Comparator<myTime>{
		public int output=0;
		
		@Override
		public int compare(myTime o1, myTime o2) {
			// TODO Auto-generated method stub
			if((o1.hour-o2.hour)!=0){
				output=o1.hour-o2.hour;
				return output;
			}
			
			if((o1.min-o2.min)!=0){
				output=o1.min-o2.min;
				return output;
			}
			output=o1.second-o2.second; 
			return output;
		}

	}