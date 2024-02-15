package leetcode;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//import oracle.jdbc.OracleConnection;

class OracleCon{
static Connection connection;

public static void main(String args[]){
//try{
//
//Class.forName("oracle.jdbc.driver.OracleDriver");
//
// 
//String DB_URL="jdbc:oracle:thin:fusion/wegaCnkYU7@FA_DEFAULT?TNS_ADMIN=/u01/APPLTOP/instance/network/admin/tnsadmin" ;
//Properties info = new Properties();
//info.put(OracleConnection.CONNECTION_PROPERTY_TNS_ADMIN,"/u01/APPLTOP/instance/network/admin/tnsadmin");
//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
////java.sql.Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@slc11qpd.us.oracle.com:1616/sam98700_gsi_fd","fusion","okc#hagdqrwfpnv"); 
//java.sql.Connection connection = DriverManager.getConnection(DB_URL, info);
//StringBuffer sb = new StringBuffer();
//try
//{
//  DatabaseMetaData meta = connection.getMetaData();
//  sb.append("JDBC Driver:"+meta.getDriverName() +":"+connection.getClass().getName() +":"+meta.getDriverVersion());
//  sb.append("\nDBName:"+meta.getDatabaseProductName()+" \nDBVersion:"+ meta.getDatabaseProductVersion());        
//  
//}catch (Exception e)
//{
//  //e.printStackTrace();
//}
//System.out.println(sb);
//Statement stmt=connection.createStatement();
// 
//ResultSet rs=stmt.executeQuery("SELECT '0' Structure_Level,\n" + 
//		"       eic.ITEM_CLASS_NAME ITEM_CLASS,\n" + 
//		"       itms1.ITEM_NUMBER PATH,\n" + 
//		"       NULL PARENT,\n" + 
//		"       itms1.item_number Item_Name,\n" + 
//		"      TRANSLATE (itmt.DESCRIPTION, CHR(10)||CHR(13), ' ')  as item_description,\n" + 
//		"       (SELECT EIR.REVISION\n" + 
//		"          FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"         WHERE EIR.REVISION_ID = 300100552668695 AND ROWNUM = 1)\n" + 
//		"          REVISION,\n" + 
//		"       EPT.PHASE_NAME LIFECYCLE_PHASE,\n" + 
//		"       NULL Sequence,\n" + 
//		"       NULL Quantity,\n" + 
//		"       itms1.PRIMARY_UOM_CODE UOM_CODE,\n" + 
//		"       NULL Reference_Designator,\n" + 
//		"       TO_CHAR ( (SELECT EFFECTIVITY_DATE\n" + 
//		"                    FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                   WHERE EIR.REVISION_ID = 300100552668695),\n" + 
//		"                'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"          EFFECTIVITY_DATE,\n" + 
//		"       NULL YIELD,\n" + 
//		"       NULL BOM_COMMENTS,\n" + 
//		"       (SELECT DECODE (UPPER (ATTRIBUTE_CHAR4),\n" + 
//		"                       'YES', 'Y',\n" + 
//		"                       'Y', 'Y',\n" + 
//		"                       'NO', 'N',\n" + 
//		"                       'N', 'N')\n" + 
//		"          FROM fusion.EGO_ITEM_EFF_B eieb\n" + 
//		"         WHERE     eieb.CONTEXT_CODE IN ('BRIO_Part_Information')\n" + 
//		"               AND eieb.inventory_item_id = itms1.INVENTORY_ITEM_ID\n" + 
//		"               AND eieb.organization_id = itms1.organization_id\n" + 
//		"               AND (   TO_TIMESTAMP (eieb.VERSION_START_DATE) <=\n" + 
//		"                          (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                    OR TO_TIMESTAMP (eieb.VERSION_START_DATE) <\n" + 
//		"                          (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"               AND NVL (eieb.VERSION_END_DATE, SYSDATE + 1) >=\n" + 
//		"                      (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"			   AND ROWNUM=1)\n" + 
//		"          Critical_comp_flag,\n" + 
//		"       (SELECT ATTRIBUTE_CHAR5\n" + 
//		"          FROM fusion.EGO_ITEM_EFF_B eieb\n" + 
//		"         WHERE     eieb.CONTEXT_CODE IN ('BRIO_Part_Information')\n" + 
//		"               AND eieb.inventory_item_id = itms1.INVENTORY_ITEM_ID\n" + 
//		"               AND eieb.organization_id = itms1.organization_id\n" + 
//		"               AND (   TO_TIMESTAMP (eieb.VERSION_START_DATE) <=\n" + 
//		"                          (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                    OR TO_TIMESTAMP (eieb.VERSION_START_DATE) <\n" + 
//		"                          (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"               AND NVL (eieb.VERSION_END_DATE, SYSDATE + 1) >=\n" + 
//		"                      (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"			   AND ROWNUM=1)\n" + 
//		"          SERVICE_CODE,\n" + 
//		"       (SELECT CASE WHEN COUNT (*) > 0 THEN 'TRUE' ELSE 'FALSE' END\n" + 
//		"          FROM fusion.FND_ATTACHED_DOCUMENTS FAD\n" + 
//		"         WHERE     FAD.entity_name = 'ITEM_ENTITY'\n" + 
//		"               AND TO_NUMBER (FAD.PK1_VALUE) = itms1.organization_id\n" + 
//		"               AND TO_NUMBER (FAD.PK2_VALUE) = itms1.INVENTORY_ITEM_ID)\n" + 
//		"          Attachment,\n" + 
//		"       (SELECT CASE WHEN COUNT (*) > 0 THEN 'TRUE' ELSE 'FALSE' END\n" + 
//		"          FROM fusion.egp_components_b ECAV1\n" + 
//		"         WHERE     ECAV1.obj_name = 'EGO_ITEM'\n" + 
//		"               AND ECAV1.pk1_value = esb.pk1_value\n" + 
//		"               AND ECAV1.pk2_value = esb.pk2_value\n" + 
//		"               AND ECAV1.bill_sequence_id <> esb.bill_sequence_id\n" + 
//		"               AND ECAV1.effectivity_date <=\n" + 
//		"                      (SELECT EFFECTIVITY_DATE\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"               AND NVL (ECAV1.disable_date, SYSDATE + 1) >\n" + 
//		"                      (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"          WHERE_USED,\n" + 
//		"       esb.bill_sequence_id,\n" + 
//		"       itms1.INVENTORY_ITEM_ID,\n" + 
//		"       itms1.ORGANIZATION_ID\n" + 
//		"  \n" + 
//		"FROM fusion.egp_structures_b esb,\n" + 
//		"       fusion.EGP_SYSTEM_ITEMS_tl itmt,\n" + 
//		"       fusion.EGP_SYSTEM_ITEMS_b itms1,\n" + 
//		"       fusion.EGP_ITEM_CLASSES_VL eic,\n" + 
//		"       fusion.INV_ORG_PARAMETERS IOP,\n" + 
//		"       fusion.EGP_PHASES_TL EPT\n" + 
//		" \n" + 
//		"WHERE     esb.alternate_bom_designator = 'Primary'\n" + 
//		"       AND itms1.ITEM_CATALOG_GROUP_ID = eic.ITEM_CLASS_ID\n" + 
//		"       AND itmt.INVENTORY_ITEM_ID = itms1.INVENTORY_ITEM_ID\n" + 
//		"       AND itmt.ORGANIZATION_ID = itms1.ORGANIZATION_ID\n" + 
//		"       AND EPT.PHASE_CODE(+) = itms1.CURRENT_PHASE_CODE\n" + 
//		"       AND EPT.language = USERENV ('LANG')\n" + 
//		"       AND itmt.language = USERENV ('LANG')\n" + 
//		"       AND itms1.INVENTORY_ITEM_ID = TO_NUMBER (esb.pk1_value)\n" + 
//		"       AND itms1.ORGANIZATION_ID = TO_NUMBER (esb.pk2_value)\n" + 
//		"       AND itms1.ORGANIZATION_ID = IOP.ORGANIZATION_ID\n" + 
//		"       AND IOP.organization_code = 'V1'\n" + 
//		"       AND esb.effectivity_control = 1\n" + 
//		"       AND (esb.pk1_value) = 300100552668694\n" + 
//		"\n" + 
//		"\n" + 
//		"UNION ALL \n" + 
//		"SELECT /*+ leading(esb) */ TRIM (LPAD (' ', LEVEL * 2) || LEVEL) Structure_Level,\n" + 
//		"           eic.ITEM_CLASS_NAME ITEM_CLASS,\n" + 
//		"           SYS_CONNECT_BY_PATH (REPLACE(itms1.ITEM_NUMBER,'/','|'), '/') PATH,\n" + 
//		"           itms1.ITEM_NUMBER PARENT,\n" + 
//		"           itms.item_number Item_Name,\n" + 
//		"           TRANSLATE (itmt.DESCRIPTION, CHR(10)||CHR(13), ' ')  as item_description,\n" + 
//		"           (select * FROM (SELECT EIR.REVISION\n" + 
//		"              FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"             WHERE     EIR.INVENTORY_ITEM_ID = itms.INVENTORY_ITEM_ID\n" + 
//		"                   AND EIR.ORGANIZATION_ID = itms.ORGANIZATION_ID\n" + 
//		"                   AND TO_TIMESTAMP (NVL (EIR.END_EFFECTIVITY_DATE, SYSDATE + 1)) >\n" + 
//		"                          (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                   AND EIR.implementation_date IS NOT NULL\n" + 
//		"                   AND (   TO_TIMESTAMP (EIR.effectivity_date) <=\n" + 
//		"                              (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                        OR TO_TIMESTAMP (EIR.effectivity_date) <\n" + 
//		"                              (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"						order by TO_TIMESTAMP (EIR.effectivity_date) desc)\n" + 
//		"                   WHERE ROWNUM = 1)\n" + 
//		"              REVISION,\n" + 
//		"           EPT.PHASE_NAME LIFECYCLE_PHASE,\n" + 
//		"           ecav.ITEM_NUM Sequence,\n" + 
//		"           ecav.COMPONENT_QUANTITY Quantity,\n" + 
//		"           ecav.PRIMARY_UOM_CODE UOM_CODE,\n" + 
//		"           (SELECT RTRIM (\n" + 
//		"                      XMLAGG (\n" + 
//		"                         XMLELEMENT (COMPONENT_REFERENCE_DESIGNATOR,\n" + 
//		"                                     COMPONENT_REFERENCE_DESIGNATOR || '|')).EXTRACT (\n" + 
//		"                         '//text()').getClobVal (),\n" + 
//		"                      '|')\n" + 
//		"              FROM fusion.EGP_REFERENCE_DESIGNATORS ERD\n" + 
//		"             WHERE ERD.COMPONENT_SEQUENCE_ID = ecav.COMPONENT_SEQUENCE_ID\n" + 
//		"			 AND ERD.ACD_TYPE NOT in (3))\n" + 
//		"              Reference_Designator,\n" + 
//		"           TO_CHAR (ecav.EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"              EFFECTIVITY_DATE,\n" + 
//		"           ecav.COMPONENT_YIELD_FACTOR YIELD,\n" + 
//		"           ecav.ATTRIBUTE1 BOM_COMMENTS,\n" + 
//		"           (SELECT DECODE (UPPER (ATTRIBUTE_CHAR4),\n" + 
//		"                           'YES', 'Y',\n" + 
//		"                           'Y', 'Y',\n" + 
//		"                           'NO', 'N',\n" + 
//		"                           'N', 'N')\n" + 
//		"              FROM fusion.EGO_ITEM_EFF_B eieb\n" + 
//		"             WHERE     eieb.CONTEXT_CODE IN ('BRIO_Part_Information')\n" + 
//		"                   AND eieb.inventory_item_id = itms.INVENTORY_ITEM_ID\n" + 
//		"                   AND eieb.organization_id = itms.organization_id\n" + 
//		"                   AND (   TO_TIMESTAMP (eieb.VERSION_START_DATE) <=\n" + 
//		"                              (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                        OR TO_TIMESTAMP (eieb.VERSION_START_DATE) <\n" + 
//		"                              (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"                   AND (   eieb.VERSION_END_DATE IS NULL\n" + 
//		"                        OR eieb.VERSION_END_DATE >=\n" + 
//		"                              (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"				   AND ROWNUM=1)\n" + 
//		"              Critical_comp_flag,\n" + 
//		"           (SELECT ATTRIBUTE_CHAR5\n" + 
//		"              FROM fusion.EGO_ITEM_EFF_B eieb\n" + 
//		"             WHERE     eieb.CONTEXT_CODE IN ('BRIO_Part_Information')\n" + 
//		"                   AND eieb.inventory_item_id = itms.INVENTORY_ITEM_ID\n" + 
//		"                   AND eieb.organization_id = itms.organization_id\n" + 
//		"                   AND (   TO_TIMESTAMP (eieb.VERSION_START_DATE) <=\n" + 
//		"                              (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                        OR TO_TIMESTAMP (eieb.VERSION_START_DATE) <\n" + 
//		"                              (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"                   AND (   eieb.VERSION_END_DATE IS NULL\n" + 
//		"                        OR eieb.VERSION_END_DATE >=\n" + 
//		"                              (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"				   AND ROWNUM=1)\n" + 
//		"              SERVICE_CODE,\n" + 
//		"           (SELECT CASE WHEN COUNT (*) > 0 THEN 'TRUE' ELSE 'FALSE' END\n" + 
//		"              FROM fusion.FND_ATTACHED_DOCUMENTS FAD\n" + 
//		"             WHERE     FAD.entity_name = 'ITEM_ENTITY'\n" + 
//		"                   AND TO_NUMBER (FAD.PK1_VALUE) = itms.organization_id\n" + 
//		"                   AND TO_NUMBER (FAD.PK2_VALUE) = itms.INVENTORY_ITEM_ID)\n" + 
//		"              Attachment,\n" + 
//		"           (SELECT CASE WHEN COUNT (*) > 0 THEN 'TRUE' ELSE 'FALSE' END\n" + 
//		"              FROM fusion.egp_components_b ECAV1\n" + 
//		"             WHERE     ECAV1.obj_name = 'EGO_ITEM'\n" + 
//		"                   AND ECAV.pk1_value = ECAV1.pk1_value\n" + 
//		"                   AND ECAV.pk2_value = ECAV1.pk2_value\n" + 
//		"                   AND ECAV1.bill_sequence_id <> ECAV.bill_sequence_id\n" + 
//		"                   AND (   TO_TIMESTAMP (ECAV1.effectivity_date) <=\n" + 
//		"                              (SELECT TO_TIMESTAMP (EFFECTIVITY_DATE)\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                        OR TO_TIMESTAMP (ECAV1.effectivity_date) <\n" + 
//		"                              (SELECT TO_TIMESTAMP (NVL (END_EFFECTIVITY_DATE, SYSDATE))\n" + 
//		"                                 FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                                WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"                   AND TO_TIMESTAMP (NVL (ECAV1.disable_date, SYSDATE + 1)) >=\n" + 
//		"                          (SELECT NVL (END_EFFECTIVITY_DATE, SYSDATE)\n" + 
//		"                             FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                            WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"              WHERE_USED,\n" + 
//		"           esb.bill_sequence_id,\n" + 
//		"           itms.INVENTORY_ITEM_ID,\n" + 
//		"           itms.ORGANIZATION_ID\n" + 
//		"      \n" + 
//		"FROM fusion.egp_components_b ecav,\n" + 
//		"           fusion.egp_structures_b esb,\n" + 
//		"           fusion.EGP_SYSTEM_ITEMS_b itms,\n" + 
//		"           fusion.EGP_SYSTEM_ITEMS_tl itmt,\n" + 
//		"           fusion.EGP_SYSTEM_ITEMS_b itms1,\n" + 
//		"           fusion.EGP_ITEM_CLASSES_VL eic,\n" + 
//		"           fusion.INV_ORG_PARAMETERS IOP,\n" + 
//		"           fusion.EGP_PHASES_TL EPT\n" + 
//		"     \n" + 
//		"WHERE     ecav.bill_sequence_id = esb.common_bill_sequence_id\n" + 
//		"           AND ECAV.obj_name = 'EGO_ITEM'\n" + 
//		"           AND esb.alternate_bom_designator = 'Primary'\n" + 
//		"           AND itms.ITEM_CATALOG_GROUP_ID = eic.ITEM_CLASS_ID\n" + 
//		"           AND itmt.INVENTORY_ITEM_ID = itms.INVENTORY_ITEM_ID\n" + 
//		"           AND itmt.ORGANIZATION_ID = itms.ORGANIZATION_ID\n" + 
//		"           AND EPT.PHASE_CODE(+) = itms.CURRENT_PHASE_CODE\n" + 
//		"           AND EPT.language = USERENV ('LANG')\n" + 
//		"           AND itmt.language = USERENV ('LANG')\n" + 
//		"           AND itms1.INVENTORY_ITEM_ID = TO_NUMBER (esb.pk1_value)\n" + 
//		"           AND itms1.ORGANIZATION_ID = TO_NUMBER (esb.pk2_value)\n" + 
//		"           AND itms.INVENTORY_ITEM_ID = TO_NUMBER (ecav.pk1_value)\n" + 
//		"           AND itms.ORGANIZATION_ID = TO_NUMBER (ecav.pk2_value)\n" + 
//		"           AND itms1.ORGANIZATION_ID = IOP.ORGANIZATION_ID\n" + 
//		"           AND itms.ORGANIZATION_ID = IOP.ORGANIZATION_ID\n" + 
//		"           AND IOP.organization_code = 'V1'\n" + 
//		"START WITH     (esb.pk1_value) IN (SELECT 300100552668694 FROM DUAL)\n" + 
//		"           AND ECAV.implementation_date IS NOT NULL\n" + 
//		"           AND ECAV.obj_name = 'EGO_ITEM'\n" + 
//		"           AND esb.alternate_bom_designator = 'Primary'\n" + 
//		"           AND esb.effectivity_control = 1\n" + 
//		"		   and ecav.ACD_TYPE not in(3)\n" + 
//		"           AND (   TO_CHAR (ecav.EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS') <=\n" + 
//		"                      (SELECT TO_CHAR (EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                OR TO_CHAR (ecav.EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS') <\n" + 
//		"                      (SELECT TO_CHAR (NVL (END_EFFECTIVITY_DATE, SYSDATE), 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"           AND TO_CHAR (NVL (ecav.disable_date,SYSDATE+ 1), 'YYYY-MM-DD HH24:MI:SS') >\n" + 
//		"                  (SELECT TO_CHAR (NVL (END_EFFECTIVITY_DATE, SYSDATE), 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                     FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                    WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"CONNECT BY     ESB.PK1_VALUE = PRIOR ecav.pk1_value\n" + 
//		"           AND ECAV.PK2_VALUE = TO_CHAR (IOP.ORGANIZATION_ID)\n" + 
//		"           AND esb.pk2_value = TO_CHAR (IOP.ORGANIZATION_ID)\n" + 
//		"           AND esb.alternate_bom_designator = 'Primary'\n" + 
//		"		   and ecav.ACD_TYPE not in(3)\n" + 
//		"           AND esb.effectivity_control = 1\n" + 
//		"           AND (   TO_CHAR (ecav.EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS') <=\n" + 
//		"                      (SELECT TO_CHAR (EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"                OR TO_CHAR (ecav.EFFECTIVITY_DATE, 'YYYY-MM-DD HH24:MI:SS') <\n" + 
//		"                      (SELECT TO_CHAR (NVL (END_EFFECTIVITY_DATE, SYSDATE), 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                         FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                        WHERE EIR.REVISION_ID = 300100552668695))\n" + 
//		"           AND TO_CHAR (NVL (ecav.disable_date,SYSDATE+ 1), 'YYYY-MM-DD HH24:MI:SS') >\n" + 
//		"                  (SELECT TO_CHAR (NVL (END_EFFECTIVITY_DATE, SYSDATE), 'YYYY-MM-DD HH24:MI:SS')\n" + 
//		"                     FROM fusion.EGP_ITEM_REVISIONS_B EIR\n" + 
//		"                    WHERE EIR.REVISION_ID = 300100552668695)\n" + 
//		"           AND ecav.implementation_date IS NOT NULL\n" + 
//		"           AND ecav.obj_name = 'EGO_ITEM'\n" + 
//		"");
//while(rs.next())
//System.out.println(rs.getString(1));
//
//connection.close();
//
//}
//
//catch(Exception e){ System.out.println(e);}
//
}
}