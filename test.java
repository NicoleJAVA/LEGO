package test;

import java.io.*;


public class test {
	   static String fileName = "test_input";
	   public static void main(String[] args) throws IOException{
		   System.out.println("CUTE");
		   
		   String filePath = "src/test/"+ fileName +".txt";
		   InputStream theIS	= new FileInputStream ( filePath );
		   BufferedInputStream theBIS = new BufferedInputStream( theIS );
		   BufferedReader br = new BufferedReader(new InputStreamReader( theBIS));
		   String theLine = null;
		   while((theLine = br.readLine()) != null){
		       System.out.println(theLine);
		       convert( theLine );
		       // do convert() for every line 
		       // do writeToLDR() for every line 

		   }
		   br.close();
		   try{
			   // Create file 
			   FileWriter fstream = new FileWriter("NicoleTest.txt");
			   BufferedWriter out = new BufferedWriter(fstream);
			   out.write("Hello Java");
			   //Close the output stream
			   out.close();
			   }catch (Exception e){//Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
	   }
	   
	   public static void convert( String origLine) //original line
	   {
		   //pseudo : checkLineType();
		   if( checkLineType(origLine)==1 ){
		      String tempLine = origLine.replace( "LEGO", "1" );
		      System.out.println( tempLine );
		   }   // End if isLEGOline  
	   }
	   
	   
	   public static int checkLineType( String lineInput ){
		   
		   /****/
		   if( lineInput.length() >= 4 ){
			   //   System.out.println( lineInput.substring( 0, 4 ) );
			   String first4char = lineInput.substring( 0, 4 );
			   String LEGOstr = "LEGO";
		       if( first4char.equals(LEGOstr) ){
		    	   
		    	   return 1;
		       }
		       else{
		    	   //   System.out.println( "000" );
		       }
	  	   }
		   /****/
		   return 0;
		   
	   }   // End checkLineType()
	   
	   
	   public static void writeToLDR( String origLine) // origLine is original line
	   {
		   try{
			   // 以下這段要改成用 append 
			   String newLDRfileName = fileName + "_test.ldr";
			   
			   FileWriter theFW = new FileWriter(newLDRfileName); 
			   // Create file // theFW was named fstream originally  
			   BufferedWriter outBW = new BufferedWriter( theFW );
			   outBW.write("Hello Java");
			   
			   outBW.close();   //Close the output stream
			   }catch (Exception e){   //Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
	   }
}

