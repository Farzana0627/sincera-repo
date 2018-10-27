import java.io.File;

public class FileNameChanger {
	
	public static void main(String[] args) {
/*		String folderpath="G:\\Workspace\\FileNameChanging\\Final";
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();
		int count=38;
		for (int i = 0; i < listOfFiles.length; i++) {
		    File[] list = listOfFiles[i].listFiles();
		    
		    for(int j=0; j< list.length; j++ ){
		    	 String subfolderpath= folderpath+"\\"+(i+1);
		    	 File f = new File(subfolderpath+"\\"+j+".wav"); 	    	
	             f.renameTo(new File(subfolderpath+"\\"+j+""+count+".wav"));
		    }
		    count++;
	
		}*/
		
		//String folderpath="G:\\Workspace\\FileNameChanging\\Test_set";
		String folderpath="Train_set";	
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();
		
		
		for (int i = 0; i < listOfFiles.length; i++) {
		    File[] list = listOfFiles[i].listFiles();
		    int count=0;
		    for(int j=0; j< list.length; j++ ){
		    	System.out.println(list.length);
		    	 String subfolderpath= folderpath+"\\"+i;
		    	/* File f = list[j]; 	
		    	 System.out.println(f.getName());*/
		    	 File f = new File(subfolderpath+"\\"+list[j].getName()); 
		    	 //System.out.println(f.getName());
	             f.renameTo(new File(subfolderpath+"\\"+Integer.toString(i)+""+Integer.toString(count)+".wav"));
	             //System.out.println("new"+f.getName());
	             count++;
		    }
		}
		
	}
}
