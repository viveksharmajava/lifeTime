import java.io.File;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:\\ADE\\sdewanga_m1\\bifndn\\analytics_web\\main\\deploy\\orainst\\tmp\\OracleBIPresentationServicesComponent\\coreapplication_obips1\\earmanager\\analytics\\gBa9R3tU072DDS9QR3m4UA\\resskinXML \\\\?\\C:\\ADE\\sdewanga_m1\\bifndn\\analytics_web\\maindeploy\\orainst\\tmp\\OracleBIPresentationServicesComponent\\coreapplication_obips1\\earmanager\\analytics\\gBa9R3tU072DDS9QR3m4UA\\res\\s_Alta\\master\\graph.xml";
		
		String sub = path.substring(path.indexOf(File.separator+"res"+File.separator)+4);
		System.out.println(sub);

	}

}
