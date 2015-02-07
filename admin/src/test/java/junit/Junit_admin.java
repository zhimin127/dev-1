package junit;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.common.model.SysModules;
import com.my.common.model.SysResources;
import com.my.common.model.SysRoles;
import com.my.common.model.SysStyles;
import com.my.common.model.SysUsers;
import com.my.menu.model.MenuModel;
import com.my.menu.service.MenuService;
import com.my.module.service.ModuleService;
import com.my.plugin.PageInfo;
import com.my.resource.service.SysResourceService;
import com.my.role.service.SysRoleService;
import com.my.style.service.SysStyleService;
import com.my.user.service.SysUserService;
import com.my.utils.JSONUtil;
import com.my.utils.UUIDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-mvc.xml", "classpath:applicationContext-base.xml" })
public class Junit_admin {

	protected final Log logger = LogFactory.getLog(getClass());

	Map<String, Object> result;
	List<?> list;

	@Test
	public void run() {
		//this.modifyUser();
		this.getResources();
	}

	// @Autowired
	private MenuService menuService;

	public void getMenu() {
		List<MenuModel> menus = menuService.getAll();
		System.out.println(menus.size());
		for (MenuModel menu : menus) {
			System.out.println(JSONUtil.toJson(menu.getSubMenu()));
		}
		System.out.println(JSONUtil.toJson(menus));

	}

	@Autowired
	private SysUserService sysUserService;

	public void addUser() {
		SysUsers user = new SysUsers();
		user.setUserId(UUID.randomUUID().toString());
		user.setUsername("abc");
		user.setPassword("abc");
		user.setName("管理员");
		user.setEnabled("1");
		sysUserService.save(user);
	}

	public void getUser() {
		SysUsers user = sysUserService.getByNameAndPassword("admin", "admin");
		 user = sysUserService.getByUsername("admin");
		logger.info(JSONUtil.toJson(user));

	}

	public void modifyUser() {
		SysUsers u = new SysUsers();
		u.setUsername("admin");
		u.setPassword("admin");
		sysUserService.update(u);
	}

	public void users() {
		PageInfo<SysUsers> page = sysUserService.getPage(1, 10);
		System.out.println(JSONUtil.toJson(page.getList()));
	}

	public void userRoles() {
		SysUsers user = sysUserService.getByUsername("abc");
		System.out.println(JSONUtil.toJson(user));
	}

	// @Autowired
	private SysRoleService roleService;

	public void addRole() {
		SysRoles role = new SysRoles();
		role.setRoleId(UUIDGenerator.generate());
		role.setRoleName("普通用户");
		role.setRoleDesc("普通用户");
		role.setEnabled("1");
		role.setIsSys("0");
		roleService.save(role);
		// role = roleService.getByNameAndPassword("abc", "abc");
	}

	public void addUserRole() {
		roleService.addUserRole("818181ec4ad46274014ad46274080000", "818181ec4ad85c9a014ad85c9ad60000");
		// role = service.getByNameAndPassword("abc", "abc");
	}

	@Autowired
	private SysResourceService sysResourcesService;

	public final static String[] RESOURCE_TYPES = { "0", "1", "2", "3", "4" };
	public final static String[] BASE_RESOURCES = { "导航", "首页", "用户管理", "角色管理", "资源管理" };// ,"用户列表"

	public void addResource() {
		String NAVIGATION_ID = "";
		for (int i = 0; i < BASE_RESOURCES.length; i++) {
			SysResources resource = new SysResources();
			resource.setResourceId(UUID.randomUUID().toString());
			if (i == 0) {
				NAVIGATION_ID = resource.getResourceId();
				resource.setResourceDesc("NAVIGATION");
			} else if (i <= 4 && i > 0) {
				resource.setParentId(NAVIGATION_ID);
			}
			resource.setResourceType(RESOURCE_TYPES[0]);
			resource.setResourceName(BASE_RESOURCES[i]);
			resource.setPriority(i);
			resource.setEnabled("1");
			resource.setIsSys("1");
			sysResourcesService.save(resource);
		}
	}

	public void getResources() {
		list = sysResourcesService.getNavResourceByRoleId("818181ec4ad85c9a014ad85c9ad60000");
		System.out.println(JSONUtil.toJson(list));
	}

	// @Autowired
	private ModuleService moduleService;

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
		// role = service.getByNameAndPassword("abc", "abc");
	}

	public void modules() {
		logger.info(JSONUtil.toJson(moduleService.getAll()));
	}

	@Autowired
	private SysStyleService sysStyleService;

	public void addStyle() {
		for (int i = 0; i < BASE_RESOURCES.length; i++) {
			SysStyles style = new SysStyles();
			style.setStyleId(UUID.randomUUID().toString());
			style.setStyleName(BASE_RESOURCES[i]);
			sysStyleService.save(style);
		}
	}

}
