package mikke.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.*;

import com.google.common.io.Files;

public class FilesUtils { 

	public void createTempDirectory () throws IOException{
		
		// Directories
		 System.out.println(System.getProperty("java.io.tmpdir")) ;
		 String cad = "https://www.lg.com/au/images/tvs/55eg910t/gallery/medium01.jpg";
		 //URL uri = cad.;
		 
		/* FileUtils.copyURLToFile(uri, new File (System.getProperty("java.io.tmpdir") + 
				 "\\" + "medium.jpg"));*/

	}
}
