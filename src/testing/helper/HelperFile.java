package testing.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HelperFile {
	
	
	public static File inputStreamToFile( InputStream input ) throws Exception {
		
		File newFile = File.createTempFile( "txt" , "" );
		
		try ( OutputStream output = new FileOutputStream( newFile , false ) ) {
            input.transferTo(output);
        }
		
		return newFile ;
	}
	
	
	
	
	public static String fileContent( File file ) {
			
		StringBuilder contentBuilder = new StringBuilder( );
		
		try ( BufferedReader br = new BufferedReader( new FileReader( file ) ) ) {
			
			String sCurrentLine;
			while ( ( sCurrentLine = br.readLine( )) != null ) {
				contentBuilder.append( sCurrentLine ).append( "\n" );
			}
			
		} catch ( IOException e ) {
			e.printStackTrace( );
		}
		
		return contentBuilder.toString( );
		
	}
	
	
}
