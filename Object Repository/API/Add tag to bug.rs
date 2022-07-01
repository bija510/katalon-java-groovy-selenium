<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Add tag to bug</name>
   <tag></tag>
   <elementGuidId>c30c5a2e-c666-4317-b835-47e900719ec3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;[\n\t{\n      \&quot;op\&quot; :\&quot;add\&quot; ,\n      \&quot;path\&quot;:\&quot;/fields/System.Tags\&quot; ,\n      \&quot;from\&quot; :null ,\n      \&quot;value\&quot; : \&quot;Automation\&quot;\n\t}\n]&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic ${basic_auth_pw}</value>
   </httpHeaderProperties>
   <katalonVersion>8.0.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PATCH</restRequestMethod>
   <restUrl>https://dev.azure.com/${org}/${project}/_apis/wit/workitems/$bug?api-version=6.0</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.gOrg</defaultValue>
      <description></description>
      <id>603c2472-a96c-492d-a62a-69247ef49070</id>
      <masked>false</masked>
      <name>org</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.gProject</defaultValue>
      <description></description>
      <id>971b33ec-8ea2-4a56-b4f8-fc378f24db64</id>
      <masked>false</masked>
      <name>project</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.gTeam</defaultValue>
      <description></description>
      <id>32ba392d-178d-43cd-b32e-f160d07512eb</id>
      <masked>false</masked>
      <name>team</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.gwi_title</defaultValue>
      <description></description>
      <id>0c5b4e0c-a348-4044-99e1-16aff8f310ec</id>
      <masked>false</masked>
      <name>wi_title</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.gwi_id</defaultValue>
      <description></description>
      <id>87c1bb7c-5289-4b91-9557-f02b5330897b</id>
      <masked>false</masked>
      <name>wi_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.gbasic_auth_pw</defaultValue>
      <description></description>
      <id>7227b47b-3923-4055-b5b8-e13c0622d8d6</id>
      <masked>false</masked>
      <name>basic_auth_pw</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
