<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Goldiesssss</title>
   <style>
        header{
            height: 100px;
            padding: 15px;
            display: flex;
        }

        header div{
            margin-left: 10px;
            width:100px;
            height: 30px;
            border: 1px solid black;
            padding: 5px;
        }
        section{
            display: flex;
            justify-content: space-around;
        }
        .box{
            width: 250px;
            height: 250px;
            border: 5px black solid;
            margin: 20px;
            padding: 10px;
        }
        .box h2,.box p{
            text-align: center;
        }
        footer div{
            width: 90%;
            height: 250px;
            margin: auto;
            border:2px grey solid;
            background-color: rgb(68, 47, 47);

        }
        footer h5{
            width: 90%;
            margin: auto;
        }
        footer div p{
          color: rgb(0, 255, 0);
          margin-left: 4px;
          margin-bottom:0px ;
        }
    </style>
</head>
<body>
    <main>
      <header>
          <h3>Your Gold:</h3>
          <div><p>${gold}</p></div>
    </header>
      <section>
          <div class="box">
              <h2>Farm</h2>
              <p>(earns 1-20 golds)</p>
              <form method="POST" action="/lol">
              		<input type="hidden" value="1" name="goldInput">
                  <button type="submit">Find Gold!</button>
              </form>
            </div>
            <div class="box">
              <h2>War</h2>
              <p>(earns 100-150 golds)</p>
              <form method="POST" action="/lol">
              <input type="hidden" value="2" name="goldInput">
                  <button type="submit">Find Gold!</button>
              </form>
            </div>
            <div class="box">
              <h2>Home</h2>
              <p>(gets -5 -> -10 golds)</p>
              <form method="POST" action="/lol">
              <input type="hidden" value="3" name="goldInput">
                  <button type="submit">Find Gold!</button>
              </form>
            </div>
            <div class="box">
              <h2>Army</h2>
              <p>(gets 50-100 golds)</p>
              <form method="POST" action="/lol">
              <input type="hidden" value="4" name="goldInput">
                  <button type="submit">Find Gold!</button>
              </form>
            </div>

      </section>
      <footer>
          <h5>Activities:</h5>
          <div>
          
          <c:forEach items="${arr}" var="value">
			  <p>${value}</p>
			 </c:forEach>
          
         
        </div>
      </footer>
    </main>
</body>
</html>