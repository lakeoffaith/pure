##ijoy User API
	
####注册####
	
    
***url***:/loginInfo/register 
    
***request***:post   reponse:json
    
***needAuthorized***:false
    
    params
    	name			昵称（qq,weibo等名称）
        password			
        qqid			
        weiboid			openid
        avatar			openid
        type			登录的类型（qq为qq,weibo为weibo,weibo,手动为handle）
        clientSID		注册的平台类型（yyghAndroid）
   
   
   
   	return
    	{
        	"id":3
        	"status":true
        }
    	
    id:用户在表中的id
    status:注册状态
    