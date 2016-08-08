数据库配置文件dbconfig.properties在Exam1\src\main\resources目录下面


在cmd进入Exam1目录下运行mvn jetty:run

在浏览器输入localhost:8080即可

默认为index.jsp页面，点击登录链接就可以进入登录

若没有登录，在浏览器中输入
http://localhost:8080/user/allfilm.jsp
http://localhost:8080/user/addflim.hsp
都会自动跳转登录界面

因为film表中数据过多，每次修改后该项数据都会变成最后一列，在数据库中可以查出数据已经修改
