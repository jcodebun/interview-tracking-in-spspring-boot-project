<%@page import="java.text.DateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page import="java.util.Date"%>


<%DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"); %>


<body>
<section class="vh-100 gradient-custom ">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
           <%@include file="businessMessage.jsp" %>
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Schedule Interview</h3>

            <sf:form method="post" action="${pageContext.request.contextPath}/AddScheduleInterview" modelAttribute="form">
            <sf:input type="hidden" id="id" class="form-control form-control-lg" path="id" name="id" value="${form.id}"/>
            <sf:input type="hidden" id="userid" class="form-control form-control-lg" path="userid" name="userid" value="${userDTO.id}"/>
            
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">   
                  <s:bind path="firstName">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                  <sf:input type="text" id="firstName" class="form-control form-control-lg" path="firstName" name="firstName" value="${userDTO.firstName}" readonly="true"/>
                  </s:bind>      
                  <label class="form-label" for="firstName">First Name</label>        
                  </div>
				 
                </div>
                <div class="col-md-6 mb-4">
                
                  <div class="form-outline">
                  <s:bind path="lastName">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="text" id="lastName" class="form-control form-control-lg" path="lastName" value="${userDTO.lastName}" readonly="true"/>
                    <label class="form-label" for="lastName">Last Name</label>
                  </s:bind>
                  </div>
               
                </div>
                
                    <div class="col-md-6 mb-4 pb-2">
                  <s:bind path="email">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="email" id="emailAddress" class="form-control form-control-lg"  path="email" value="${userDTO.email}" readonly="true"/>
                    <label class="form-label" for="emailAddress">Email</label>
                  </div>
                  </s:bind>

                </div>
                
                
                    <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="phoneNumber">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="tel" id="phoneNumber" class="form-control form-control-lg" path="phoneNumber" value="${userDTO.phoneNumber}" readonly="true" />
                    <label class="form-label" for="phoneNumber">Phone Number</label>
                  </div>
					</s:bind>
                </div> 
                
                
                        <div class="col-md-6 mb-4 d-flex align-items-center">
                  <s:bind path="date">
                  <div class="form-outline datepicker w-100">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="date" class="form-control form-control-lg" id="date" path="date" placeholder="dd/MM/yyyy" />
                    <label for="date" class="form-label">date</label>
                  </div>
                  </s:bind>

                </div>
                
               <div class="col-md-6 mb-4 d-flex align-items-center">
                  <s:bind path="time">
                  <div class="form-outline datepicker w-100">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="time" class="form-control form-control-lg" id="time" path="time" placeholder="Enter time" />
                    <label for="time" class="form-label">Time</label>
                  </div>
                  </s:bind>

                </div>
                
               <div class="col-md-6 mb-4 d-flex align-items-center">
                  <s:bind path="scheduleWithId">
                  <div class="form-outline datepicker w-100">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:select class="select form-control-lg" path="scheduleWithId">
               		 <option selected="true" disabled="disabled">Select Schedule With</option> 
                		<c:forEach var="userType" items="${userTypeList}">
                		<sf:option value="${userType.id}" label="${userType.firstName}"/>
                		</c:forEach>
            	    </sf:select>
                    <label for="time" class="form-label">Schedule With</label>
                  </div>
                  </s:bind>

                </div>
                  
             <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Add" />
              </div>
  			
        </div>

      
              
           </sf:form>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>