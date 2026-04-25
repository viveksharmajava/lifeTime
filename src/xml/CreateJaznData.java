package xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;

public class CreateJaznData {

	public static void main(String[] args) {
      /* HashMap <String,String> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" ?>\r\n"
				+ "<jazn-data>\r\n"
				+ "<policy-store>\r\n"
				+ "<applications>\r\n"
				+ "<application>\r\n"
				+ "<name>obi</name>\r\n"
				+ "<app-roles>");
	   sb.append(createParentApproles("approle",2,map));
	   sb.append("</app-roles>\r\n");
	   sb.append("<jazn-policy>\r\n");
	   //create permission here..
	   sb.append(addPermissionsToApprole(map));
	   sb.append("</jazn-policy>\r\n");
	   sb.append("</application>\r\n"
	   		+ "</applications>\r\n"
	   		+ "</policy-store>\r\n"
	   		+ "</jazn-data>");
	 */	 
		try {
			prepareBar("bootstrap");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void prepareBar(String siKey) throws Exception{
		String barName  =siKey; //BISecurityCommonUtils.getUniqueSITempDir(siKey);
		File destDir =  new File(System.getProperty("java.io.tmpdir") + File.separator + siKey);
        try
        { 
        	if (!destDir.exists()) {
        		destDir.mkdir();
    		}
            File jsonFile = new File(destDir,  File.separator +"mappings.json");
            File xmlFile = new File(destDir,  File.separator +"jazn-data.xml");
            System.out.println("xmlFile path ="+xmlFile.getAbsolutePath());
           // assertTrue(jsonFile.exists() && xmlFile.exists());
            BufferedWriter jaznWriter = new BufferedWriter(new FileWriter(xmlFile,false));
            jaznWriter.write(prepareJaznDataXml()); 
            System.out.println("xmlFile path ="+xmlFile.getAbsolutePath());
            jaznWriter.close();
        }
        finally
        {
          //  FileUtils.deleteDirectory(destDir);
        }
    }
    private static String prepareJaznDataXml(){
    	 HashMap <String,String> map = new HashMap<>();
 		StringBuffer sb = new StringBuffer();
 		sb.append("<?xml version=\"1.0\" ?>\r\n"
 				+ "<jazn-data>\r\n"
 				+ "<policy-store>\r\n"
 				+ "<applications>\r\n"
 				+ "<application>\r\n"
 				+ "<name>obi</name>\r\n"
 				+ "<app-roles>");
 	   sb.append(createParentApproles("approle",2,map));
 	   sb.append("</app-roles>\r\n");
 	   sb.append("<jazn-policy>\r\n");
 	   //create permission here..
 	   sb.append(addPermissionsToApprole(map));
 	   sb.append("</jazn-policy>\r\n");
 	   sb.append("</application>\r\n"
 	   		+ "</applications>\r\n"
 	   		+ "</policy-store>\r\n"
 	   		+ "</jazn-data>");
 	   System.out.println("\n\n"+sb);
 	   return sb.toString();
    }
	private static StringBuffer createParentApproles(String name,int count,HashMap <String,String> map) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i <count; i++) {
			String parent_name = name+i;
			String  guid = getRandomHexString(32);
			map.put(parent_name ,guid.toUpperCase());
			sb.append("\r\n<app-role>\r\n"
					+ "<name>"+parent_name+"</name>\r\n"
					+ "<display-name>"+parent_name+"</display-name>\r\n"
					+ "<class>oracle.security.jps.service.policystore.ApplicationRole</class>\r\n"
					+ "<guid>"+guid.toUpperCase()+"</guid>\r\n");
			//add member here
			sb.append(addMembers(parent_name,2));
			sb.append("</app-role>\r\n");
			//we can create child approles here or later as well.
			sb.append(creatChildApproles(parent_name,2,map));
			
		}
		return sb;
	}
	private static StringBuffer addMembers(String approle,int members) {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n<members>\r\n");
		for(int i=0; i < members; i++) {
			sb.append("<member>");
			sb.append(approle+"_child+"+i);
			sb.append("</member>");
		}
		sb.append("\r\n</members>\r\n");
		return sb;
	}
	private static StringBuffer creatChildApproles(String parentRole,int count,HashMap <String,String> map) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i <count; i++) {
			String child_approle = parentRole+"_child_"+i;
			String  guid = getRandomHexString(32);
			map.put(child_approle, guid.toUpperCase());
			sb.append("\r\n<app-role>\r\n"
					+ "<name>"+child_approle+"</name>\r\n"
					+ "<display-name>"+child_approle+"</display-name>\r\n"
					+ "<class>oracle.security.jps.service.policystore.ApplicationRole</class>\r\n"
					+ "<guid>"+guid.toUpperCase()+"</guid>\r\n");
			sb.append("</app-role>\r\n");
			
		}
		return sb;
	}
	private static StringBuffer addPermissionsToApprole(HashMap<String,String> map) {
		StringBuffer sb = new StringBuffer();
		for(String role : map.keySet()) {
			sb.append("<grant>\r\n"
					+ "<grantee>\r\n"
					+ "<principals>\r\n"
					+ "<principal>\r\n"
					+ "<class>oracle.security.jps.service.policystore.ApplicationRole</class>\r\n"
					+ "<name>"+role+"</name>\r\n"
					+ "<guid>"+map.get(role)+"</guid>\r\n"
					+ "</principal>\r\n"
					+ "</principals>\r\n"
					+ "</grantee>\r\n"
					+ "<permissions>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>export_dva</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_dataflow</name>\r\n"
					+ "<actions>author_seq</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>schedule_runas</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>schedule</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author_RP_oci_vision</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>export_data</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>schedule_burst</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.infer.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>admin_social</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_dataset</name>\r\n"
					+ "<actions>download_file_based_data</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>admin_maps</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>author_shared_layouts</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>author_watchlist</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author_RP_oci_document_understanding</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.serviceadministration.approle.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>admin_security</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author_RP_oci_language</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>export_doc</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>admin_extensions</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author_RP_oci_datascience</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.serviceadministration.snapshot.permission,resourceName=oracle_bi_resource_snapshot</name>\r\n"
					+ "<actions>admin</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_dataset</name>\r\n"
					+ "<actions>author</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>author</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>admin_themes</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_dataflow</name>\r\n"
					+ "<actions>author</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_connection</name>\r\n"
					+ "<actions>author_RP_oci_functions</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_system</name>\r\n"
					+ "<actions>admin_objectManagement</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>author_custom_groups</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "<permission>\r\n"
					+ "<class>oracle.security.jps.ResourcePermission</class>\r\n"
					+ "<name>resourceType=oracle.bi.tech.visualanalyzer.permission,resourceName=oracle_bi_resource_workbook</name>\r\n"
					+ "<actions>author_shared_themes</actions>\r\n"
					+ "\r\n"
					+ "</permission>\r\n"
					+ "</permissions>\r\n"
					+ "<permission-set-refs>\r\n"
					+ "</permission-set-refs>\r\n"
					+ "</grant>");
		}
		return sb;
	}
	private static String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
}
