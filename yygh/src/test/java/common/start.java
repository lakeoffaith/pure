package common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.comutil.HttpCity;
import com.ijoy.common.comutil.HttpDoctor;
import com.ijoy.common.comutil.dataCollection.ApixUtil;
import com.ijoy.common.domain.City;
import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.domain.Province;
import com.ijoy.common.domain.Region;
import com.ijoy.common.mapper.CityMapper;
import com.ijoy.common.mapper.DepartmentMapper;
import com.ijoy.common.mapper.DoctorMapper;
import com.ijoy.common.mapper.EmployeeMapper;
import com.ijoy.common.mapper.HospitalMapper;
import com.ijoy.common.mapper.ProvinceMapper;
import com.ijoy.common.mapper.RegionMapper;
import com.ijoy.gh.domain.Dictionary;
import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.mapper.DictionaryMapper;
import com.ijoy.gh.mapper.ScheduleMapper;
import com.ijoy.gh.test.BaseTest;

public class start extends BaseTest{
	      
	    /* @Test*/
	     public void fire() throws Exception{
	    	 clearData();
	    	 loadData();
	     }
	
	      public boolean  clearData(){
	    	  return false;
	      }
	/**
	 * 成都    id  317
	 * 华西        5                                      11050 | 骨科            | 11051 | 内科            || 19600 | 精神心理科         
	 * 口腔      104                                     11092 | 口腔科   
	 * 第一人民医院  534                      | 11387 | 骨科      || 11388 | 妇产科 
	 * 四川省肿瘤医院  504                  11367 | 肿瘤科   
	 * 
	 * @return
	 * @throws Exception 
	 */
	      
			public  boolean loadData() throws Exception{
				//0:加载数据词典
				loadDictionaryData();
				
				//1:加载区域数据
				loadRegionData();
				//2:加载省   
				loadProvinceData();
				
				//3:加载城市
				loadCityData();
				
				//4:加载医院
				loadHospitalData();
				
				//5:加载科室
				loadDepartmentData();
				
				//6:根据citypy.json  文件，对已有city数据进行扩充
				fixCityData();
				
				//7:更新热门城市
				updateHotCityData();
				
				//8:根据doctor.json文件 ,添加doctor数据
				loadDoctorData();
				
				//9:导入测试用户
				loadTestEmployeeData();
				
				//10:导入测试医生排班表
				loadTestScheduleData();
				
				return false;
			}
			@Autowired
			DictionaryMapper dictionaryMapper;
			
			public void loadDictionaryData(){
				Dictionary dictionary;
				dictionary = new Dictionary("三甲医院","hos-level-0");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("三乙医院","hos-level-1");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("二甲医院","hos-level-2");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("二乙医院","hos-level-3");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("综合医院","hos-type-1");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("男性专科","hos-type-2");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("健康体检","hos-type-3");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("泌尿外科","hos-type-4");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("口腔专科","hos-type-5");
				dictionaryMapper.insert(dictionary);
			}
			
			
			/**
			 * 成都    id  317
			 * 华西        5                                      11050 | 骨科            | 11051 | 内科            || 19600 | 精神心理科         
			 * 口腔      104                                     11092 | 口腔科   
			 * 第一人民医院  534                      | 11387 | 骨科      || 11388 | 妇产科 
			 * 四川省肿瘤医院  504                  11367 | 肿瘤科   
			 * 
			 * @return
			 */
			
			public void loadDictionaryData_Dep(){
				System.out.println(dictionaryMapper+"-----------------");
				Dictionary dictionary;
				dictionary = new Dictionary("国家重点","dep-level-0");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("省级重点","dep-level-1");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("市级重点","dep-level-2");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("普通科室","dep-level-3");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("妇产科","dep-type-1");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("口腔科","dep-type-2");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("内科","dep-type-3");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("儿科","dep-type-4");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("五官科","dep-type-5");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("骨科","dep-type-6");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("心理科","dep-type-7");
				dictionaryMapper.insert(dictionary);
				dictionary = new Dictionary("肿瘤科","dep-type-8");
				dictionaryMapper.insert(dictionary);
			}
			
			


