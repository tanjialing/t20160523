<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib uri="ListTagLib" prefix="list"%>
<html>
	<head>
		<title>��JSPҳ���е��� myfont ��ǩ</title>
	</head>
	<body>
		<h2>
			myfont ��ǩ
		</h2>
		<list:view DBTab="info" field="id,title,time" linkField="title" linkTo="infoAction!infoShow.action" linkID="id" showNum="20">  			
		</list:view>
		
	</body>
</html>
