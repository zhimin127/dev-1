package junit;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my.common.model.SysModules;
import com.my.common.model.SysResources;
import com.my.common.model.SysRoles;
import com.my.common.model.SysUsers;
import com.my.menu.model.MenuModel;
import com.my.menu.service.MenuService;
import com.my.module.service.ModuleService;
import com.my.plugin.PageInfo;
import com.my.resource.service.ResourceService;
import com.my.role.service.RoleService;
import com.my.user.service.UserService;
import com.my.utils.UUIDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-mvc.xml", "classpath:applicationContext-base.xml" })
public class Junit_admin {

	protected final Log logger = LogFactory.getLog(getClass());

	 @Autowired
	private RoleService roleService;
	// @Autowired
	private MenuService menuService;

	Map<String, Object> result;
	Gson gson;
	List<?> list;

	@Test
	public void menu() {
		List<MenuModel> menus = menuService.findAll();
		System.out.println(menus.size());
		for (MenuModel menu : menus) {
			System.out.println(json(menu.getSubMenu()));
		}
		System.out.println(json(menus));

	}

	// @Autowired
	private UserService userService;

	// @Test
	public void userRoles() {
		SysUsers user = userService.findByName("abc");
		System.out.println(json(user));
	}

	// @Test
	public void user() {
		SysUsers user = new SysUsers();
		user.setUserId(UUIDGenerator.generate());
		user.setUsername("abc");
		user.setPassword("abc");
		user.setName("管理员");
		user.setEnabled("1");
		userService.save(user);
		user = userService.findByNameAndPassword("abc", "abc");
		System.out.println(user.getCreateTime());
	}

	// @Test
	public void users() {
		PageInfo<SysUsers> page = userService.getPage(1, 10);
		System.out.println(json(page.getList()));
	}

	// @Test
	public void role() {
		SysRoles role = new SysRoles();
		role.setRoleId(UUIDGenerator.generate());
		role.setRoleName("普通用户");
		role.setRoleDesc("普通用户");
		role.setEnabled("1");
		role.setIsSys("0");
		roleService.save(role);
		// role = service.findByNameAndPassword("abc", "abc");
	}

	// @Test
	public void addUserRole() {
		roleService.addUserRole("818181ec4ad46274014ad46274080000", "818181ec4ad85c9a014ad85c9ad60000");
		// role = service.findByNameAndPassword("abc", "abc");
	}

	// @Autowired
	private ResourceService resourcesService;

	// @Test
	public void addResources() {
		SysResources resource = new SysResources();
		resource.setResourceId(UUIDGenerator.generate());
		resource.setResourceType("menu");
		resource.setResourceName("导航");
		resource.setPriority(0);
		resource.setEnabled("1");
		resource.setIsSys("1");
		resourcesService.sava(resource);
		// role = service.findByNameAndPassword("abc", "abc");
	}

	//@Autowired
	private ModuleService moduleService;

	// @Test
	public void addModule() {
		SysModules module = new SysModules();
		module.setModuleId(UUIDGenerator.generate());
		module.setModuleName("添加资源");
		module.setModuleType("2");
		module.setParent("818181ec4b02941c014b02941cf10000");
		module.setPriority(107);
		module.setEnabled("1");
		module.setLevel("2");
		moduleService.sava(module);
		// role = service.findByNameAndPassword("abc", "abc");
	}

	//@Test
	public void modules() {
		logger.info(json(moduleService.findAll()));
	}


	public String json(Object object) {
		GsonBuilder gb = new GsonBuilder();
		gb.excludeFieldsWithoutExposeAnnotation();
		// gson = gb.create();
		gson = new Gson();
		return gson.toJson(object);
	}

}
