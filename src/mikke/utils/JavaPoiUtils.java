package mikke.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
 
/** 
 * Utility class, where we will create methods for training read and write excel files,
 * with <a href="https://poi.apache.org/">Apache POI</a>, we use 
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file.
 * 
 * Clase de utilidades, donde crearemos métodos
 * para el aprendizaje de la lectura y escritura de ficheros excel con 
 * <a href="https://poi.apache.org/">Apache POI</a>, usaremos
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF es el proyecto POI de implementación total en Java para ficheros Excel '97(-2007).
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class JavaPoiUtils {
    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, in this example we print the content in the console.
     * Explicación del método con el que leemos el fichero excel que pasamos como
     * parámetro si existe, en este ejemplo mostramos el contenido por la consola.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     * JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
     * javaPoiUtils.readExcelFile(new File("/home/xules/codigoxules/apachepoi/PaisesIdiomasMonedas.xls"));    
     * </pre>
     *
     * @param excelFile <code>String</code> 
     *      excel File we are going to read. 
     *      Fichero excel que vamos a leer. 
     */
    public void readExcelFile(File excelFile){
        InputStream excelStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            // We chose the sheet is passed as parameter. 
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow;
            // Initialize the object to read the value of the cell 
            // Inicializo el objeto que leerá el valor de la celda
            HSSFCell cell;                        
            // I get the number of rows occupied on the sheet
            // Obtengo el número de filas ocupadas en la hoja
            int rows = hssfSheet.getLastRowNum();
            // I get the number of columns occupied on the sheet
            // Obtengo el número de columnas ocupadas en la hoja
            int cols = 0;            
            // A string used to store the reading cell
            // Cadena que usamos para almacenar la lectura de la celda
            String cellValue;  
            // For this example we'll loop through the rows getting the data we want
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (int r = 0; r < rows; r++) {
                hssfRow = hssfSheet.getRow(r);
                if (hssfRow == null){
                    break;
                }else{
                    System.out.print("Row: " + r + " -> ");
                    for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
                        /* 
                            We have those cell types (tenemos estos tipos de celda): 
                                CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                        */
                        cellValue = hssfRow.getCell(c) == null?"":
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_STRING)?hssfRow.getCell(c).getStringCellValue():
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC)?"" + hssfRow.getCell(c).getNumericCellValue():
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN)?"" + hssfRow.getCell(c).getBooleanCellValue():
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK)?"BLANK":
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_FORMULA)?"FORMULA":
                                (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_ERROR)?"ERROR":"";                       
                        System.out.print("[Column " + c + ": " + cellValue + "] ");
                    }
                    System.out.println();
                }
            }            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }
    
    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, we return the excel file values in an ArrayList<>.
     * Explicación del método con el que leemos el fichero excel que pasamos como
     * parámetro si existe, devolvemos los valores de la hoja excel en un ArrayList<>.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     * JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
     * javaPoiUtils.readExcelFile(new File("/home/xules/codigoxules/apachepoi/PaisesIdiomasMonedas.xls"));    
     * </pre>
     *
     * @param excelFile <code>String</code> 
     *      excel File we are going to read. 
     *      Fichero excel que vamos a leer.  
     * @return <code>ArrayList<String[]></code> we return the excel file values in an ArrayList<> (devolvemos los valores de la hoja excel en un ArrayList<>).
     */
    public ArrayList<String[]> readExcelFileToArray(File excelFile){    
        ArrayList<String[]> arrayDatos = new ArrayList<>();
        InputStream excelStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            // We chose the sheet is passed as parameter. 
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);    
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow = hssfSheet.getRow(hssfSheet.getTopRow());
            String [] datos = new String[hssfRow.getLastCellNum()];            
            // For this example we'll loop through the rows getting the data we want
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (Row row: hssfSheet) {                    
                for (Cell cell : row) {
                    /* 
                        We have those cell types (tenemos estos tipos de celda): 
                            CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                    */
                    datos[cell.getColumnIndex()] =  
                            (cell.getCellType() == Cell.CELL_TYPE_STRING)?cell.getStringCellValue():
                            (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)?"" + cell.getNumericCellValue():
                            (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)?"" + cell.getBooleanCellValue():
                            (cell.getCellType() == Cell.CELL_TYPE_BLANK)?"BLANK":
                            (cell.getCellType() == Cell.CELL_TYPE_FORMULA)?"FORMULA":
                            (cell.getCellType() == Cell.CELL_TYPE_ERROR)?"ERROR":"";                                                                   
                }
                arrayDatos.add(datos); 
                datos = new String[hssfRow.getLastCellNum()];  
            }            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
        return arrayDatos;
    }

    /** Creando fichero XLSX
     *
     */
    public void createExcelFile ()
    {
    	String nombreArchivo="Inventario.xlsx";
		String rutaArchivo= "src\\"+nombreArchivo;
		String hoja="Hoja1";
		
		XSSFWorkbook libro= new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		//cabecera de la hoja de excel
		String [] header= new String[]{"Código", "Producto","Precio","Unidades"};
		
		//contenido de la hoja de excel
		String [][] document= new String [][]{
				{"AP150","ACCESS POINT TP-LINK TL-WA901ND 450Mbps Wireless N 1RJ45 10-100 3Ant.","112.00","50"},
				{"RTP150","ROUTER TP-LINK TL-WR940ND 10-100Mbpps LAN WAN 2.4 - 2.4835Ghz","19.60","25"},
				{"TRT300","TARJETA DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.","10.68","15"},
				{"TRT300","DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.","10.68","15"},
				{"TR0","DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCI-Exp.","10.68","15"}
		};
		
		//poner negrita a la cabecera
		CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        
        
		//generar los datos para el documento
		for (int i = 0; i <= document.length; i++) {
			XSSFRow row=hoja1.createRow(i);//se crea las filas
			for (int j = 0; j <header.length; j++) {
				if (i==0) {//para la cabecera
						XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
						cell.setCellStyle(style); // se añade el style crea anteriormente 
						cell.setCellValue(header[j]);//se añade el contenido					
				}else{//para el contenido
					XSSFCell cell= row.createCell(j);//se crea las celdas para la contenido, junto con la posición
					cell.setCellValue(document[i-1][j]); //se añade el contenido
				}				
			}
		}
		
		File file;
		file = new File(rutaArchivo);
		try (FileOutputStream fileOuS = new FileOutputStream(file)){						
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
    }
    
    //Leyendo xlsx sin tener en cuenta el tipo de dato de cada columna...
    public void readXLSXFile ()
	{
		String nombreArchivo = "Inventario.xlsx";
		String rutaArchivo = "src\\" + nombreArchivo;
		//String hoja = "Hoja1";
 
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
 
			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
					System.out.print(cell.getStringCellValue()+" | ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
    
    public void leerExcel () throws IOException

    {
    	FileInputStream file = new FileInputStream(new File("src/Inventario.xlsx"));
    	// Crear el objeto que tendra el libro de Excel
    	XSSFWorkbook workbook = new XSSFWorkbook(file);
    	/*	
    	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.	
    	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator	
    	 * que nos permite recorrer cada una de las filas que contiene.	
    	 */	
    	XSSFSheet sheet = workbook.getSheetAt(0);	
    	Iterator<Row> rowIterator = sheet.iterator();
    	Row row;

    	// Recorremos todas las filas para mostrar el contenido de cada celda

    	while (rowIterator.hasNext()){
    	    row = rowIterator.next();
    	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
    	    Iterator<Cell> cellIterator = row.cellIterator();
    	    Cell celda;
    	
    	    while (cellIterator.hasNext()){
    	    	celda = cellIterator.next();
	    		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
	    		switch(celda.getCellTypeEnum()) {
	    	
	    		case NUMERIC:
	    		    if( DateUtil.isCellDateFormatted(celda) ){
	    	
	    		       System.out.print(celda.getDateCellValue() + " | ");
	    	
	    		    }else{
	    	
	    		       System.out.print(celda.getNumericCellValue() + " | ");
	    		    }
	    	
	    		    break;
	    	
	    		case STRING:
	    	
	    		    System.out.print(celda.getStringCellValue()+ " | ");
	    	
	    		    break;
	    	
	    		case BOOLEAN:
	    	
	    		    System.out.print(celda.getBooleanCellValue()+ " | ");
	    	
	    		    break;
	    		}
    	    }
    	    
    	    System.out.println();
    	}	
    	// cerramos el libro excel
    	workbook.close();	
        }

    public void mergeCell () throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("My_Sheet");

        XSSFCellStyle style1 = wb.createCellStyle();
        style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)));
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellStyle(style1);
        cell.setCellValue("This is a test of merging");

        sheet.addMergedRegion(new CellRangeAddress(
                1, //first row (0-based)
                1, //last row  (0-based)
                1, //first column (0-based)
                2  //last column  (0-based)
        ));
        
       

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        }

        wb.close();
    }
}