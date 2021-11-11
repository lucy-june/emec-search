在tomcat下部署solr：
1.到官网下载新的solr并解压。（开发时用的4.10.0）
2.solr\dist 目录下的solr-4.xx.x.war 拷贝到tomcat安装目录的webapps文件夹下。
3.将solr\ext 文件夹下的jar文件拷贝到tomcat安装目录下lib文件夹下，并把solr\resources文件夹下的log4j.properties也考到tomcat—>lib下面。
4.启动tomcat，此时tomcat会把solr.war进行解压，生成一个solr文件夹；停止tomcat，删除solr-4.10.0.war。
5.将本目录下的solrhome拷贝到机器的合适位置。
6.用编辑器打开tomcat下面的solr/WEB-INF/web.xml，找到下面的代码:
  <!--
    <env-entry>
       <env-entry-name>solr/home</env-entry-name>
       <env-entry-value>/put/your/solr/home/here</env-entry-value>
       <env-entry-type>java.lang.String</env-entry-type>
    </env-entry>
  -->
  取消注释，并将<env-entry-value>的值指向solrhome目录。
7.将solr\dist下的solr-analysis-extras-xx、solr-cell-xx.jar、solr-clustering-xx.jar、solr-dataimporthandler-xx.jar、solr-dataimporthandler-extras-xx.jar、solr-langid-xx.jar、solr-velocity-xx.jar拷贝到solrhome\huijin\lib下。
8.启动tomcat。


配置搜索历史记录：
1.将searchlog/searchlog.jar复制到solr\WEB-INF\lib下。
2.在solr\WEB-INF\web.xml配置文件里添加过滤器：
<filter>

	<filter-name>SearchLog</filter-name>

	<filter-class>com.huijin.logfilter.SearchLog</filter-class>

</filter>

  
<filter-mapping>

	<filter-name>SearchLog</filter-name>

	<url-pattern>/*</url-pattern>
  
</filter-mapping>
注意：SearchLog的filter-mapping一定要放在SolrRequestFilter的filter-mapping之前。
3.重启tomcat。