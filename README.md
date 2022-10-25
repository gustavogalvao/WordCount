# WordCountJSON
Spring Boot, Spring MVC, Spring Security and REST JSON, counting words in a sample paragraph returning the result in curl command

Technologies used :
====================

Spring boot 2.7.5 <br />
Spring 5.3.23 <br />
Spring Security 5.7.4 <br />
Maven 3 <br />
Lombok 1.2 <br />
JDK 11 <br />
Apache Tomcat Embed 9 <br />
IntelliJ <br />

Build the project

  git clone https://github.com/gustavogalvao/WordCount.git <br /> 
  cd WordCount
  <br />
  mvn spring-boot:run <br /> 

Running tasks and outputs:

Run task 1: <br />
$ curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d'{"searchText":["Duis","Sed","Augue","Donec","Pellentesque","123"]}' -H "Content-Type: application/json" -X POST
<br /> <br />
Output: <br />
{"counts":[{"Duis":11},{"Sed":16},{"Augue":7},{"Donec":8},{"Pellentesque":6},{"123":0}]}
<br /> <br />

Run task 2: <br />
$ curl http://localhost:8080/counter-api/top/25 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw=="
<br /> <br />
Output: <br />
17|eget
17|vel
16|sed
15|in
14|et
13|eu
13|ut
12|ac
12|amet
12|id
12|metus
12|nulla
12|sit
11|at
11|duis
11|ipsum
11|nec
11|vitae
10|aliquam
10|dolor
10|non
10|nunc
9|a
9|consectetur
9|leo
