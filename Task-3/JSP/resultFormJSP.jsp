<html>
   <head>
      <title>Using GET and POST Method to Read Form Data</title>
   </head>
   
   <body>
      <center>
      
      <ul>
         <li><p><b>First Name:</b>
            <%= request.getParameter("first_name")%>
         </p></li>
         <li><p><b>Last  Name:</b>
            <%= request.getParameter("last_name")%>
         </p></li>
		 
		 <li>
			<p>
				<b>Year:</b>
		                <%= request.getParameter("year") %>
		  </p>
	  </li>
      </ul>
   </body>
</html>