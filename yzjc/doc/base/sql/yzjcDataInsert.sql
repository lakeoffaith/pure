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
values(SYSLOGINFO_SEQ.NEXTVAL,'用户1的登陆信息');

insert into
SYSLOGINFO(id,content)
values(SYSLOGINFO_SEQ.NEXTVAL,'用户2的登陆信息');


insert into
ROLE(id,name,describe)
values(ROLE_SEQ.nextval,'管理员','系统管理员');


insert into
ROLE(id,name,describe)
values(ROLE_SEQ.nextval,'用户','普通用户');
update EMPLOYEE set role_id=1 where id=1;
update EMPLOYEE set role_id=2 where id=2;

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'管理系统',NULL,NULL,1,1,'icon-cogs');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'收入统计',NULL,NULL,2,1,'icon-tablet');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'工作量统计',NULL,NULL,3,1,'icon-user');


insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'角色管理','role',1,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'员工管理','employee',1,2,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'菜单管理','menu',1,3,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'权限配置','permission',1,4,1,'');


insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'全院总收入','income?section=hospital',2,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'门诊收入','income?section=menzhen',2,2,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'急诊收入','income?section=jizhen',2,3,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'住院收入','income?section=zhuyuan',2,4,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'门诊挂号人次','workload?section=menzhen',3,1,1,'');

insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'急诊挂号人次','workload?section=jizhen',3,2,1,'');
insert into
MENU(id,name,url,parent_id,orderid,type,iconname)
values(MENU_SEQ.NEXTVAL,'入院人次','workload?section=hospital',3,3,1,'');



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
values(2,2);

insert into
ROLE_MENU(role_id,menu_id)
values(2,3);

COMMIT;
