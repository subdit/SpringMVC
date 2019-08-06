<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <div class="col-md-offset-1 col-md-10">

            <form action="${pageContext.request.contextPath}/GetAddProducts">            
                <input class="btn btn-primary" type="submit" value="Add Product" />
            </form>

            <br /><br />
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">
                        Product List <span ><p>${messageResult}</p></span>
                    </div>
                </div>
                <div class="panel-body">


                    <table class="table table-striped table-bordered">

                        <tr>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Option</th>
                        </tr>

                        <c:forEach var="product" items="${productsList}">
                            <tr>
                                <td>${product.pName}</td>
                                <td>${product.pImage}</td>
                                <td>${product.pDescription}</td>
                                <td>${product.pQuantity}</td>
                                <td>${product.pPrice}</td>
                                <td>${product.pOption}</td>
                                <!-- display the update link -->
                                <td><a
                                    href="${pageContext.request.contextPath}/editproduct/${product.pId}">Update</a></td>

                                <!-- display the Delete link -->
                                <td><a
                                    href="${pageContext.request.contextPath}/removeProduct/${product.pId}">Delete</a></td>


                            </tr>
                        </c:forEach>
                    </table>
                 </div>
  			 </div>
  		</div>
	</div>
</body>
</html>