��tomcat�²���solr��
1.�����������µ�solr����ѹ��������ʱ�õ�4.10.0��
2.solr\dist Ŀ¼�µ�solr-4.xx.x.war ������tomcat��װĿ¼��webapps�ļ����¡�
3.��solr\ext �ļ����µ�jar�ļ�������tomcat��װĿ¼��lib�ļ����£�����solr\resources�ļ����µ�log4j.propertiesҲ����tomcat��>lib���档
4.����tomcat����ʱtomcat���solr.war���н�ѹ������һ��solr�ļ��У�ֹͣtomcat��ɾ��solr-4.10.0.war��
5.����Ŀ¼�µ�solrhome�����������ĺ���λ�á�
6.�ñ༭����tomcat�����solr/WEB-INF/web.xml���ҵ�����Ĵ���:
  <!--
    <env-entry>
       <env-entry-name>solr/home</env-entry-name>
       <env-entry-value>/put/your/solr/home/here</env-entry-value>
       <env-entry-type>java.lang.String</env-entry-type>
    </env-entry>
  -->
  ȡ��ע�ͣ�����<env-entry-value>��ֵָ��solrhomeĿ¼��
7.��solr\dist�µ�solr-analysis-extras-xx��solr-cell-xx.jar��solr-clustering-xx.jar��solr-dataimporthandler-xx.jar��solr-dataimporthandler-extras-xx.jar��solr-langid-xx.jar��solr-velocity-xx.jar������solrhome\huijin\lib�¡�
8.����tomcat��


����������ʷ��¼��
1.��searchlog/searchlog.jar���Ƶ�solr\WEB-INF\lib�¡�
2.��solr\WEB-INF\web.xml�����ļ�����ӹ�������
<filter>

	<filter-name>SearchLog</filter-name>

	<filter-class>com.huijin.logfilter.SearchLog</filter-class>

</filter>

  
<filter-mapping>

	<filter-name>SearchLog</filter-name>

	<url-pattern>/*</url-pattern>
  
</filter-mapping>
ע�⣺SearchLog��filter-mappingһ��Ҫ����SolrRequestFilter��filter-mapping֮ǰ��
3.����tomcat��