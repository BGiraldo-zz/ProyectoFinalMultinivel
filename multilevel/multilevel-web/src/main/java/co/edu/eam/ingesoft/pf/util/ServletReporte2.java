package co.edu.eam.ingesoft.pf.util;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporte2")
public class ServletReporte2 extends HttpServlet {
	
	@Resource(lookup = "java:jboss/datasources/multinivelDS")
	private javax.sql.DataSource ds;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//-----EJEMPLO-------------------------------------
		try(Connection con=ds.getConnection();
				) {
			ServletOutputStream salida=resp.getOutputStream();
			GeneradorReporte generador=new GeneradorReporte(con);
			byte[] byteStream=generador.generarReporte(null, "/reporte/tres-mas-afiliados.jrxml", "Reporte tres afiliados", salida);
			resp.setHeader("Content-Disposition","filename=myReport.pdf");
			resp.setContentType("application/pdf");
			resp.setContentLength(byteStream.length);
			salida.write(byteStream,0,byteStream.length);  
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
