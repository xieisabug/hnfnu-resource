package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="v_grade_group")
public class GradeGroupVo {
		//id
		private Integer id;
		//年级名称
		private String name;
		private int groupId;
		private String groupName;
		private String remark;
		
		
		public GradeGroupVo() {
			super();
		}


		public GradeGroupVo(Integer id, String name, int groupId,
				String groupName, String remark) {
			super();
			this.id = id;
			this.name = name;
			this.groupId = groupId;
			this.groupName = groupName;
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


		@Override
		public String toString() {
			return "GradeGroupVo [id=" + id + ", name=" + name + ", groupId="
					+ groupId + ", groupName=" + groupName + ", remark="
					+ remark + "]";
		}
		
		
		
}
