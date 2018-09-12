package mikke.mains;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.mikke.ejbUtils.TimerBean;
import com.mikke.ejbUtils.Impl.BeanTimerImpl;
import com.mikke.ejbUtils.Impl.ContextUtil;

import mikke.utils.Arreglos;
import mikke.utils.AwsUtils;
import mikke.utils.InstanciaUnica;
import mikke.utils.JavaPoiUtils;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, NamingException {
	
		//Buscar Duplicados---
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		//Arreglos app = new  Arreglos();
		/*app.buscarDuplicados("matematica");
		
		System.out.println("--------------------------------------------------------------------------------------------------");
		//Clase Singleton
        InstanciaUnica ricardo = InstanciaUnica.getSingletonInstance("Ricardo Moya");
        InstanciaUnica ramon = InstanciaUnica.getSingletonInstance("Ramón Invarato");
        
        // ricardo y ramon son referencias a un único objeto de la clase SoyUnico
        System.out.println(ramon.getNombre());
        System.out.println(ricardo.getNombre()); */

		//app.ordenarArray();

		//System.out.println(app.reverse("maikel"));

		//System.out.println(app.reverseJava("matem"));

		//app.test();
		
		///JavaPoiUtils app = new JavaPoiUtils();
		
		//Leyendo excel desde Java usando la API de Apache POI
		//Variante 1
		//app.readExcelFile(new File("src/PaisesIdiomasMonedas.xls"));
		
		//Variante 2
		 /*ArrayList<String[]> arrayDatosExcel = app.readExcelFileToArray(new File("src/PaisesIdiomasMonedas.xls")); 
		    int r = 0;
		    for (String[] next : arrayDatosExcel) {
		        System.out.print("Array Row: " + r++ + " -> ");
		        for (int c = 0; c < next.length; c++) {
		            System.out.print("[Column " + c + ": " + next[c] + "] ");
		        }
		        System.out.println();
		    }*/
		
		//Variante 3
		//app.createExcelFile();
		
		//Variante 4
		//app.leerExcel();
		
		//Variante 5
		//app.mergeCell();
		
		
		/*TimerBean myInterface  = ContextUtil.getInstance().getManager();
		myInterface.startTimer();*/
		
		AwsUtils aws = new AwsUtils(); //Test desde el Repo remoto
		
		
	}
}
		    