	/**
	   * 加载区域数据    --area.		
	   * @return
	   */
			@Autowired
		      public RegionMapper regionMapper;
			@Test
		public void  loadRegionData(){
			Map  fileMap=new HashMap<>();
			fileMap.put("region", "name");
			Map<String,Object> map=new HashMap<String,Object>();
			map.put(ApixUtil.CHANGEFILEMAP, fileMap);
			map.put(ApixUtil.FILTERFILELIST,new String[]{"areas"} );
			List<Region> regionList= ApixUtil.getLIst("http://a.apix.cn/yi18/hospital/region?type=all", Region.class,map);
			System.out.println(regionList);
			if(regionList.size()==0){
			}
			try {
				for (int i = 0; i < regionList.size(); i++) {
				/*regionMapper.insert(regionList.get(i));*/
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			@Autowired
			ProvinceMapper provinceMapper;
			
			/**
			 * 前提是区域加载好了
			 */
	  public  void loadProvinceData() {
				String url=null;
				Map jsonDealMap = new HashMap<>();
				jsonDealMap.put(ApixUtil.FILTERFILELIST, new String[]{"region"});
				Map changFileMap=new HashMap<>();
				changFileMap.put("province", "name");
				jsonDealMap.put(ApixUtil.CHANGEFILEMAP, changFileMap);
				
				List regionList = (List) regionMapper.getAll();
				for (int i = 0; i < regionList.size(); i++) {
					Region r=(Region)regionList.get(i);
					Long reginon_id=r.getId();
					url="http://a.apix.cn/yi18/hospital/province?id="+reginon_id;
					List<Province> provinceList=ApixUtil.getLIst(url, Province.class, jsonDealMap);
					//加入省份的区域关联
					for (int j = 0; j < provinceList.size(); j++) {
					 Province p=provinceList.get(j);
					 p.setRegion_id(reginon_id);
					 provinceMapper.insert(p);
					 
					}
					System.out.println(provinceList);
				}
			}
			
		 /**
		  * 加载城市，前提省加载完成
		  */
			@Autowired
			CityMapper  cityMapper;
			public void loadCityData(){
				String url=null;
				Map jsonDealMap = new HashMap<>();
				jsonDealMap.put(ApixUtil.FILTERFILELIST, new String[]{"province"});
				Map changFileMap=new HashMap<>();
				changFileMap.put("city", "name");
				jsonDealMap.put(ApixUtil.CHANGEFILEMAP, changFileMap);
				
				List list = (List) provinceMapper.getAll();
				for (int i = 0; i < list.size(); i++) {
					Province r=(Province)list.get(i);
					Long  province_id=r.getId();
					url="http://a.apix.cn/yi18/hospital/city?id="+province_id;
					List<City> cityList=ApixUtil.getLIst(url, City.class, jsonDealMap);
					for (int j = 0; j < cityList.size(); j++) {
					 City  p=cityList.get(j);
					p.setProvince_id(province_id);
					 cityMapper.insert(p);
					}
					System.out.println(cityList);
				}
			}
			@Autowired
			HospitalMapper hospitalMapper;
			/**
			 * 加载医院
			 */
			public void loadHospitalData(){
				String url=null;
				Map jsonDealMap = new HashMap<>();
				jsonDealMap.put(ApixUtil.FILTERFILELIST, new String[]{"area"});
				
				List list = (List) cityMapper.getAll();
				for (int i = 0; i < list.size(); i++) {
					City r=(City)list.get(i);
					Long  city_id=r.getId();
					url="http://a.apix.cn/yi18/hospital/list?id="+city_id+"";
					List<Hospital> hospitalList=ApixUtil.getLIst(url, Hospital.class, jsonDealMap);
					for (int j = 0; j < hospitalList.size(); j++) {
					 Hospital  p=hospitalList.get(j);
					p.setCity(r);
					try {
						hospitalMapper.insert(p);
					} catch (Exception e) {
						p.setGobus(null);
						p.setTel(null);
						try {
							hospitalMapper.insert(p);
						} catch (Exception e2) {
							e.printStackTrace();
							logger.warn("error  "+p);
						}
					}
					
					}
				}
			}
			
			/**
			 * 加载医院科室
			 */
			
			@Autowired
			DepartmentMapper departmentMapper;
		  public void loadDepartmentData(){
				String url=null;
				Map jsonDealMap = new HashMap<>();
				jsonDealMap.put(ApixUtil.FILTERFILELIST, new String[]{"sequence","id","hospital"});
				
				Map changeFileMap=new HashMap<>();
				changeFileMap.put("domain", "pinyin");
				jsonDealMap.put(ApixUtil.CHANGEFILEMAP, changeFileMap);
				List list = (List) hospitalMapper.getAll();/*5726 */
				for (int i = 0; i < list.size(); i++) {
					Hospital r=(Hospital)list.get(i);
					Long  hospital_id=r.getId();
					url="http://a.apix.cn/yi18/hospital/feature?id="+hospital_id+"";
					List<Department> departmentList=ApixUtil.getLIst(url, Department.class, jsonDealMap);
					for (int j = 0; j < departmentList.size(); j++) {
					 Department  p=departmentList.get(j);
					 p.setHospital(r);
					 try {
						 departmentMapper.insert(p);
					} catch (Exception e) {
						logger.warn("error   hospital_id:  "+hospital_id+"department: "+p);
						e.printStackTrace();
					}
				   
					}
				}
				
				
		  }
			//根据城市名字相同
			public void fixCityData(){
				 try {
					List<City> list = HttpCity.getList("chineseCities");
					for (int i = 0; i < list.size(); i++) {
						City newCity = list.get(i);
						City oldCity=cityMapper.getByName(newCity.getName());
						if(oldCity==null){
							continue;
						}
						oldCity.setPinyin(newCity.getPinyin());
						oldCity.setZip(newCity.getZip());
					    try {
							cityMapper.update(oldCity);
						} catch (Exception e) {
							logger.warn("oldCity update fail");
							e.printStackTrace();
						}
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void updateHotCityData(){
				 try {
						List<City> list = HttpCity.getList("hotCities");
						for (int i = 0; i < list.size(); i++) {
							City hotCity = list.get(i);
							City oldCity=cityMapper.getByName(hotCity.getName());
							if(oldCity==null){
								continue;
							}
							oldCity.setLevel(City.HOT_LEVEL_ONE);
						    try {
								cityMapper.update(oldCity);
							} catch (Exception e) {
								logger.warn("hotCity update fail");
								e.printStackTrace();
							}
						}
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			@Autowired 
			DoctorMapper doctorMapper;
			public void loadDoctorData() {
				try {
				List<Doctor> doctors = HttpDoctor.getList("doctors");
				
					for (Doctor doctor : doctors) {
						doctorMapper.insert(doctor);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			@Autowired
			EmployeeMapper employeeMapper;
			public void loadTestEmployeeData(){
				Employee employee;
				employee=new Employee("王大超","123","905663280@qq.com","王大超","12879830475","人民南路四段中","9999555827194505","health-type-1","123456753456");
				System.out.println(employee);
				employeeMapper.insert(employee);
			}
			
			@Autowired
			ScheduleMapper scheduleMapper;
			/*@Test*/
			public void loadTestScheduleData() throws Exception{
				Schedule schedule = new Schedule();
				schedule=new Schedule(doctorMapper.get(2L), new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-30"), 10, new BigDecimal("15.00"), 1);
				scheduleMapper.insert(schedule);
				schedule=new Schedule(doctorMapper.get(4L), new SimpleDateFormat("yyyy-MM-dd").parse("2016-02-01"), 10, new BigDecimal("10.00"), 0);
				scheduleMapper.insert(schedule);
				schedule=new Schedule(doctorMapper.get(4L), new SimpleDateFormat("yyyy-MM-dd").parse("2016-02-01"), 10, new BigDecimal("10.00"), 1);
				scheduleMapper.insert(schedule);
				schedule=new Schedule(doctorMapper.get(8L), new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-28"), 10, new BigDecimal("1.00"), 0);
				scheduleMapper.insert(schedule);
				schedule=new Schedule(doctorMapper.get(9L), new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-29"), 10, new BigDecimal("2.00"), 1);
				scheduleMapper.insert(schedule);
				
				
				
			}
			
			
}
