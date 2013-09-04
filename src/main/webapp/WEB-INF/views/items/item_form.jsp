<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<form:form commandName="item">
	<form:errors path="*" element="div" />
	
	<label for="item_description">Description:</label>
	<form:input path="description" />
	<label for="item_priority">Priority:</label>
	<form:input path="priority" />
	
	<div class="form controlls">
		<input type="submit" value = "send" class="btn btn-success" />
	</div>
</form:form>