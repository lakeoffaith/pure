insert into 
EMPLOYEE(id,realName,name,cellphone,homePath,workPath)
values('1','系统管理员','admin1','12345567','中和街道三段','人民南路四段');

insert into 
EMPLOYEE(id,realName,name,cellphone,homePath,workPath)
values('2','系统用户','admin3','1234','admin3homePath','admin3workPath');

insert into
LOGININFO(id,name,password,state,rememberdays)
values('1','admin1','admin1','1','1');

insert into
LOGININFO(id,name,password,state,rememberdays)
values('2','admin3','admin3','1','1');



insert into
SYSLOGINFO(id,content)
values(1,'用户1的登陆信息');

insert into
SYSLOGINFO(id,content)
values(2,'用户2的登陆信息');


insert into
ROLE(id,name,describe)
values('1','管理员','系统管理员');


insert into
ROLE(id,name,describe)
values('2','用户','普通用户');
update EMPLOYEE set role_id=1 where id=1;
update EMPLOYEE set role_id=2 where id=2;

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('1','管理系统',NULL,NULL,1,1,'icon-cogs');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('2','应用管理',NULL,NULL,2,1,'icon-tablet');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('3','个人办公',NULL,NULL,3,1,'icon-user');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('4','项目管理','task',NULL,4,1,'icon-paste');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('5','统计分析','application',NULL,5,1,'icon-bar-chart');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('6','日志管理','sysloginfo',NULL,6,1,'icon-book');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('7','在线咨询',NULL,NULL,7,1,'icon-comment');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('8','角色管理','role',1,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('9','员工管理','employee',1,2,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('10','菜单管理','menu',1,3,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('11','权限配置','permission',1,4,1,'');


insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('12','应用配置','application',2,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('13','应用查询','application',2,2,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('14','我的应用','application',3,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('15','我的任务','task',3,2,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('16','用户反馈','feedback',7,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values('17','反馈管理','feedback',7,2,1,'');

insert into
ROLE_MENU(role_id,menu_id)
values(1,1);
insert into
ROLE_MENU(role_id,menu_id)
values(1,2);
insert into
ROLE_MENU(role_id,menu_id)
values(1,3);
insert into
ROLE_MENU(role_id,menu_id)
values(1,4);
insert into
ROLE_MENU(role_id,menu_id)
values(1,5);
insert into
ROLE_MENU(role_id,menu_id)
values(1,6);
insert into
ROLE_MENU(role_id,menu_id)
values(1,7);
insert into
ROLE_MENU(role_id,menu_id)
values(2,2);

insert into 
APPLICATION(id,name,brief,state,docpath)
values(1,'预约挂号'，'预约挂号'，1，'预约中心');

insert into
APPLICATION(id,name,brief,state,docpath)
values(2,'院长决策'，'院长决策'，1，'院长办公室');

insert into
FEEDBACK(id,content)
values(1,'系统不错');


insert into
TASK(id,name,month,taskcycle,describe,type,state,employee_id)
values(1,'无线网安装',4,4,'科室无线网络覆盖',1,1,1);

insert into
TASKITEM(id,itemCycle,itemtype,itemdescribe,department,state,task_id,employee_id)
values(1,1,1,'无线网安装一阶段','信息科',2,1,2);





COMMIT;
