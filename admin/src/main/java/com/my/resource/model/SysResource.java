package com.my.resource.model;

import java.util.List;

import com.my.common.model.SysResources;
import com.my.common.model.SysStyles;

public class SysResource extends SysResources {

	private List<SysStyles> styles;

	public List<SysStyles> getStyles() {
		return styles;
	}

	public void setStyles(List<SysStyles> styles) {
		this.styles = styles;
	}
}
