<%@ page contentType="text/html;charset=GB2312"%>
<%@ taglib uri="ListTagLib" prefix="list"%>
<html>
	<head>
		<title>在JSP页面中调用 myfont 标签</title>
	</head>
	<body>
		<h2>
			myfont 标签
		</h2>
		<list:view DBTab="info" field="id,title,time" linkField="title" linkTo="infoAction!infoShow.action" linkID="id" showNum="20">  			
		</list:view>
		
	</body>
</html>
