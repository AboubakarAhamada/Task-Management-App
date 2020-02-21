<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/add-task">Add Task</a>
  
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>List of Task</h3>
  </div>
  <div class="panel-body">
   <table class="table table-bordered table-hover">
    <thead>
     <tr>
      <th width="20%">Name</th>
      <th width="20%">Description</th>
      <th width="20%">Priority</th>
      <th width="20%">Date</th>
      <th width="20%">Operations</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${tasks}" var="task">
      <tr>
       <td>${task.name}</td>
       <td>${task.description}</td>
       <td>${task.priority}</td>
       <td><fmt:formatDate value="${task.date}"
         pattern="dd/MM/yyyy" /></td>
       <td><a type="button" class="btn btn-success"
        href="/update-task?id=${task.id}">Update</a>
       <a type="button" class="btn btn-danger"
         href="/delete-task?id=${task.id}">Delete</a></td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%--
<%@ include file="common/footer.jsp"%>
--%>