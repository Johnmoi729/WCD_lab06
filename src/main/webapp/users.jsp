<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
    </tr>
    <c:forEach items="${sessionScope.users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>