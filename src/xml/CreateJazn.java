package xml;

public class CreateJazn {

	public static void main(String[] args) {

        String coarseGrainedAppPolicyXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<jazn-data>\n" +
                "    <policy-store>\n" +
                "        <applications>\n" +
                "            <application>\n" +
                "                <name>obi-template</name>\n" +
                "                <resource-types>\n" +
                "                    <resource-type>\n" +
                "                       <name>oracle_bi_resource_type_upgrade_test</name>\n" +
                "                       <display-name>Upgrade Test Resource Type</display-name>\n" +
                "                       <description>Resource type definition of Upgrade Test</description>\n" +
                "                       <matcher-class>oracle.security.jps.ResourcePermission</matcher-class>\n" +
                "                       <actions-delimiter>,</actions-delimiter>\n" +
                "                       <actions>%s,write</actions>\n" +
                "                   </resource-type>\n" +
                "                </resource-types>\n" +
                "                <resources>\n" +
                "                  <resource>\n" +
                "                    <name>oracle_bi_resource_upgrade_test</name>\n" +
                "                    <display-name>oracle_bi_resource_upgrade_test</display-name>\n" +
                "                    <description>Upgrade resource</description>\n" +
                "                    <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
                "                  </resource>\n" +
                "                </resources>\n" +
                "                <permission-sets>\n" +
                "                  <permission-set>\n" +
                "                    <name>upgrade.author</name>\n" +
                "                    <display-name>upgrade.author</display-name>\n" +
                "                    <description>Upgrade Author Permissions</description>\n" +
                "                    <member-resources>\n" +
                "                      <member-resource>\n" +
                "                        <permission-id>oracle_bi_permission_upgrade_test_%s</permission-id>\n" +
                "                        <permission-description>oracle_bi_permission_upgrade_test_%s_desc</permission-description>\n" +
                "                        <permission-category>oracle_bi_category_administration</permission-category>\n" +
                "                        <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
                "                        <resource-name>oracle_bi_resource_upgrade_test</resource-name>\n" +
                "                        <actions>%s</actions>\n" +
                "                        <old-permission>oracle.bi.security:oracle.bi.security.IDStore:read</old-permission>\n" +
                "                        <visible-in-ui>false</visible-in-ui>\n" +
                "                      </member-resource>\n" +
                "                      <member-resource>\n" +
                "                        <permission-id>oracle_bi_permission_upgrade_test_write</permission-id>\n" +
                "                        <permission-description>oracle_bi_permission_upgrade_test_write_desc</permission-description>\n" +
                "                        <permission-category>oracle_bi_category_administration</permission-category>\n" +
                "                        <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
                "                        <resource-name>oracle_bi_resource_upgrade_test</resource-name>\n" +
                "                        <actions>write</actions>\n" +
                "                        <visible-in-ui>false</visible-in-ui>\n" +
                "                      </member-resource>\n" +
                "                    </member-resources>\n" +
                "                  </permission-set>\n" +
                "                </permission-sets>\n" +
                "            </application>\n" +
                "        </applications>\n" +
                "    </policy-store>\n" +
                "</jazn-data>";
       // System.out.println(coarseGrainedAppPolicyXml); 
        
    System.out.println(getFineGrainedAppPolicyXml());
	}
	 private static String getFineGrainedAppPolicyXml()
	    {
	        String fineGrainedAppPolicyXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	                "<jazn-data>\n" +
	                "    <policy-store>\n" +
	                "        <applications>\n" +
	                "            <application>\n" +
	                "                <name>obi-template</name>\n" +
	                "                <resource-types>\n" +
	                "                    <resource-type>\n" +
	                "                       <name>oracle_bi_resource_type_upgrade_test</name>\n" +
	                "                       <display-name>Upgrade Test Resource Type</display-name>\n" +
	                "                       <description>Resource type definition of Upgrade Test</description>\n" +
	                "                       <matcher-class>oracle.security.jps.ResourcePermission</matcher-class>\n" +
	                "                       <actions-delimiter>,</actions-delimiter>\n" +
	                "                       <actions>%s,write,%t</actions>\n" +
	                "                   </resource-type>\n" +
	                "                </resource-types>\n" +
	                "                <resources>\n" +
	                "                  <resource>\n" +
	                "                    <name>oracle_bi_resource_upgrade_test</name>\n" +
	                "                    <display-name>oracle_bi_resource_upgrade_test</display-name>\n" +
	                "                    <description>Upgrade resource</description>\n" +
	                "                    <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
	                "                  </resource>\n" +
	                "                </resources>\n" +
	                "                <permission-sets>\n" +
	                "                  <permission-set>\n" +
	                "                    <name>upgrade.author</name>\n" +
	                "                    <display-name>upgrade.author</display-name>\n" +
	                "                    <description>Upgrade Author Permissions</description>\n" +
	                "                    <member-resources>\n" +
	                "                      <member-resource>\n" +
	                "                        <permission-id>oracle_bi_permission_upgrade_test_%s</permission-id>\n" +
	                "                        <permission-description>oracle_bi_permission_upgrade_test_%s_desc</permission-description>\n" +
	                "                        <permission-category>oracle_bi_category_administration</permission-category>\n" +
	                "                        <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
	                "                        <resource-name>oracle_bi_resource_upgrade_test</resource-name>\n" +
	                "                        <actions>%s</actions>\n" +
	                "                        <old-permission>oracle.bi.security:oracle.bi.security.IDStore:read</old-permission>\n" +
	                "                        <visible-in-ui>false</visible-in-ui>\n" +
	                "                      </member-resource>\n" +
	                "                      <member-resource>\n" +
	                "                        <permission-id>oracle_bi_permission_upgrade_test_write</permission-id>\n" +
	                "                        <permission-description>oracle_bi_permission_upgrade_test_write_desc</permission-description>\n" +
	                "                        <permission-category>oracle_bi_category_administration</permission-category>\n" +
	                "                        <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
	                "                        <resource-name>oracle_bi_resource_upgrade_test</resource-name>\n" +
	                "                        <actions>write</actions>\n" +
	                "                        <visible-in-ui>false</visible-in-ui>\n" +
	                "                      </member-resource>\n" +
	                "                      <member-resource>\n" +
	                "                        <permission-id>oracle_bi_permission_upgrade_test_%t</permission-id>\n" +
	                "                        <permission-description>oracle_bi_permission_upgrade_test_%t_desc</permission-description>\n" +
	                "                        <permission-category>oracle_bi_category_administration</permission-category>\n" +
	                "                        <type-name-ref>oracle_bi_resource_type_upgrade_test</type-name-ref>\n" +
	                "                        <resource-name>oracle_bi_resource_upgrade_test</resource-name>\n" +
	                "                        <actions>%t</actions>\n" +
	                "                        <coarse-grained-permission-id>oracle_bi_permission_upgrade_test_%s</coarse-grained-permission-id>\n" +
	                "                        <visible-in-ui>false</visible-in-ui>\n" +
	                "                      </member-resource>\n" +
	                "                    </member-resources>\n" +
	                "                  </permission-set>\n" +
	                "                </permission-sets>\n" +
	                "            </application>\n" +
	                "        </applications>\n" +
	                "    </policy-store>\n" +
	                "</jazn-data>";
	        return fineGrainedAppPolicyXml;
	    }
}
