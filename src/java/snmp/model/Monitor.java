/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snmp.model;

import com.sun.xml.ws.transport.tcp.server.glassfish.ServletFakeArtifactSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TimerTask;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@colmeiatecnologia.com.br>
 * @version 1.0
 */
public class Monitor extends TimerTask{
    SNMP_Model snmp;
    static int i =10;
    
    public Monitor(SNMP_Model snmp)
    {
        this.snmp = snmp;
    }
    
    @Override
    public void run()
    {
        HttpServletResponse response = new ServletFakeArtifactSet.FakeServletHttpResponse();
        response.setContentType("text/html;charset=UTF-8"); 
        try {
            PrintWriter out = response.getWriter();
            out.println(snmp.consulta());
        }
        catch (IOException ex) {
            System.out.println("Erro");
        }
    }
    
}
