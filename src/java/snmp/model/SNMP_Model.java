/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snmp.model;

import java.io.IOException;
import org.ietf.jgss.Oid;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class SNMP_Model {
    OID     oid;
    Address ip;
    String  community;
    
    //Construtor
    public SNMP_Model()
    {
    }
    
    public SNMP_Model(String oid, String ip, String community)
    {
        this.oid        = new OID(oid);
        this.ip         = GenericAddress.parse(ip);
        this.community  = community;
    }
    
    
    //Getter e Setter
    public OID getOid()
    {
        return oid;
    }

    public void setOid(OID oid)
    {
        this.oid = oid;
    }
    
    public void setOid(String oid)
    {
        this.oid = new OID(oid);
        
    }

    public Address getIp()
    {
        return ip;
    }
    
    public void setIp(Address ip)
    {
        this.ip = ip;
    }

    public void setIp(String ip)
    {
        this.ip = GenericAddress.parse(ip);
    }

    public String getCommunity()
    {
        return community;
    }

    public void setCommunity(String community)
    {
        this.community = community;
    }
    
    public String teste() throws IOException 
    {
        // TODO code application logic here
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
	
        // Do not forget this line!
        transport.listen(); //Muito importante ter esse listen, pq se nao nao atende a resposta
        //OID oid = new OID(".1.3.6.1.2.1.2.2.1.2.1");
        //****OID oid = new OID(x);
                
        PDU pdu = new PDU();
        //****pdu.add(new VariableBinding(oid)); 	
        pdu.add(new VariableBinding(getOid())); 	
        pdu.setType(PDU.GET);
        
        //****Address destino = GenericAddress.parse(y); //demo.snmplabs.com
        
        CommunityTarget target = new CommunityTarget();
        //****target.setCommunity(new OctetString(z));
        //****target.setAddress(destino);
        target.setCommunity(new OctetString(getCommunity()));
        target.setAddress(getIp());
        target.setRetries(2);   //Numero de tentativas
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version1);
        ResponseEvent event = snmp.send(pdu, target, null);
        if(event != null) {
             System.out.println("Resposta: " + event.getResponse().get(0).getVariable().toString());
        }else{
            System.out.println("Erro!!!!");
        }
        return event.getResponse().get(0).getVariable().toString();
    }  
}
