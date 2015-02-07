package com.my.enums;

/**
 * UserDefined Mapper
 * 
 * @author ma
 *
 */
public enum MapperEnum {
	SYS_USER(0, "SysUser", "1111111111111111111"),
	SYS_RESOURCE(1, "SysResource", "22222222222"),
	SYS_STYLE(2,"SysStyle","33333333"),
	SYS_ROLE(1, "SysRole", "444444"),;

	private Integer code;
	private String mapperName;
	private String desc;

	private MapperEnum(Integer code, String name, String desc) {
		this.code = code;
		this.mapperName = name + "Mapper";
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMapperName() {
		return mapperName;
	}

	public void setMapperName(String mapperName) {
		this.mapperName = mapperName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
