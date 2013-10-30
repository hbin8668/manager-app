package com.gdit.framework.manager.common.web.tags;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.gdit.framework.common.util.CollectionUtil;
import com.gdit.framework.common.vo.JsonVO;
import com.gdit.framework.manager.common.utils.Memory;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/***
 * 自定义select标签，可以通过标志去常量表取值，并且可以初始化值
 * 
 * @author EX-HUANGBIN001
 * @2012-4-25
 */
public class SelectTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String dictKey;// 常量Key值

	private String stateKey;// 状态码

	private String value;

	private String items;

	private String name;

	private String style;

	private String onchange;

	private String cssClass;

	private String id;

	private String initOption = "Y";// 初始选项 是否加入请选择选项 默认加

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			StringBuilder sb = new StringBuilder();
			sb.append("<select name=\"").append(name).append("\"\t").append("style=\"").append(style).append("\"\t");
			if (onchange != null) {
				sb.append("onchange=\"").append(onchange).append("\"");
			}
			if (cssClass != null) {
				sb.append("\tclass=\"selectbox ").append(cssClass).append("\"");
			}
			if (id != null) {
				sb.append("\tid=\"").append(id).append("\"");
			}
			sb.append(">");
			if ("Y".equals(initOption)) {
				sb.append("<option value=\"\">----请选择----</option>");
			}
			if (items != null) {
				// 如果items，items必须是JsonVO的list
				Gson gson = new Gson();
				List<JsonVO> personList = gson.fromJson(items, new TypeToken<List<JsonVO>>() {}.getType());
				if (personList.size() > 0) {
					for (JsonVO vo : personList) {
						if (vo.getCode().equals(value)) {
							sb.append("<option selected=\"selected\" value=\"").append(vo.getCode()).append("\">").append(
									vo.getMessage()).append("</option>");
						} else {
							sb.append("<option value=\"").append(vo.getCode()).append("\">").append(vo.getMessage()).append(
									"</option>");
						}
					}
				}
			} else if (dictKey != null) {
				Map<String, String> valueMap = Memory.getDictValueMap().get(dictKey);
				if (CollectionUtil.isNotEmpty(valueMap)) {
					Iterator iterator = valueMap.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry entry = (Entry) iterator.next();
						if (entry.getKey().equals(value)) {
							sb.append("<option selected=\"selected\" value=\"").append(entry.getKey()).append("\">").append(
									entry.getValue()).append("</option>");
						} else {
							sb.append("<option value=\"").append(entry.getKey()).append("\">").append(entry.getValue()).append(
									"</option>");
						}
					}
				}
			} else if (stateKey != null) {
				Map<String, String> valueMap = Memory.getStateMap().get(stateKey);
				if (CollectionUtil.isNotEmpty(valueMap)) {
					Iterator iterator = valueMap.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry entry = (Entry) iterator.next();
						if (entry.getKey().equals(value)) {
							sb.append("<option selected=\"selected\" value=\"").append(entry.getKey()).append("\">").append(
									entry.getValue()).append("</option>");
						} else {
							sb.append("<option value=\"").append(entry.getKey()).append("\">").append(entry.getValue()).append(
									"</option>");
						}
					}
				}
			}
			sb.append("</select>");
			out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getInitOption() {
		return initOption;
	}

	public void setInitOption(String initOption) {
		this.initOption = initOption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateKey() {
		return stateKey;
	}

	public void setStateKey(String stateKey) {
		this.stateKey = stateKey;
	}

}
