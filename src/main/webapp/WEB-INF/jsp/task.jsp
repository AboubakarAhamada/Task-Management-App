<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Add Task</div>
    <div class="panel-body">
    
     <form:form method="post" modelAttribute="task">
     
      <form:hidden path="id" />
      
      <fieldset class="form-group">
       <form:label path="name">Name</form:label>
       <form:input path="name" type="text" class="form-control"
        required="required" />
       <form:errors path="name" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="priority">Priority</form:label>
       <form:input path="priority" type="text" class="form-control"
        required="required" />
       <form:errors path="priority" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="description">Description</form:label>
       <form:input path="description" type="text" class="form-control"
        required="required" />
       <form:errors path="description" cssClass="text-warning" />
      </fieldset>

      <fieldset class="form-group">
       <form:label path="date">Date</form:label>
       <form:input path="date" type="text" class="form-control"
        placeholder="dd/mm/yyyy" required="required" />
       <form:errors path="date" cssClass="text-warning" />
      </fieldset>

      <button type="submit" class="btn btn-success">Save</button> 
      &nbsp; &nbsp; &nbsp; &nbsp; 
      <a href="/list-tasks" class="btn btn-default">Cancel</a>
      
      
     </form:form>
     
    </div>
   </div>
  </div>
 </div>
</div>
<%-- 
<%@ include file="common/footer.jsp"%>
--%>