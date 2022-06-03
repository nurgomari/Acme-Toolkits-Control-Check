
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox placeholder="ABC-123-A-yy-mm-dd" code="inventor.chimpum.list.label.code" path="code"/>
	<acme:input-moment code="inventor.chimpum.list.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:input-moment code="inventor.chimpum.list.label.startTime" path="startTime"/>
	<acme:input-moment code="inventor.chimpum.list.label.endTime" path="endTime"/>
	<acme:input-textbox placeholder="Lorem ipsum" code="inventor.chimpum.list.label.title" path="title"/>
	<acme:input-textbox placeholder="Lorem ipsum" code="inventor.chimpum.list.label.description" path="description"/>
	<acme:input-money code="inventor.chimpum.list.label.budget" path="budget"/>
	<acme:input-textbox placeholder="http://www.example.com" code="inventor.chimpum.list.label.link" path="link"/>
	
	<jstl:choose>
	<jstl:when test="${command=='show'}">
			<h2>
				<acme:message code="inventor.chimpum.message.invention" />
			</h2>
			<acme:input-textbox code="inventor.chimpum.form.label.invention.name"
				path="name" readonly="true"/>
			<acme:input-textbox
				code="inventor.chimpum.form.label.invention.code" path="inventionCode" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum..form.label.invention.description"
				path="inventionDescription" readonly="true"/>

		</jstl:when>

	</jstl:choose>
	
	
</acme:form>