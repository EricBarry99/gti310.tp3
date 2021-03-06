package gti310.tp3.writer;

import gti310.tp3.data.ResolutionTable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe qui va ecrire dans le fichier la route optimisee obtenue
 * @author eric
 */

public class ResolutionTableWriter implements Writer<ResolutionTable> {

	/**
	 * Function that will write the given ResolutionTable to the file at the given path (or new file if it does not exist)
	 * @param outputFilename  the location to write the file to
	 * @param resTable the resolution table containing the solution
	 */
	public void write(String outputFilename, ResolutionTable resTable) {
		String endline = "\n";
		
		//repris et modifié de http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
		try{
			File file = new File(outputFilename);
			
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(resTable.getStartPoint()) + endline);
	
			for (int j = 0; j < resTable.getSummitList().size(); j++) {
			//	System.out.println("writtenLine: "+ resTable.printLineToWrite(j));
				bw.write(resTable.printLineToWrite(j));
			}
			
			bw.close();
	
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
