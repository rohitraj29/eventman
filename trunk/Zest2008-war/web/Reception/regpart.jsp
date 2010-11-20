<%-- 
    Document   : regpart
    Created on : Oct 3, 2008, 10:37:53 AM
    Author     : root
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="regview">
<rich:panel header="Register Participants">
    <h:form>

    <table> 
        <tr>
            <td>
                
                <h:outputText value="Enter Participant name"/>
            </td>
            <td>
               <h:inputText value="#{PartRegBean.partname}">
                <a4j:support ajaxSingle="true" event="onblur" />
            </h:inputText>
                
            </td>
        </tr>
        <tr>
            <td>
                <h:outputText value="Enter Registration number"/>
            </td>
            <td>
                <h:inputText value="#{PartRegBean.partregno}">
                     <a4j:support ajaxSingle="true" event="onblur" />
                 </h:inputText>
            </td>
        </tr>
        <tr>
            <td>
                <h:outputText value="Select Participant College"/>
            </td>
            <td>
                <rich:comboBox value="#{PartRegBean.partcollege}" valueChangeListener="#{PartRegBean.changeFired}" defaultLabel="Please Select College" immediate="true" width="120">
                    <a4j:support ajaxSingle="true" event="onchange"/>
                    <f:selectItems  value="#{CollegeBean.collegelist}"/>
                    
                </rich:comboBox>
                
            </td>
            
        </tr>
        <tr>
            <td>
                <a4j:commandButton action="#{PartRegBean.register}" value="Register Participant" reRender="pm" immediate="true" limitToList="true"/>
                
            </td>
            <td>
                <a4j:commandButton  action="#{PartRegBean.clear}" value="Clear Details"reRender="pm" immediate="true" limitToList="true"/>
            </td>
        </tr>
    </table>

    </h:form>
</rich:panel>
</f:subview>