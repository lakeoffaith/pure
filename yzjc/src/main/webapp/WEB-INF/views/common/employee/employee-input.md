后台方法：getOwnApplicationByEmployeeId    通过用户的id去查找已经分配的应用；
									通过baseQuery.employeeid    IApplicationService.queryApplicationJoinEmployeeThirdPage(BaseQuery)
					 getNotOwnApplicationByEmployeeId  通过用户的id去查找未分配给自己的应用；
					 				通过baseQuery.notEmployeeid IApplicationService.queryApplicationJoinEMployeeTwoPage
					 				select a.name from APPLICATION a left join EMPLOYEE_APPLICATION e_a on a.id=e_a.APPLICATION_ID where e_a.EMPLOYEE_ID is null or e_a.EMPLOYEE_ID !=2;
                                 select * from (select a.*,rownum rnum from (select b.* from application b left join employee_application e_a on e_a.application_id=b.id WHERE e_a.employee_id is null or e_a.employee_id != 2 order by b.id)a where rownum < 10 ) where rnum>=0 