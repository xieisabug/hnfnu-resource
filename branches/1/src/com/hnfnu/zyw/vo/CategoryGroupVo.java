package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="v_category_group")
public class CategoryGroupVo {
		//id
		private Integer id;
		//年级名称
		private String name;
		private int groupId;
		private String groupName;
		private int ord;
		private String remark;
		public CategoryGroupVo() {
			super();
		}
		public CategoryGroupVo(Integer id, String name, int groupId,
				String groupName, int ord, String remark) {
			super();
			this.id = id;
			this.name = name;
			this.groupId = groupId;
			this.groupName = groupName;
			this.ord = ord;
			this.remark = remark;
		}




		@Id
		@GeneratedValue
		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getGroupId() {
			return groupId;
		}


		public void setGroupId(int groupId) {
			this.groupId = groupId;
		}


		public String getGroupName() {
			return groupName;
		}


		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}


		public String getRemark() {
			return remark;
		}


		public void setRemark(String remark) {
			this.remark = remark;
		}
		public int getOrd() {
			return ord;
		}
		public void setOrd(int ord) {
			this.ord = ord;
		}
		@Override
		public String toString() {
			return "CategoryGroupVo [id=" + id + ", name=" + name
					+ ", groupId=" + groupId + ", groupName=" + groupName
					+ ", ord=" + ord + ", remark=" + remark + "]";
		}
}
